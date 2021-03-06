package com.example.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hrms.business.abstracts.EmployeeService;
import com.example.hrms.business.abstracts.EmployeeValidationService;
import com.example.hrms.business.abstracts.UserActivationService;
import com.example.hrms.business.abstracts.UserCheckService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.ErrorResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAcces.abstracts.EmployeeDao;
import com.example.hrms.entites.concretes.Employee;

@Service
public class EmployeeManager implements EmployeeService {

	@Autowired
	private UserActivationService userActivationService;
	@Autowired
	private UserCheckService userCheckService;
	@Autowired
	private EmployeeDao employeeDao;
	@Autowired
	private EmployeeValidationService employeeValidationService;
	
	
	
	
	public EmployeeManager(UserActivationService userActivationService, UserCheckService userCheckService, EmployeeDao employeeDao,
			EmployeeValidationService employeeValidationService) {
		super();
		this.userActivationService = userActivationService;
		this.userCheckService = userCheckService;
		this.employeeDao = employeeDao;
		this.employeeValidationService=employeeValidationService;
	}

	@Override
	public Result register(Employee employee) throws Exception {
	
		List<Employee> employees = this.employeeDao.findAll();
		if (this.userCheckService.IfUserRealPerson(employee)) {
			
			if (this.userActivationService.activate()) {
				
				checkIfUserExistsBefore(employees, employee);
				if (checkIfUserExistsBefore(employees, employee).isSuccess()) {
					
					employeeValidationService.validate(employee);
					this.employeeDao.save(employee);
					return new SuccessResult("Kay??t olma i??lemi ba??ar??yla ger??ekle??ti.");
				}										
				
			}	
			
			return new ErrorResult("L??tfen mail adresine g??nderilen aktivasyon kodu ile aktivasyon i??lemini ger??ekle??tiriniz.");
		}
		
		return new ErrorResult("L??tfen kullan??c?? bilgilerini do??ru ??ekilde giriniz.");
	}	
	
	  private Result checkIfUserExistsBefore(List<Employee> employees, Employee checkEmployee){
	        for (Employee employee: employees) {
	            if (employee.getEmail().equals(checkEmployee.getEmail())){
	                return new ErrorResult("Bu email mevcut.");
	            }
	            if (employee.getIdentityNumber().equals(checkEmployee.getIdentityNumber())){
	                return new ErrorResult("Bu kimlik numaras?? zaten mevcut.");
	            }
	        }
	        return new SuccessResult();
	    }

	@Override
	public DataResult <List<Employee>> getAll() {
		 return new SuccessDataResult<List<Employee>>(this.employeeDao.findAll(),"Ba??ar??yla Listelendi");
	}

}