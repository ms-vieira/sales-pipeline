package com.salespipeline.resource;

import com.salespipeline.resource.response.PipelineResponse;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(value = "/sales")
public interface PipelineResource {

    @PutMapping("pipeline/{name}")
    @ResponseStatus(OK)
    PipelineResponse converter(@PathVariable("name") @Valid @NotBlank(message = "Field is blank.") final String name)
            throws InterruptedException;
}
