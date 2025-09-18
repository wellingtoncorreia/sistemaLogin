package com.example.SistemaLogin.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Login")
@Data 
@NoArgsConstructor 
@AllArgsConstructor
public class Login {
	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	   
	   @Column(nullable = false, unique = true)
	    private String name;
	   
	    @Column(nullable = false, unique = true)
	    private String username;

	    @Column(nullable = false)
	    private String password;
}
