package com.salespipeline.resource.response;

import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PipelineResponse implements Serializable {
  private String status;

  public PipelineResponse(final String status) {
    this.status = status;
  }
}
