package com.salespipeline.integration.judicialrecords.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class JudicialResponse implements Serializable {
    private final Boolean hasJudicialRecord;

}
