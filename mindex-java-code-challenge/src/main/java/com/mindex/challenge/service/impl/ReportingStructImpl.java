package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStruct;
import com.mindex.challenge.service.ReportingStructService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import java.util.UUID;

@Service
public class ReportingStructImpl implements ReportingStructService {

    private static final Logger LOG = LoggerFactory.getLogger(ReportingStructImpl.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public ReportingStruct create(String id){
        LOG.debug("Creating reporting structure for employee [{}] ",id);
        Employee employee = employeeRepository.findByEmployeeId(id);
        int numReports = calculateNumberOfReports(employee);
        return new ReportingStruct(employee,numReports);
    }

    private int calculateNumberOfReports(Employee employee){
        int numReports = 0;
        if(!CollectionUtils.isEmpty(employee.getDirectReports())){
            numReports = employee.getDirectReports().size();

            for(Employee reports: employee.getDirectReports()){
                numReports += calculateNumberOfReports((employeeRepository.findByEmployeeId(reports.getEmployeeId())));
            }
        }
        return numReports;
    }
}