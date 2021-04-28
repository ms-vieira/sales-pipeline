package com.salespipeline.integration.judicialrecords.request;

import com.salespipeline.domain.Person;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class JudicialRequest implements Serializable {
    private final LocalDate birthDate;
    private final String firstName;
    private final String lastName;
    private final String email;

    public JudicialRequest(final Person person) {
        this.birthDate = person.getBirthDate();
        this.firstName = person.getFirstName();
        this.lastName = person.getLastName();
        this.email = person.getEmail();
    }
}
