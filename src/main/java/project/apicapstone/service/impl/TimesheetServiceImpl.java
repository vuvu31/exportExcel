package project.apicapstone.service.impl;

import org.springframework.stereotype.Service;
import project.apicapstone.repository.TimesheetRepository;
import project.apicapstone.service.TimesheetService;
@Service
public class TimesheetServiceImpl implements TimesheetService {
    private TimesheetRepository timesheetRepository;
    public TimesheetServiceImpl(TimesheetRepository timesheetRepository){
        this.timesheetRepository=timesheetRepository;
    }
}
