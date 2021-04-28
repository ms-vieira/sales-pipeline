package com.salespipeline.resource;

import com.salespipeline.resource.response.PipelineResponse;
import com.salespipeline.service.PipelineService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class PipelineResourceImpl implements PipelineResource {
  private final PipelineService service;

  @Override
  public PipelineResponse converter(final String name) throws InterruptedException {
    log.info("M=converter, Converting the = {}", name);
    return new PipelineResponse(service.execute(name));
  }
}
