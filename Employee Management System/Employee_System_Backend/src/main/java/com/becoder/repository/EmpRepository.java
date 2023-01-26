package com.becoder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.becoder.model.Emp;

public interface EmpRepository extends JpaRepository<Emp, Integer>{

}
