package com.salespipeline.service;

import static com.salespipeline.domain.Person.updateType;

import com.salespipeline.domain.Person;
import com.salespipeline.integration.judicialrecords.response.JudicialResponse;
import com.salespipeline.integration.prospectqualification.response.ProspectQualificationResponse;
import com.salespipeline.integration.registryIdentification.response.VerifyPersonResponse;
import com.salespipeline.service.validator.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PipelineServiceImpl implements PipelineService {
  private final PersonComponent personComponent;
  private final JudicialComponent judicialComponent;
  private final NationalRegistryComponent nationalRegistryComponent;
  private final MatchInformationComponent matchInformationComponent;
  private final ProspectQualificationComponent prospectQualificationComponent;

  @Override
  public String execute(final String name) throws InterruptedException {
    // Every lead exists in the sales lead CRM stage
    final Person person = personComponent.find(name);

    // The person should exist in the national registry identification external system
    final VerifyPersonResponse responseRegistry = nationalRegistryComponent.exists(person);

    // The person does not have any judicial records in the national archives
    final JudicialResponse responseJudicial = judicialComponent.hasJudicialRecord(person);

    // This system outputs a random score between 0 and 100
    final ProspectQualificationResponse responseScore =
        prospectQualificationComponent.satisfactoryScore(responseRegistry, responseJudicial);

    // their personal information should match the information stored in our local database
    return matchInformationComponent.match(responseRegistry, person)
            && responseScore.getScore() > 60
        ? updateType(person).getType().name()
        : person.getType().name();
  }
}
