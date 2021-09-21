package com.ebanx.takehome.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping("/event")
public class EventResource {

    private static final Logger logger = Logger.getLogger(EventResource.class.getName());

}