package com.example.SistemaLogin.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SistemaLogin.entities.Produtos;
import com.example.SistemaLogin.repository.ProdutoRepository;





@Service
public class ProdutoService {
	@Autowired
	private final ProdutoRepository produtoRepository;

	public ProdutoService(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}
	
	public List<Produtos> buscarTodosProdutos(){
		return produtoRepository.findAll();
	}
	
	public Produtos buscarProdutosPorId(Long id){
		  Optional <Produtos> produto = produtoRepository.findById(id);
	        return produto.orElse(null);
	}
	
	public Produtos salvarProdutos(Produtos atProdutos) {
		return produtoRepository.save(atProdutos);
	}
	
	public Produtos atualizarProdutos(Long id, Produtos atProdutos) {
		Optional<Produtos> exeProduto = produtoRepository.findById(id);
		if(exeProduto.isPresent()) {
			atProdutos.setId(id);
			return produtoRepository.save(atProdutos);
		}
		else {
			return null;
		}
	}
	
	public Boolean apagarProdutos(Long id) {
		Optional<Produtos> exeProduto = produtoRepository.findById(id);
		if(exeProduto.isPresent()) {
			produtoRepository.deleteById(id);
			return true;
		}
		return false;
	}
	
}
