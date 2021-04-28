package com.salespipeline.service.validator;

import com.salespipeline.domain.Person;
import com.salespipeline.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class PersonComponent {
    private final PersonRepository repository;

    public Person find(final String name) {
        log.info("M=find, Find by name = {}", name);
        return repository.findByName(name);
    }
}
