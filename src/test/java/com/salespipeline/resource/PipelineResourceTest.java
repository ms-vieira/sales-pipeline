package com.salespipeline.resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.salespipeline.resource.response.PipelineResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PipelineResourceTest {
    private static String NAME = "Chris";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void should_run_the_sales_pipeline_and_return_the_customers_status_update() throws Exception {
        final MvcResult result = getStatusClient().andExpect(status().isOk()).andReturn();
        final PipelineResponse response = of(result, PipelineResponse.class);
        assertNotNull(response);
        assertNotNull(response.getStatus());
    }

    private ResultActions getStatusClient() throws Exception {
        MockHttpServletRequestBuilder builder = put(String.format("/sales/pipeline/%s", NAME))
                .contentType(APPLICATION_JSON)
                .accept(APPLICATION_JSON);
        return mockMvc.perform(builder);
    }


    private <T> T of(MvcResult result, Class<T> tClass) throws Exception {
        return this.mapper.readValue(result.getResponse().getContentAsString(), tClass);
    }

}