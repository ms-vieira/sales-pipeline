package com.salespipeline.resource.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class PipelineResponse implements Serializable {
    private String status;

    public PipelineResponse(final String status) {
        this.status = status;
    }
}
