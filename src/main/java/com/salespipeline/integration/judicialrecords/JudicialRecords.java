package com.salespipeline.integration.judicialrecords;

import com.salespipeline.integration.judicialrecords.request.JudicialRequest;
import com.salespipeline.integration.judicialrecords.response.JudicialResponse;
import org.springframework.stereotype.Component;

@Component
public class JudicialRecords {

  public JudicialResponse hasJudicialRecord(final JudicialRequest request)
      throws InterruptedException {
    Thread.sleep(200L);
    return new JudicialResponse(false);
  }
}
