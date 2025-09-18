package com.example.SistemaLogin.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SistemaLogin.entities.Login;
import com.example.SistemaLogin.services.LoginService;

@RestController

@RequestMapping("/users")
public class LoginController {

    @Autowired
    private LoginService loginService;
    @PostMapping("/auth")
    public ResponseEntity<Login> authenticate(@RequestBody Login loginDetails) {
        Login authenticatedUser = loginService.authenticate(loginDetails.getUsername(), loginDetails.getPassword());

        if (authenticatedUser != null) {
            // Retorna 200 OK com os dados do usuário (sem a senha) se a autenticação for bem-sucedida
            authenticatedUser.setPassword(null); // Nunca retorne a senha para o front-end
            return ResponseEntity.ok(authenticatedUser);
        }
        // Retorna 401 Unauthorized se as credenciais estiverem incorretas
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    // --- ENDPOINT DE REGISTRO (CADASTRO) ---
    // Rota: POST /users/register
    @PostMapping("/register")
    public Login registerUser(@RequestBody Login login) {
        return loginService.saveUser(login);
    }


    // --- ENDPOINTS DE GERENCIAMENTO (CRUD) ---
    // ATENÇÃO: Em um app real, estes endpoints deveriam ser protegidos (ex: apenas para admins)

    // GET /users -> Lista todos os usuários
    @GetMapping
    public List<Login> getAllUsers() {
        return loginService.getAllUsers();
    }

    // GET /users/{id} -> Busca um usuário por ID
    @GetMapping("/{id}")
    public Login getUserById(@PathVariable Long id) {
        return loginService.getUserById(id);
    }

    // PUT /users/{id} -> Atualiza um usuário
    @PutMapping("/{id}")
    public Login updateUser(@PathVariable Long id, @RequestBody Login login) {
        login.setId(id);
        return loginService.saveUser(login);
    }

    // DELETE /users/{id} -> Deleta um usuário
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        loginService.deleteUser(id);
    }
}