package com.salespipeline.repository;

import com.salespipeline.domain.Person;
import org.springframework.stereotype.Component;

import static com.salespipeline.domain.Person.buildMock;

@Component
public class PersonRepository {
    public Person findByName(final String name) {
        return buildMock();
    }
}
