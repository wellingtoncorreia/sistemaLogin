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
import com.example.SistemaLogin.entities.Produtos;
import com.example.SistemaLogin.services.ProdutoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name="Produtos", description = "API PARA GERENCIAMENTO DE PRODUTOS")
@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }
    
    @Operation(summary = "Localiza os produtos por ID")
    @GetMapping("/{id}")
    public ResponseEntity<Produtos> buscarProdutoId(@PathVariable Long id) {
        Produtos produtos = produtoService.buscarProdutosPorId(id);
        if (produtos != null) {
            return ResponseEntity.ok(produtos);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @Operation(summary = "Localiza todos os produtos")
    @GetMapping("/")
    public ResponseEntity<List<Produtos>> buscarTodosProdutos() {
        List<Produtos> produtos = produtoService.buscarTodosProdutos();
        return ResponseEntity.ok(produtos);
    }

    @Operation(summary = "Cadastra um novo produto")
    @PostMapping("/")
    public ResponseEntity<Produtos> salvaProduto(@RequestBody @Valid Produtos produtos) {
        Produtos saveProdutos = produtoService.salvarProdutos(produtos);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveProdutos);
    }
    
    @Operation(summary = "Atualiza o produto por ID")
    @PutMapping("/{id}")
    public ResponseEntity<Produtos> alteraProdutos(@PathVariable Long id, @RequestBody @Valid Produtos produto) {
        Produtos atualizaProdutos = produtoService.atualizarProdutos(id, produto);
        if (atualizaProdutos != null) {
            return ResponseEntity.ok(atualizaProdutos); // Retorna o produto atualizado
        } else {
            return ResponseEntity.notFound().build(); // Retorna 404 se o produto não for encontrado
        }
    }
    
    @Operation(summary = "delete o produto por ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Produtos> apagaProduto(@PathVariable Long id) {
        boolean apagaProduto = produtoService.apagarProdutos(id);
        if (apagaProduto) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // Retorna 204 No Content
        } else {
            return ResponseEntity.notFound().build(); // Retorna 404 se o produto não for encontrado
        }
    }
}
