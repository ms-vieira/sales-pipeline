package com.salespipeline.service.validator;

import com.salespipeline.integration.judicialrecords.response.JudicialResponse;
import com.salespipeline.integration.prospectqualification.ProspectQualification;
import com.salespipeline.integration.prospectqualification.request.ProspectQualificationRequest;
import com.salespipeline.integration.prospectqualification.response.ProspectQualificationResponse;
import com.salespipeline.integration.registryIdentification.response.VerifyPersonResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ProspectQualificationComponent {
  private final ProspectQualification prospectQualification;

  public ProspectQualificationResponse satisfactoryScore(
      final VerifyPersonResponse verifyPersonResponse, final JudicialResponse judicialResponse) {
    log.info("M=satisfactoryScore, Fetching the scorre={} ", verifyPersonResponse);
    return prospectQualification.satisfactoryScore(
        new ProspectQualificationRequest(verifyPersonResponse, judicialResponse));
  }
}
