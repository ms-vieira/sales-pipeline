package com.salespipeline.repository;

import static com.salespipeline.domain.Person.buildMock;

import com.salespipeline.domain.Person;
import org.springframework.stereotype.Component;

@Component
public class PersonRepository {
  public Person findByName(final String name) {
    return buildMock();
  }
}
