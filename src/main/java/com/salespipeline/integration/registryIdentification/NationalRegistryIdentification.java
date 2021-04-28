package com.salespipeline.integration.registryIdentification;

import com.salespipeline.integration.registryIdentification.request.VerifyPersonRequest;
import com.salespipeline.integration.registryIdentification.response.VerifyPersonResponse;
import org.springframework.stereotype.Component;

@Component
public class NationalRegistryIdentification {

    public VerifyPersonResponse exists(final VerifyPersonRequest request)
            throws InterruptedException {
        Thread.sleep(200L);
        return new VerifyPersonResponse(request);
    }
}
