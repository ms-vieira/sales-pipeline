package com.salespipeline.integration.registryIdentification.request;

import com.salespipeline.domain.Person;
import com.salespipeline.domain.enums.Type;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class VerifyPersonRequest implements Serializable {
    private final String id;
    private final LocalDate birthDate;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final Type type;

    public VerifyPersonRequest(final Person person) {
        this.id = person.getId();
        this.birthDate = person.getBirthDate();
        this.firstName = person.getFirstName();
        this.lastName = person.getLastName();
        this.email = person.getEmail();
        this.type = person.getType();
    }
}
