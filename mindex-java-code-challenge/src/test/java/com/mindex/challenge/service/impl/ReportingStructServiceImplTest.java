package com.mindex.challenge.service.impl;

import com.mindex.challenge.data.ReportingStruct;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.service.EmployeeService;
import com.mindex.challenge.service.ReportingStructService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ReportingStructServiceImplTest {
    private String employeeUrl;
    private String employeeIdUrl;
    private String reportingStructUrl;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ReportingStructService reportingStructService;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Before
    public void setup() {
        employeeUrl = "http://localhost:" + port + "/employee";
        employeeIdUrl = "http://localhost:" + port + "/employee/{id}";
        reportingStructUrl = "http://localhost:" + port + "/reportingStruct/{id}";
    }

    @Test
    public void testReportingStructure() {
        ReportingStruct reportingStruct = reportingStructService.create("16a596ae-edd3-4847-99fe-c4518e82c86f");

        int expectedNumberOfReports = 4;
        int actualNumberOfReports = reportingStruct.getNumOfReports();
        assertEquals(expectedNumberOfReports, actualNumberOfReports);
    }
}