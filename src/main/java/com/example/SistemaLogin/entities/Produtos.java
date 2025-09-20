package com.example.SistemaLogin.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Produtos")
public class Produtos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
    @NotBlank
	@Column(name= "nome")
	private String nome;
	
	@NotNull
    @NotBlank
	@Column(name= "descricao")
	private String descricao;
	
	@NotNull
	@Column(name= "preco")
	private Double preco;
	
	@NotNull
    @NotBlank
	@Column(name= "url")
	private String url;
	
	
}
