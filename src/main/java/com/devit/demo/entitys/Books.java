package com.devit.demo.entitys;

import jakarta.persistence.Entity;

@Entity
public class Books {

	private Long id;
	private String title;
	private String author;
	private String isbn;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Books [\n\tid=");
		builder.append(id);
		builder.append(", \n\ttitle=");
		builder.append(title);
		builder.append(", \n\tauthor=");
		builder.append(author);
		builder.append(", \n\tisbn=");
		builder.append(isbn);
		builder.append("\n]");
		return builder.toString();
	}

}
