package com.nagarro.springmvc.service;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.google.gson.Gson;
import com.nagarro.springmvc.model.Employee;

@Service
public class EmployeeService {
	@Autowired
	RestTemplate restTemplate;
	
	public List<Employee> getEmployee(){
//		String str=restTemplate.getForObject("http://localhost:8081/employees/", String.class);
//		Gson g=new Gson();
//		Employee[] employeeList=g.fromJson(str,Employee[].class);
		
		Employee[] employees=restTemplate.getForObject("http://localhost:8081/employees/", Employee[].class);
		//Employee[] employees=restTemplate.getForObject("http://localhost:8081/employees", Employee[].class);
		//System.out.println(str);
		for(Employee employee:employees) {
			System.out.println(employee);
		}
		return Arrays.asList(employees);
	}
	public void uploadEmployee(Employee employee) {
		System.out.println(employee);
		employee=restTemplate.postForObject("http://localhost:8081/employees", employee,Employee.class);
		
	}
	public void editEmpDetail(Employee employee) {
		System.out.println("edit ke liye method mai aa raha ahi ");
		
        restTemplate.put("http://localhost:8081/employees", employee, Employee.class);
	}
	public void downloadDetail(HttpServletResponse response) throws IOException {
		response.setContentType("text/csv");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String currentDateTime = dateFormatter.format(new Date());
        String fileName = "employee.csv";
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; fileName=" + fileName;
        response.setHeader(headerKey, headerValue);
        
        List<Employee> listEmployees = getEmployee();
        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
        String[] csvHeader = { "employee_code", "date_of_birth", "email", "employee_name", "location" };
        String[] nameMapping = { "eCode", "dob", "email", "eName", "location" };
        csvWriter.writeHeader(csvHeader);
        for (Employee employee : listEmployees) {
            csvWriter.write(employee, nameMapping);
        }
        csvWriter.close();
	}
}
