package com.orangeguinee.opsmock;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ProvisioningMockControllerTest {

    @Autowired
    private MockMvc mvc;

    private static final String BODY = "{\"requestId\":\"109123\",\"typeAction\":\"CREATION_ACTIVATION_PREPAID_AUC_4G\","
        + "\"msisdn\":\"620000000\",\"imsi\":\"611012050000001\",\"productCode\":\"5\",\"kiAuc\":\"ABCDEF\"}";

    @Test
    void retourneSucces() throws Exception {
        mvc.perform(post("/ops/provisioning?login=test&pass=test").contentType(MediaType.APPLICATION_JSON).content(BODY))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.status").value("0"))
            .andExpect(jsonPath("$.message").value("HLR : Success | OCS : Success | PCRF : Success"))
            .andExpect(jsonPath("$.responses.length()").value(9));
    }

    @Test
    void refuseMauvaisIdentifiants() throws Exception {
        mvc.perform(post("/ops/provisioning?login=x&pass=y").contentType(MediaType.APPLICATION_JSON).content(BODY))
            .andExpect(status().isUnauthorized());
    }

    @Test
    void refuseMsisdnManquant() throws Exception {
        mvc.perform(post("/ops/provisioning?login=test&pass=test").contentType(MediaType.APPLICATION_JSON)
                .content("{\"requestId\":\"1\",\"typeAction\":\"CREATION_ACTIVATION_PREPAID_AUC_4G\",\"imsi\":\"6110\"}"))
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.status").value("1"));
    }
}
