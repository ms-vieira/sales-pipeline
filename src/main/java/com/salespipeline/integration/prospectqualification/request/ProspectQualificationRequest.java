package com.salespipeline.integration.prospectqualification.request;

import com.salespipeline.integration.judicialrecords.response.JudicialResponse;
import com.salespipeline.integration.registryIdentification.response.VerifyPersonResponse;
import java.io.Serializable;
import lombok.Data;

@Data
public class ProspectQualificationRequest implements Serializable {
  private final String id;
  private final String firstName;

  public ProspectQualificationRequest(
      final VerifyPersonResponse verifyPersonResponse, final JudicialResponse judicialResponse) {
    this.id = verifyPersonResponse.getId();
    this.firstName = verifyPersonResponse.getFirstName();
  }
}
