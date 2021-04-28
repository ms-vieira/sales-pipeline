package com.salespipeline.integration.prospectqualification;

import com.salespipeline.integration.prospectqualification.request.ProspectQualificationRequest;
import com.salespipeline.integration.prospectqualification.response.ProspectQualificationResponse;
import org.springframework.stereotype.Component;

@Component
public class ProspectQualification {

    public ProspectQualificationResponse satisfactoryScore(final ProspectQualificationRequest request) {
        return new ProspectQualificationResponse();
    }
}
