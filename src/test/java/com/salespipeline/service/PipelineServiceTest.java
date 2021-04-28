package com.salespipeline.service;

import com.salespipeline.domain.Person;
import com.salespipeline.integration.judicialrecords.response.JudicialResponse;
import com.salespipeline.integration.prospectqualification.response.ProspectQualificationResponse;
import com.salespipeline.integration.registryIdentification.request.VerifyPersonRequest;
import com.salespipeline.integration.registryIdentification.response.VerifyPersonResponse;
import com.salespipeline.service.validator.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static com.salespipeline.domain.enums.Type.LEAD;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PipelineServiceTest {

    @Mock
    private PersonComponent personComponent;
    @Mock
    private JudicialComponent judicialComponent;
    @Mock
    private NationalRegistryComponent nationalRegistryComponent;
    @Mock
    private MatchInformationComponent matchInformationComponent;
    @Mock
    private ProspectQualificationComponent prospectQualificationComponent;
    @InjectMocks
    private PipelineServiceImpl pipelineService;

    @Test
    void should_run_the_sales_pipeline_and_return_the_customers_status_update() throws InterruptedException {
        final String name = "Chris";
        when(personComponent.find(name)).thenReturn(personMock());
        when(nationalRegistryComponent.exists(personMock())).thenReturn(verifyMock());
        when(judicialComponent.hasJudicialRecord(personMock())).thenReturn(judicialMock());
        when(prospectQualificationComponent.satisfactoryScore(verifyMock(), judicialMock()))
                .thenReturn(new ProspectQualificationResponse(65));
        when(matchInformationComponent.match(verifyMock(), personMock())).thenReturn(true);

        assertDoesNotThrow(() -> pipelineService.execute(name));
        verify(personComponent).find(name);
        verify(nationalRegistryComponent).exists(personMock());
        verify(judicialComponent).hasJudicialRecord(personMock());
        verify(prospectQualificationComponent).satisfactoryScore(verifyMock(), judicialMock());
        verify(matchInformationComponent).match(verifyMock(), personMock());
    }

    @Test
    void should_run_the_sales_pipeline_and_return_the_customers_status() throws InterruptedException {
        final String name = "Chris";
        when(personComponent.find(name)).thenReturn(personMock());
        when(nationalRegistryComponent.exists(personMock())).thenReturn(verifyMock());
        when(judicialComponent.hasJudicialRecord(personMock())).thenReturn(judicialMock());
        when(prospectQualificationComponent.satisfactoryScore(verifyMock(), judicialMock()))
                .thenReturn(new ProspectQualificationResponse(20));
        when(matchInformationComponent.match(verifyMock(), personMock())).thenReturn(true);

        assertDoesNotThrow(() -> pipelineService.execute(name));
        verify(personComponent).find(name);
        verify(nationalRegistryComponent).exists(personMock());
        verify(judicialComponent).hasJudicialRecord(personMock());
        verify(prospectQualificationComponent).satisfactoryScore(verifyMock(), judicialMock());
        verify(matchInformationComponent).match(verifyMock(), personMock());
    }


    private Person personMock() {
        return new Person("1234-lead-crm",
                LocalDate.of(1990, 4, 28),
                "Chris",
                "Brown",
                "chris@brown.com",
                LEAD);
    }

    private VerifyPersonResponse verifyMock() {
        return new VerifyPersonResponse(new VerifyPersonRequest(personMock()));
    }

    private JudicialResponse judicialMock() {
        return new JudicialResponse(false);
    }

}