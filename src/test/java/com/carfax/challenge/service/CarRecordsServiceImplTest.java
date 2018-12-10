package com.carfax.challenge.service;

import com.carfax.challenge.error.exception.InvalidParameterException;
import com.carfax.challenge.model.response.CarServiceRecord;
import com.carfax.challenge.model.response.CarServiceResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(value = MockitoJUnitRunner.class)
public class CarRecordsServiceImplTest {

    private final CarRecordsService carRecordsService = new CarRecordsServiceImpl();

    @Test
    public void testGetCarRecords_WithValidRequest_ShouldReturnCarRecords() {
        final CarServiceResponse actualResponse = carRecordsService.getCarRecords("VSSZZZ6JZ9R056308");
        final CarServiceResponse expectedResponse = getCarRecordsMocked();
        assertEquals(expectedResponse, actualResponse);
    }

    @Test(expected = InvalidParameterException.class)
    public void testGetCarRecords_WithInValidVin_ShouldReturnErrorResponse() {
        carRecordsService.getCarRecords("VSSZZZ6JZ9R0563082");
    }

    private CarServiceResponse getCarRecordsMocked() {
        final List<CarServiceRecord> recordList = Arrays.asList(
                CarServiceRecord.builder()
                        .vin("VSSZZZ6JZ9R056308")
                        .data_provider_id(10)
                        .date("2017-01-02")
                        .odometer_reading(10010)
                        .service_details(new ArrayList<>(Arrays.asList("Oil changed", "Tires rotated")))
                        .build(),
                CarServiceRecord.builder()
                        .data_provider_id(10)
                        .vin("VSSZZZ6JZ9R056308")
                        .date("2017-06-20")
                        .odometer_reading(12100)
                        .service_details(new ArrayList<>(Collections.singletonList("Tires replaced")))
                        .build(),
                CarServiceRecord.builder()
                        .vin("VSSZZZ6JZ9R056308")
                        .data_provider_id(10)
                        .date("2018-02-12")
                        .odometer_reading(15100)
                        .service_details(new ArrayList<>(Collections.singletonList("Windshield replaced")))
                        .build(),
                CarServiceRecord.builder()
                        .data_provider_id(10)
                        .vin("VSSZZZ6JZ9R056308")
                        .date("2018-04-01")
                        .odometer_reading(5600)
                        .service_details(new ArrayList<>(Arrays.asList("Air dam replaced",
                                "Oil service")))
                        .isOdometerRollback(true)
                        .build(),
                CarServiceRecord.builder()
                        .data_provider_id(10)
                        .vin("VSSZZZ6JZ9R056308")
                        .date("2018-06-23")
                        .odometer_reading(6400)
                        .service_details(new ArrayList<>(Arrays.asList("Rear axle oil exchanged",
                                "Engine oil pump repaired/replaced")))
                        .build()
        );
        return new CarServiceResponse(recordList);
    }


}
