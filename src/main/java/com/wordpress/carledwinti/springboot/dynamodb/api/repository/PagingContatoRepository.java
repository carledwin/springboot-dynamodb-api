package com.wordpress.carledwinti.springboot.dynamodb.api.repository;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.socialsignin.spring.data.dynamodb.repository.EnableScanCount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.wordpress.carledwinti.springboot.dynamodb.api.model.Contato;

public interface PagingContatoRepository extends PagingAndSortingRepository<Contato, String> {

	Page<Contato> findByNome(String nome, Pageable pageable);
	Page<Contato> findByEmail(String email, Pageable pageable);
	
	@EnableScan
	@EnableScanCount
	Page<Contato> findAll(Pageable pageable);
}
