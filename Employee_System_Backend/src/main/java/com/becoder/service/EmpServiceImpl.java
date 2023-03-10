package com.becoder.service;

import java.io.FileNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.becoder.exception.ItemNotFoundException;
import com.becoder.model.Emp;
import com.becoder.repository.EmpRepository;


@Service
public class EmpServiceImpl implements EmpService{

	@Autowired
	private EmpRepository empRepo;
	
	@Autowired
    JdbcTemplate template;
	
	@Override
	public Emp createEmp(Emp emp) {
		
		return empRepo.save(emp);
	}

	@Override
	public List<Emp> getAllEmp() {
	
		return empRepo.findAll();
	}

//	@Override
//	public Emp getEmpById(int id) {
//		return empRepo.findById(id).get();		
//	}
	
	@Override
	public Emp getEmpById(int id) {
		Emp emp = null;
//	    String query = "SELECT * FROM react_fullstack WHERE id=?";
	    try{
//	        emp = template.queryForObject(query,new Object[]{id},new BeanPropertyRowMapper<>(Emp.class));
	    	emp=empRepo.findById(id).get();
	    }catch(Exception e){
	        throw new ItemNotFoundException("Item Not Found : "+id);
	    }
	    return emp;
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
