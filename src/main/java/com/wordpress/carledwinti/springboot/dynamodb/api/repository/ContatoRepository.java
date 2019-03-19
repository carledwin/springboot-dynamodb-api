package com.wordpress.carledwinti.springboot.dynamodb.api.repository;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.wordpress.carledwinti.springboot.dynamodb.api.model.Contato;

@EnableScan
public interface ContatoRepository extends CrudRepository<Contato, String> {

	List<Contato> findByNome(String nome);
	List<Contato> findByEmail(String email);
}
