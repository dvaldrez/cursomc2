package com.dennis.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dennis.cursomc.domain.Categoria;
import com.dennis.cursomc.domain.Cidade;
import com.dennis.cursomc.domain.Cliente;
import com.dennis.cursomc.domain.Endereco;
import com.dennis.cursomc.domain.Estado;
import com.dennis.cursomc.domain.Produto;
import com.dennis.cursomc.domain.enums.TipoCliente;
import com.dennis.cursomc.repositories.CategoriaRepository;
import com.dennis.cursomc.repositories.CidadeRepository;
import com.dennis.cursomc.repositories.ClienteRepository;
import com.dennis.cursomc.repositories.EnderecoRepository;
import com.dennis.cursomc.repositories.EstadoRepository;
import com.dennis.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class Cursomc2Application implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository; 
	@Autowired
	private CidadeRepository cidadeRepository; 
	@Autowired
	private EstadoRepository estadoRepository; 
	@Autowired
	private ClienteRepository clienteRepository; 
	@Autowired
	private EnderecoRepository enderecoRepository; 
	
	public static void main(String[] args) {
		SpringApplication.run(Cursomc2Application.class, args);
	}
	
	

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritorio	");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));

		Estado e1 = new Estado(null, "Minas Gerais");
		Estado e2 = new Estado(null, "Sao Paulo");

		Cidade c1 = new Cidade(null,"São Paulo",e2);
		Cidade c2 = new Cidade(null,"Campinas", e2);
		Cidade c3 = new Cidade(null,"Uberlandia",e1);
		
		e1.getCidades().addAll(Arrays.asList(c3));
		e2.getCidades().addAll(Arrays.asList(c1,c2));
		
		estadoRepository.saveAll(Arrays.asList(e1,e2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		
		
		Cliente cliente = new Cliente(null, "Maria Silva", "maria@gmail.com", "01234567890", TipoCliente.PESSOAFISICA);
		
		cliente.getTelefones().addAll(Arrays.asList("27363323","93838393"));
		
		Endereco endereco = new Endereco(null, "rua a", "30", "ap 1", "centro", "123456", cliente);
		Endereco endereco2 = new Endereco(null, "rua b", "30", "ap 2", "centro", "123456", cliente);
		
		cliente.getEnderecos().addAll(Arrays.asList(endereco,endereco2));
		
		clienteRepository.saveAll(Arrays.asList(cliente));
		enderecoRepository.saveAll(Arrays.asList(endereco,endereco2));
		
	}

}
