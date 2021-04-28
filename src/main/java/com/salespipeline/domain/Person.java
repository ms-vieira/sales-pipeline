package com.salespipeline.domain;

import static com.salespipeline.domain.enums.Type.LEAD;
import static com.salespipeline.domain.enums.Type.PROSPECT_CLIENT;

import com.salespipeline.domain.enums.Type;
import com.salespipeline.integration.registryIdentification.response.VerifyPersonResponse;
import java.time.LocalDate;
import lombok.Data;

@Data
public class Person {
  private final String id;
  private final LocalDate birthDate;
  private final String firstName;
  private final String lastName;
  private final String email;
  private final Type type;

  public static Person buildMock() {
    return new Person(
        "1234-lead-crm", LocalDate.of(1990, 4, 28), "Chris", "Brown", "chris@brown.com", LEAD);
  }

  public static boolean verify(
      final VerifyPersonResponse verifyPersonResponse, final Person person) {
    return verifyPersonResponse.getId().equals(person.getId())
        && verifyPersonResponse.getBirthDate().equals(person.getBirthDate())
        && verifyPersonResponse.getFirstName().equals(person.getFirstName())
        && verifyPersonResponse.getLastName().equals(person.getLastName())
        && verifyPersonResponse.getEmail().equals(person.getEmail());
  }

  public static Person updateType(final Person person) {
    return new Person(
        person.getId(),
        person.getBirthDate(),
        person.getFirstName(),
        person.getLastName(),
        person.getEmail(),
        PROSPECT_CLIENT);
  }
}
