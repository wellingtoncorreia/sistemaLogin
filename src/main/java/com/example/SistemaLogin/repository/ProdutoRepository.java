package com.example.SistemaLogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SistemaLogin.entities.Produtos;


public interface ProdutoRepository extends JpaRepository<Produtos, Long>{

}
