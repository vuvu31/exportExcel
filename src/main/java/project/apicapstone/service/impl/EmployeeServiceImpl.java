package project.apicapstone.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import project.apicapstone.common.util.ResponseHandler;
import project.apicapstone.dto.employee.CreateEmployeeDto;
import project.apicapstone.dto.employee.PagingFormatEmployeeDto;
import project.apicapstone.dto.employee.UpdateEmployeeDto;
import project.apicapstone.entity.Employee;
import project.apicapstone.entity.Title;
import project.apicapstone.entity.Workplace;
import project.apicapstone.entity.util.WorkingStatus;
import project.apicapstone.repository.EmployeeRepository;
import project.apicapstone.repository.TitleRepository;
import project.apicapstone.repository.WorkplaceRepository;
import project.apicapstone.service.EmployeeService;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;

import java.util.Date;
import java.util.List;

import static java.time.temporal.TemporalAdjusters.next;
import static java.time.temporal.TemporalAdjusters.previousOrSame;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    private TitleRepository titleRepository;
    private WorkplaceRepository workplaceRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, TitleRepository titleRepository, WorkplaceRepository workplaceRepository) {
        this.employeeRepository = employeeRepository;
        this.titleRepository = titleRepository;
        this.workplaceRepository = workplaceRepository;
    }

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepository.findAllEmp(pageable);
    }

    @Override
    public List<Employee> findEmployeeByName(String employeeName) {
        List<Employee> employeeList = employeeRepository.findEmployeesByEmployeeNameContains(employeeName);
        if (employeeList.size() == 0) {
            //throw new ResourceNotFoundException("");
            throw new IllegalStateException("Name not exists!");
        }
        return employeeList;
    }

    @Override
    public Employee addNewEmployee(CreateEmployeeDto dto) {
        Employee addEmployee = new Employee();
        addEmployee.setEmployeeId(dto.getEmployeeId());
        addEmployee.setEmployeeName(dto.getEmployeeName());
        addEmployee.setDateBirth(dto.getDateBirth());
        addEmployee.setPlaceBirth(dto.getPlaceBirth());
        addEmployee.setPhone(dto.getPhone());
        addEmployee.setGender(dto.getGender());
        addEmployee.setAddress(dto.getAddress());
        addEmployee.setEmail(dto.getEmail());
        addEmployee.setNationality(dto.getNationality());
        addEmployee.setReligion(dto.getReligion());
        addEmployee.setEthnic(dto.getEthnic());
        addEmployee.setAcademicLevel(dto.getAcademicLevel());
        addEmployee.setBank(dto.getBank());
        addEmployee.setBankAccountNo(dto.getBankAccountNo());
        addEmployee.setTaxIdentificationNo(dto.getTaxIdentificationNo());
        addEmployee.setMaritalStatus(dto.getMaritalStatus());
        addEmployee.setWorkingStatus(dto.getWorkingStatus());
        addEmployee.setAvatar(dto.getAvatar());

        addEmployee.setCreateDate(LocalDate.now());
//        addEmployee.setCreateDate(dto.getCreateDate());
        addEmployee.setUpdateDate(LocalDate.now());

        addEmployee.setDayOfBirth(dto.getDateBirth().getDayOfMonth());
        addEmployee.setMonthOfBirth(dto.getDateBirth().getMonth().getValue());

        addEmployee.setBackIdentityCard(dto.getBackIdentityCard());
        addEmployee.setFrontIdentityCard(dto.getFrontIdentityCard());

        addEmployee.setWorkplace(workplaceRepository.getById(dto.getWorkplaceId()));

        Title title = titleRepository.getById(dto.getTitleId());
        addEmployee.setTitle(title);
        return employeeRepository.save(addEmployee);
    }


    @Override
    public List<Employee> findEmployeeByNameOrId(String paramSearch) {
        List<Employee> listSearch = employeeRepository.findEmployeesByNameOrId(paramSearch);
        return listSearch;
    }

    @Override
    public boolean isExisted(String id) {
        return employeeRepository.existsById(id);
    }

    @Override
    public List<Employee> findAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public void deleteById(String id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee findEmployeeById(String id) {
        return employeeRepository.getById(id);
    }

    @Override
    public void updateEmployee(UpdateEmployeeDto dto, String id) {
        Employee updateEmployee = employeeRepository.getById(id);
        updateEmployee.setEmployeeName(dto.getEmployeeName());
        updateEmployee.setDateBirth(dto.getDateBirth());
        updateEmployee.setPlaceBirth(dto.getPlaceBirth());
        updateEmployee.setPhone(dto.getPhone());
        updateEmployee.setGender(dto.getGender());
        updateEmployee.setAddress(dto.getAddress());
        updateEmployee.setEmail(dto.getEmail());
        updateEmployee.setNationality(dto.getNationality());
        updateEmployee.setReligion(dto.getReligion());
        updateEmployee.setEthnic(dto.getEthnic());
        updateEmployee.setBank(dto.getBank());
        updateEmployee.setBankAccountNo(dto.getBankAccountNo());
        updateEmployee.setTaxIdentificationNo(dto.getTaxIdentificationNo());
        updateEmployee.setAcademicLevel(dto.getAcademicLevel());
        updateEmployee.setMaritalStatus(dto.getMaritalStatus());
        updateEmployee.setWorkingStatus(dto.getWorkingStatus());
        updateEmployee.setAvatar(dto.getAvatar());
        updateEmployee.setUpdateDate(LocalDate.now());
        updateEmployee.setBackIdentityCard(dto.getBackIdentityCard());
        updateEmployee.setFrontIdentityCard(dto.getFrontIdentityCard());
        updateEmployee.setTitle(titleRepository.getById(dto.getTitleId()));
        employeeRepository.save(updateEmployee);
    }


    @Override
    public PagingFormatEmployeeDto pagingFormat(Page<Employee> employeePage) {
        PagingFormatEmployeeDto dto = new PagingFormatEmployeeDto();
        dto.setPageSize(employeePage.getSize());
        dto.setTotalRecordCount(employeePage.getTotalElements());
        dto.setPageNumber(employeePage.getNumber());
        dto.setRecords(employeePage.toList());
        return dto;
    }

    @Override
    public int countByWeek() {
        LocalDate lastDay = getEndDateOfWeek();
        LocalDate firstDay = getStartDateOfWeek();
        int count = employeeRepository.countByCreateDateBetweenAndWorkingStatusNotContains(firstDay, lastDay, "Nghỉ việc");
        return count;
    }

    //    public int get
    public LocalDate getEndDateOfWeek() {
        LocalDate date = LocalDate.now();
        LocalDate lastDay = date.with(next(DayOfWeek.SUNDAY));
        System.out.println("End date of week: " + lastDay);
        return lastDay;
    }

    public LocalDate getStartDateOfWeek() {
        LocalDate date = LocalDate.now();
        LocalDate firstDay = date.with(previousOrSame(DayOfWeek.MONDAY));
        //LocalDate date = LocalDate.of(2021, 11, 1);
        System.out.println("Start date of week: " + firstDay);
        return firstDay;
    }

    public LocalDate getEndDateOfMonth() {
        LocalDate date = LocalDate.now();
        //LocalDate date = LocalDate.of(2021, 11, 1);
        LocalDate lastDay = date.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println("End date of month:" + lastDay);
        return lastDay;
    }

    public LocalDate getStartDateOfMonth() {
        LocalDate date = LocalDate.now();
        //LocalDate date = LocalDate.of(2021, 11, 1);
        LocalDate firstDay = date.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println("Start date of month:" + firstDay);
        return firstDay;
    }

    public LocalDate getEndDateOfYear() {
        LocalDate date = LocalDate.now();
        //LocalDate date = LocalDate.of(2021, 11, 1);
        LocalDate lastDay = date.with(TemporalAdjusters.lastDayOfYear());
        System.out.println("Last date of year: " + lastDay);
        return lastDay;
    }

    public LocalDate getStartDateOfYear() {
        LocalDate date = LocalDate.now();
        //LocalDate date = LocalDate.of(2021, 11, 1);
        LocalDate startDay = date.with(TemporalAdjusters.firstDayOfYear());
        System.out.println("First date of year: " + startDay);
        return startDay;
    }

//    @Override
//    public int countByMonth() {
//        LocalDate lastDay = getEndDateOfMonth();
//        LocalDate firstDay = getStartDateOfMonth();
////        int count = employeeRepository.countByCreateDateBetween(firstDay, lastDay);
////        return count;
//        return 1;
//    }

    @Override
    public int countByYear() {
        LocalDate lastDay = getEndDateOfYear();
        LocalDate firstDay = getStartDateOfYear();

        //  return employeeRepository.countByCreateDateBetween(firstDay, lastDay);
        return 1;
    }

    @Override
    public int countAll() {
        return employeeRepository.countAll();
    }

    @Override
    public int countByStatus(String status) {
        return employeeRepository.countEmployeeByWorkingStatus(status);
    }

    public int getYear() {
        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return localDate.getYear();
    }


    @Override
    public int[] countByMonth() {
        int[] a;

        LocalDate dateOfJan = LocalDate.of(getYear(), 1, 1);
        LocalDate startDayOfJan = dateOfJan.with(TemporalAdjusters.firstDayOfMonth());
        LocalDate lastDayOfJan = dateOfJan.with(TemporalAdjusters.lastDayOfMonth());
        int month1 = employeeRepository.countByCreateDateBetween(startDayOfJan, lastDayOfJan);

        LocalDate dateOfFer = LocalDate.of(getYear(), 2, 1);
        LocalDate lastDayOfFer = dateOfFer.with(TemporalAdjusters.lastDayOfMonth());
        int month2 = employeeRepository.countByCreateDateBetween(startDayOfJan, lastDayOfFer);

        LocalDate dateOfMarch = LocalDate.of(getYear(), 3, 1);
        LocalDate lastDayOfMarch = dateOfMarch.with(TemporalAdjusters.lastDayOfMonth());
        int month3 = employeeRepository.countByCreateDateBetween(startDayOfJan, lastDayOfMarch);

        LocalDate dateOfApril = LocalDate.of(getYear(), 4, 1);
        LocalDate lastDayOfApril = dateOfApril.with(TemporalAdjusters.lastDayOfMonth());
        int month4 = employeeRepository.countByCreateDateBetween(startDayOfJan, lastDayOfApril);

        LocalDate dateOfMay = LocalDate.of(getYear(), 5, 1);
        LocalDate lastDayOfMay = dateOfMay.with(TemporalAdjusters.lastDayOfMonth());
        int month5 = employeeRepository.countByCreateDateBetween(startDayOfJan, lastDayOfMay);

        LocalDate dateOfJune = LocalDate.of(getYear(), 6, 1);
        LocalDate lastDayOfJune = dateOfJune.with(TemporalAdjusters.lastDayOfMonth());
        int month6 = employeeRepository.countByCreateDateBetween(startDayOfJan, lastDayOfJune);

        LocalDate dateOfJuly = LocalDate.of(getYear(), 7, 1);
        LocalDate lastDayOfJuly = dateOfJuly.with(TemporalAdjusters.lastDayOfMonth());
        int month7 = employeeRepository.countByCreateDateBetween(startDayOfJan, lastDayOfJuly);

        LocalDate dateOfAug = LocalDate.of(getYear(), 8, 1);
        LocalDate lastDayOfAug = dateOfAug.with(TemporalAdjusters.lastDayOfMonth());
        int month8 = employeeRepository.countByCreateDateBetween(startDayOfJan, lastDayOfAug);

        LocalDate dateOfSep = LocalDate.of(getYear(), 9, 1);
        LocalDate lastDayOfSep = dateOfSep.with(TemporalAdjusters.lastDayOfMonth());
        int month9 = employeeRepository.countByCreateDateBetween(startDayOfJan, lastDayOfSep);

        LocalDate dateOfOc = LocalDate.of(getYear(), 10, 1);
        LocalDate lastDayOfOc = dateOfOc.with(TemporalAdjusters.lastDayOfMonth());
        int month10 = employeeRepository.countByCreateDateBetween(startDayOfJan, lastDayOfOc);

        LocalDate dateOfNov = LocalDate.of(getYear(), 11, 1);
        LocalDate lastDayOfNov = dateOfNov.with(TemporalAdjusters.lastDayOfMonth());
        int month11 = employeeRepository.countByCreateDateBetween(startDayOfJan, lastDayOfNov);

        LocalDate dateOfDec = LocalDate.of(getYear(), 12, 1);
        LocalDate lastDayOfDec = dateOfDec.with(TemporalAdjusters.lastDayOfMonth());
        int month12 = employeeRepository.countByCreateDateBetween(startDayOfJan, lastDayOfDec);

        return new int[]{month1, month2, month3, month4, month5, month6, month7, month8, month9, month10, month11, month12};
    }

    @Override
    public int[] countByMonthWithStatus(String status) {
        int[] a;

        LocalDate dateOfJan = LocalDate.of(getYear(), 1, 1);
        LocalDate startDayOfJan = dateOfJan.with(TemporalAdjusters.firstDayOfMonth());
        LocalDate lastDayOfJan = dateOfJan.with(TemporalAdjusters.lastDayOfMonth());

        int month1 = employeeRepository.countByUpdateDateBetweenAndWorkingStatus(startDayOfJan, lastDayOfJan, status);

        LocalDate dateOfFer = LocalDate.of(getYear(), 2, 1);
        LocalDate lastDayOfFer = dateOfFer.with(TemporalAdjusters.lastDayOfMonth());
        int month2 = employeeRepository.countByUpdateDateBetweenAndWorkingStatus(startDayOfJan, lastDayOfFer, status);

        LocalDate dateOfMarch = LocalDate.of(getYear(), 3, 1);
        LocalDate lastDayOfMarch = dateOfMarch.with(TemporalAdjusters.lastDayOfMonth());
        int month3 = employeeRepository.countByUpdateDateBetweenAndWorkingStatus(startDayOfJan, lastDayOfMarch, status);

        LocalDate dateOfApril = LocalDate.of(getYear(), 4, 1);
        LocalDate lastDayOfApril = dateOfApril.with(TemporalAdjusters.lastDayOfMonth());
        int month4 = employeeRepository.countByUpdateDateBetweenAndWorkingStatus(startDayOfJan, lastDayOfApril, status);

        LocalDate dateOfMay = LocalDate.of(getYear(), 5, 1);
        LocalDate lastDayOfMay = dateOfMay.with(TemporalAdjusters.lastDayOfMonth());
        int month5 = employeeRepository.countByUpdateDateBetweenAndWorkingStatus(startDayOfJan, lastDayOfMay, status);

        LocalDate dateOfJune = LocalDate.of(getYear(), 6, 1);
        LocalDate lastDayOfJune = dateOfJune.with(TemporalAdjusters.lastDayOfMonth());
        int month6 = employeeRepository.countByUpdateDateBetweenAndWorkingStatus(startDayOfJan, lastDayOfJune, status);

        LocalDate dateOfJuly = LocalDate.of(getYear(), 7, 1);
        LocalDate lastDayOfJuly = dateOfJuly.with(TemporalAdjusters.lastDayOfMonth());
        int month7 = employeeRepository.countByUpdateDateBetweenAndWorkingStatus(startDayOfJan, lastDayOfJuly, status);

        LocalDate dateOfAug = LocalDate.of(getYear(), 8, 1);
        LocalDate lastDayOfAug = dateOfAug.with(TemporalAdjusters.lastDayOfMonth());
        int month8 = employeeRepository.countByUpdateDateBetweenAndWorkingStatus(startDayOfJan, lastDayOfAug, status);

        LocalDate dateOfSep = LocalDate.of(getYear(), 9, 1);
        LocalDate lastDayOfSep = dateOfSep.with(TemporalAdjusters.lastDayOfMonth());
        int month9 = employeeRepository.countByUpdateDateBetweenAndWorkingStatus(startDayOfJan, lastDayOfSep, status);

        LocalDate dateOfOc = LocalDate.of(getYear(), 10, 1);
        LocalDate lastDayOfOc = dateOfOc.with(TemporalAdjusters.lastDayOfMonth());
        int month10 = employeeRepository.countByUpdateDateBetweenAndWorkingStatus(startDayOfJan, lastDayOfOc, status);

        LocalDate dateOfNov = LocalDate.of(getYear(), 11, 1);
        LocalDate lastDayOfNov = dateOfNov.with(TemporalAdjusters.lastDayOfMonth());
        int month11 = employeeRepository.countByUpdateDateBetweenAndWorkingStatus(startDayOfJan, lastDayOfNov, status);

        LocalDate dateOfDec = LocalDate.of(getYear(), 12, 1);
        LocalDate lastDayOfDec = dateOfDec.with(TemporalAdjusters.lastDayOfMonth());
        int month12 = employeeRepository.countByUpdateDateBetweenAndWorkingStatus(startDayOfJan, lastDayOfDec, status);

        return new int[]{month1, month2, month3, month4, month5, month6, month7, month8, month9, month10, month11, month12};
    }

    @Override
    public List<Employee> getBirth() {
        LocalDate date = LocalDate.now();
        int day = date.getDayOfMonth();
        int month = date.getMonthValue();
        return employeeRepository.getAllByDayOfBirthAndMonthOfBirth(day, month);
    }
}
