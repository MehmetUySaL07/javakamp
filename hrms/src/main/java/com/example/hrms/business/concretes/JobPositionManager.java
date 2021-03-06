package com.example.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hrms.business.abstracts.JobPositionService;
import com.example.hrms.dataAcces.abstracts.JobPositionDao;
import com.example.hrms.entites.concretes.JobPosition;
@Service
public class JobPositionManager implements JobPositionService {

	
	
	private JobPositionDao jobPositionDao;
	
	@Autowired
	public JobPositionManager (JobPositionDao jobPositionDao) {
		
	super();
	this.jobPositionDao= jobPositionDao;
}

	@Override
	public List<JobPosition> getAll() {
		return jobPositionDao.findAll();
	}
	}
	
