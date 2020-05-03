package com.mindex.challenge.controller;

import com.mindex.challenge.data.ReportingStruct;
import com.mindex.challenge.service.ReportingStructService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReportingStructController {
    private static final Logger LOG = LoggerFactory.getLogger(ReportingStructController.class);

    @Autowired
    private ReportingStructService reportingStructService;

    @GetMapping("/reportingStruct/{id}")
    public ReportingStruct read(@PathVariable String id){
        LOG.debug("Received reporting structure create request for id [{}]", id);
        return reportingStructService.create(id);
    }
}