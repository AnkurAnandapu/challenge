package com.carfax.challenge.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Car service Records response
 */
@Data
@ApiModel
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class CarServiceResponse {

    /**
     * List of records of car services performed on the car
     */
    List<CarServiceRecord> records;
}
