package com.carfax.challenge.controller;

import com.carfax.challenge.error.ErrorInfoResponse;
import com.carfax.challenge.model.response.CarServiceResponse;
import com.carfax.challenge.service.CarRecordsService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
public class CarServiceRecordsController {

    @Resource
    CarRecordsService carRecordsService;

    @ApiOperation(value = "Fetch records of car services")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful Fetching of Records!", response = CarServiceResponse.class),
            @ApiResponse(code = 400, message = "Bad request: check vin", response = ErrorInfoResponse.class)
    })
    @GetMapping(value = "car/records/{vin}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<CarServiceResponse> evaluatePurchasePrices(
            @ApiParam(value = "Vehicle Identification Number", required = true)
            @PathVariable(value = "vin") String vin) {
        log.info("received request: <{}>", vin);
        final CarServiceResponse carServiceResponse = carRecordsService.getCarRecords(vin);
        log.info("Successful fetch: <{}>", carServiceResponse);
        log.info("Successful fetchrtt: <{}>", carServiceResponse);
        return ResponseEntity.ok(carServiceResponse);
    }
}
