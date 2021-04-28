package com.salespipeline.integration.prospectqualification.response;

import java.io.Serializable;
import java.util.Random;
import lombok.Data;

@Data
public class ProspectQualificationResponse implements Serializable {
  private final Integer score;

  public ProspectQualificationResponse() {
    this.score = mockRandom();
  }

  public ProspectQualificationResponse(final Integer score) {
    this.score = score;
  }

  private int mockRandom() {
    final Random random = new Random();
    return random.ints(0, 100).findFirst().getAsInt();
  }
}
