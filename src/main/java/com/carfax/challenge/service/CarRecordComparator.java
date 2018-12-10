package com.carfax.challenge.service;

import com.carfax.challenge.model.response.CarServiceRecord;

import java.time.LocalDate;
import java.util.Comparator;

class CarRecordComparator implements Comparator<CarServiceRecord> {

    /**
     *  Compare the LocalDate of Car Service Record
     * @param carServiceRecord1 {@link CarServiceRecord}
     * @param carServiceRecord2 {@link CarServiceRecord}
     * @return comparison value
     */
    @Override
    public int compare(final CarServiceRecord carServiceRecord1, final CarServiceRecord carServiceRecord2) {
        return LocalDate.parse(carServiceRecord1.getDate()).compareTo(LocalDate.parse(carServiceRecord2.getDate()));
    }
}
