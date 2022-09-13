package com.dennis.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dennis.cursomc.domain.Categoria;
import com.dennis.cursomc.domain.Cliente;
import com.dennis.cursomc.domain.Estado;
import com.dennis.cursomc.domain.Produto;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
