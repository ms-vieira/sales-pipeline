package com.salespipeline.resource;

import static org.springframework.http.HttpStatus.OK;

import com.salespipeline.resource.response.PipelineResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/sales")
public interface PipelineResource {

  @PutMapping("pipeline/{name}")
  @ResponseStatus(OK)
  PipelineResponse converter(
      @PathVariable("name") @Valid @NotBlank(message = "Field is blank.") final String name)
      throws InterruptedException;
}
