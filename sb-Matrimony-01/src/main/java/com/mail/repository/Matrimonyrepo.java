package com.mail.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mail.model.Matrimony;

public interface Matrimonyrepo extends JpaRepository<Matrimony, Integer> {

	Matrimony findByEmail(String email);

	boolean existsByEmail(String email);

}
