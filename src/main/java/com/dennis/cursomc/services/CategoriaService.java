package com.dennis.cursomc.services;

import java.util.Optional;
import com.dennis.cursomc.services.exception.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dennis.cursomc.domain.Categoria;
import com.dennis.cursomc.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	//essa anotação instancia o objeto por injeçao de dependencia ou inversao de control
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
		
	}

}
