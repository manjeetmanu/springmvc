package com.nagarro.springmvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.springmvc.model.Employee;
import com.nagarro.springmvc.service.EmployeeService;

@Controller
public class EmpController {

	@Autowired
	EmployeeService employeeService;
	
//	@RequestMapping("/processuploadform")
//	public String showForm() {
//		
//		return "uploadEmployee";
//	}
	@RequestMapping("/processuploadform")
	public String showForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String action = request.getParameter("action");
		if ("upload".equals(action)) {
			return "uploadEmployee";
		} else if ("download".equals(action)) {
		    employeeService.downloadDetail(response);
		}
		return "login-success";
	}

	@PostMapping("/editempform")
	public ModelAndView editMethod(@ModelAttribute("employee") Employee employee, HttpSession session) {	
		employeeService.editEmpDetail(employee);
		List<Employee> employees=employeeService.getEmployee();
		ModelAndView mv = new ModelAndView();
		mv.addObject("userName", session.getAttribute("userName"));
		mv.addObject("list", employees);
		mv.setViewName("login-success");
		return mv;
	}
	

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView formHandler3(@PathVariable("id") int id) {
		System.out.println(id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("id", id);
		mv.setViewName("edit");
		return mv;
	}
	@PostMapping("/uploadform")
	public ModelAndView editForm(@ModelAttribute("employee") Employee employee, HttpSession session) {
//		Map<String, Long> params = new HashMap<String, Long>();
//		params.put("id", employee.geteCode());
		//restTemplate.
		employeeService.uploadEmployee(employee);
		List<Employee> employees=employeeService.getEmployee();
		ModelAndView mv = new ModelAndView();
		mv.addObject("userName", session.getAttribute("userName"));
		mv.addObject("list", employees);
		mv.setViewName("login-success");
		return mv;

	}
}
