package com.salespipeline.integration.registryIdentification.response;

import com.salespipeline.domain.enums.Type;
import com.salespipeline.integration.registryIdentification.request.VerifyPersonRequest;
import java.io.Serializable;
import java.time.LocalDate;
import lombok.Data;

@Data
public class VerifyPersonResponse implements Serializable {
  private final String id;
  private final LocalDate birthDate;
  private final String firstName;
  private final String lastName;
  private final String email;
  private final Type type;

  public VerifyPersonResponse(final VerifyPersonRequest request) {
    this.id = request.getId();
    this.birthDate = request.getBirthDate();
    this.firstName = request.getFirstName();
    this.lastName = request.getLastName();
    this.email = request.getEmail();
    this.type = request.getType();
  }
}
