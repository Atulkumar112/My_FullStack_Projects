package com.becoder.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.becoder.model.Emp;
import com.becoder.service.EmpService;


// this below is 24 line is for front end. it's the vs code react local host but if you don't comment this line then you can't
// send the data from postman. that's why i commented it for now.
//@CrossOrigin(origins="http://localhost:3000")

@Controller
@RequestMapping("/api/v1")
public class EmpController { 
	
	@Autowired
	private EmpService empService;
	
	@PostMapping("/save")
	public ResponseEntity<Emp>  createEmp(@RequestBody Emp emp){
		return new ResponseEntity<Emp>(empService.createEmp(emp), HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Emp>> getAllEmp(){
		return new ResponseEntity<List<Emp>>(empService.getAllEmp(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Emp> getEmpById(@PathVariable int id){
		
		return new ResponseEntity<Emp>(empService.getEmpById(id), HttpStatus.OK);
	}
	
	public ResponseEntity<String> helper(){
		
		return new ResponseEntity<String>("id not found by my side", HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteEmp(@PathVariable int id){
//		empService.deleteEmp(id);
//		return new ResponseEntity<String>("Deleted Successfully..", HttpStatus.OK);
		// if user want to delete that entity which is not presnet in database then this below code will handle this error.
		try {
			empService.deleteEmp(id);
			return new ResponseEntity<String>("Deleted Successfully..", HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<String>("Id is not in your database", HttpStatus.OK);
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Emp> updateEmp(@PathVariable int id, @RequestBody Emp emp){
		return new ResponseEntity<Emp>(empService.updateEmp(id, emp), HttpStatus.OK);
	}
}
