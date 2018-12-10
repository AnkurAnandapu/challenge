package com.carfax.challenge.service;

import com.carfax.challenge.error.exception.InvalidParameterException;
import com.carfax.challenge.model.response.CarServiceRecord;
import com.carfax.challenge.model.response.CarServiceResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 * Implementation of {@link CarRecordsService}
 */

@Slf4j
@Service
public class CarRecordsServiceImpl implements CarRecordsService {


    private static final String AWS_URL = "https://s3-eu-west-1.amazonaws.com/coding-challenge.carfax.eu/";

    @Override
    public CarServiceResponse getCarRecords(final String vin) {
        final CarServiceResponse carServiceResponse = getCarDetails(vin);
        carServiceResponse.getRecords().sort(new CarRecordComparator());
        updateOdometerRollback(carServiceResponse);
        return carServiceResponse;
    }

    private void updateOdometerRollback(final CarServiceResponse carServiceResponse) {
        Integer odometerReading = Integer.MIN_VALUE;
        for (CarServiceRecord carServiceRecord : carServiceResponse.getRecords()) {
            if (carServiceRecord.getOdometer_reading() > odometerReading) {
                odometerReading = carServiceRecord.getOdometer_reading();
            } else {
                odometerReading = carServiceRecord.getOdometer_reading();
                carServiceRecord.setIsOdometerRollback(true);
            }
        }
    }

    private CarServiceResponse getCarDetails(final String vin) {

        final RestTemplate restTemplate = new RestTemplate();
        try{
            return restTemplate.getForObject(AWS_URL + vin, CarServiceResponse.class);
        } catch (RestClientException e){

            log.error("Cannot fetch Car service records from S3 for VIN: <{}>",vin);
            throw new InvalidParameterException(String.format("Cannot fetch Car service records from S3 for VIN: %s",vin));
        }
    }


}
