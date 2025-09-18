package com.example.SistemaLogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SistemaLogin.entities.Login;

public interface LoginRepository  extends JpaRepository<Login, Long>{
	 Login findByUsername(String username);
}
