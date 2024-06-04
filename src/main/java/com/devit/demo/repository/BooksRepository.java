package com.devit.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.devit.demo.entitys.Books;

@Repository
public interface BooksRepository extends CrudRepository<Books, Long>{
	
	public Books findByIsbn(String insb);

}
