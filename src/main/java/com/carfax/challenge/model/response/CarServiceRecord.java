package com.carfax.challenge.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Record of car services performed on the car
 */
@Data
@ApiModel
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class CarServiceRecord {

    /**
     * Vehicle Identification Number
     */
    private String vin;

    /**
     * Date of the service
     */
    private String date;

    private Integer data_provider_id;

    /**
     * Odometer reading on the corresponding date
     */
    private Integer odometer_reading;

    /**
     * List of services performed
     */
    private List<String> service_details;

    /**
     * true if the odometer needs to be rolled back
     */
    private Boolean isOdometerRollback;

}
