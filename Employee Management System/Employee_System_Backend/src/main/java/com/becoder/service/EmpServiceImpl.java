package com.becoder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.becoder.model.Emp;
import com.becoder.repository.EmpRepository;


@Service
public class EmpServiceImpl implements EmpService{

	@Autowired
	private EmpRepository empRepo;
	
	@Override
	public Emp createEmp(Emp emp) {
		
		return empRepo.save(emp);
	}

	@Override
	public List<Emp> getAllEmp() {
	
		return empRepo.findAll();
	}

	@Override
	public Emp getEmpById(int id) {
		
		return empRepo.findById(id).get();
	}

	@Override
	public void deleteEmp(int id) {
		Emp emp = empRepo.findById(id).get();
		if(emp!=null) {
			empRepo.delete(emp);
		}
	}

	@Override
	public Emp updateEmp(int id, Emp newEmp) {
		Emp oldEmp = empRepo.findById(id).get();
		if(oldEmp!=null) {
			newEmp.setId(id);
			return empRepo.save(newEmp);
		}
		return null;
	}
	
	
}
