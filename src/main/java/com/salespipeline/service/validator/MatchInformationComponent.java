package com.salespipeline.service.validator;

import static com.salespipeline.domain.Person.verify;

import com.salespipeline.domain.Person;
import com.salespipeline.integration.registryIdentification.response.VerifyPersonResponse;
import org.springframework.stereotype.Component;

@Component
public class MatchInformationComponent {

  public boolean match(final VerifyPersonResponse verifyPersonResponse, final Person person) {
    return verify(verifyPersonResponse, person);
  }
}
