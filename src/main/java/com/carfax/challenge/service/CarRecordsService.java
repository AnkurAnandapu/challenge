package com.carfax.challenge.service;

import com.carfax.challenge.model.response.CarServiceResponse;

/**
 * Get Car Service Record
 */
public interface CarRecordsService {

    /**
     * Fetch Car service records from S3 and update odometer rollback field
     *
     * @param vin Vehicle Identification Number
     * @return {@link CarServiceResponse}
     */
    CarServiceResponse getCarRecords(String vin);
}
