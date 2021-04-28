package com.salespipeline.service.validator;

import com.salespipeline.domain.Person;
import com.salespipeline.integration.judicialrecords.JudicialRecords;
import com.salespipeline.integration.judicialrecords.request.JudicialRequest;
import com.salespipeline.integration.judicialrecords.response.JudicialResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class JudicialComponent {
    private final JudicialRecords judicialRecords;

    @Async
    public JudicialResponse hasJudicialRecord(final Person person) throws InterruptedException {
        log.info("M=hasJudicialRecord, Has judicial record = {}", person);
        return judicialRecords.hasJudicialRecord(new JudicialRequest(person));
    }

}
