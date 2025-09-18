package com.example.SistemaLogin.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.SistemaLogin.entities.Login;
import com.example.SistemaLogin.repository.LoginRepository;

@Service
public class LoginService {
    @Autowired
    private LoginRepository loginRepository;

    // --- NOVO MÉTODO DE AUTENTICAÇÃO ---
    // Esta é a lógica de negócio principal para o login.
    public Login authenticate(String username, String password) {
        Login user = loginRepository.findByUsername(username);

        // Verifica se o usuário existe e se a senha corresponde
        if (user != null && user.getPassword().equals(password)) {
            // IMPORTANTE: Em um projeto real, você usaria um comparador de hash de senhas aqui.
            // Ex: if (user != null && passwordEncoder.matches(password, user.getPassword()))
            return user;
        }
        // Retorna null se a autenticação falhar
        return null;
    }

    // --- MÉTODOS DE GERENCIAMENTO (CRUD) ---

    public List<Login> getAllUsers() { // Renomeado de getAlllogin para clareza
        return loginRepository.findAll();
    }

    public Login getUserById(Long id) { // Renomeado de getLoginById
        return loginRepository.findById(id).orElse(null);
    }

    public Login saveUser(Login login) { // Renomeado de saveLogin
        // IMPORTANTE: Em um projeto real, a senha deveria ser criptografada (hashed) aqui antes de salvar.
        // Ex: login.setPassword(passwordEncoder.encode(login.getPassword()));
        return loginRepository.save(login);
    }

    public void deleteUser(Long id) { // Renomeado de deleteGuest
        loginRepository.deleteById(id);
    }
}