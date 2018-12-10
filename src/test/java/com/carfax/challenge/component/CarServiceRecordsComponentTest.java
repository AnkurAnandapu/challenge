package com.carfax.challenge.component;


import com.carfax.challenge.BaseComponentTest;
import org.junit.Test;

import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Component tests for car/records/{vin} endpoint
 */
public class CarServiceRecordsComponentTest extends BaseComponentTest {

    @Test
    public void whenValidRequest_ShouldReturnCarServiceRecords() throws Exception {
        getMockMvc().perform(get("/car/records/{vin}", "VSSZZZ6JZ9R056308"))
                .andDo(print())
                .andDo(mvcResult -> System.out.println(mvcResult.getResponse()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.records", hasSize(5)))
                .andExpect(jsonPath("$.records[3].isOdometerRollback", equalTo(true)))
        ;
    }

    @Test
    public void whenInValidVin_ShouldReturnErrorResponse() throws Exception {
        getMockMvc().perform(get("/car/records/{vin}", "invalid"))
                .andDo(print())
                .andDo(mvcResult -> System.out.println(mvcResult.getResponse()))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.url", endsWith("/car/records/invalid")))
                .andExpect(jsonPath("$.errorCode", equalTo("400")))
                .andExpect(jsonPath("$.exception", equalTo("InvalidParameterException")))
                .andExpect(jsonPath("$.message", equalTo("Cannot fetch Car service records from S3 for VIN: invalid")))
        ;
    }

}
