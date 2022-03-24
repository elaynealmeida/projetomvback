package com.cafemv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cafemv.model.Cafe;

public interface CafeRepository extends JpaRepository<Cafe, Long>{
	boolean existsByCpf(String cpf);
	boolean existsByCafe(String cafe);
}
