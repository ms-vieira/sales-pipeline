package com.salespipeline.service.validator;

import com.salespipeline.domain.Person;
import com.salespipeline.integration.registryIdentification.response.VerifyPersonResponse;
import org.springframework.stereotype.Component;

import static com.salespipeline.domain.Person.verify;

@Component
public class MatchInformationComponent {

    public boolean match(final VerifyPersonResponse verifyPersonResponse,
                         final Person person) {
        return verify(verifyPersonResponse, person);
    }
}
