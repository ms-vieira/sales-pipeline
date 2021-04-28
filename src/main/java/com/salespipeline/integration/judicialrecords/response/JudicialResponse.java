package com.salespipeline.integration.judicialrecords.response;

import java.io.Serializable;
import lombok.Data;

@Data
public class JudicialResponse implements Serializable {
  private final Boolean hasJudicialRecord;
}
