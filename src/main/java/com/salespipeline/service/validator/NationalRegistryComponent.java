package com.salespipeline.service.validator;

import com.salespipeline.domain.Person;
import com.salespipeline.integration.registryIdentification.NationalRegistryIdentification;
import com.salespipeline.integration.registryIdentification.request.VerifyPersonRequest;
import com.salespipeline.integration.registryIdentification.response.VerifyPersonResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class NationalRegistryComponent {
  private final NationalRegistryIdentification nationalRegistryIdentification;

  @Async
  public VerifyPersonResponse exists(final Person person) throws InterruptedException {
    log.info("M=exists, Exists in national registry identification = {}", person);
    return nationalRegistryIdentification.exists(new VerifyPersonRequest(person));
  }
}
