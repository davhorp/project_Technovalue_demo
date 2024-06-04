package com.devit.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devit.demo.entitys.Books;
import com.devit.demo.repository.BooksRepository;

@RestController
@RequestMapping("demo_books/")
public class BooksControllerRest {

	@Autowired
	private BooksRepository booksRepository;
	
	@GetMapping("all")
	public List<Books> getAll(){
		return (List<Books>) booksRepository.findAll();
	}
	
	@PostMapping("new")
	public Books newBook(@RequestBody Books book){
		Books bookNew = new Books();
		try {
			if (book.getIsbn().isEmpty())
				throw new Exception("El campo ISBN esta nulo");
			else 
				bookNew = booksRepository.save(book);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return bookNew;
	}
	
	@PutMapping("edit")
	public Books editBook(@RequestBody Books bookEdit, @PathVariable String isbn){
		Books bookUpdate = new Books();
		try {
			bookUpdate = booksRepository.findByIsbn(isbn);
			bookUpdate.setAuthor(bookEdit.getAuthor());
			bookUpdate.setTitle(bookEdit.getTitle());
			booksRepository.save(bookUpdate);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return bookUpdate;
	}
	
	@DeleteMapping("delete")
	public void deleteBook(@PathVariable Long idBook){
		try {
			//Eliminar el registro
			booksRepository.deleteById(idBook);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
