package com.example.hrms.dataAcces.abstracts;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hrms.entites.concretes.Employee;


public interface EmployeeDao extends JpaRepository <Employee,Integer> {

	
}
