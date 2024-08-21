package com.sathya.repo;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sathya.model.Students;

@Repository
public interface StudentRepository extends JpaRepository<Students, Integer>{

	
}