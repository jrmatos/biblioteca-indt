package br.com.indt.biblioteca.models.dto;

import java.util.List;

import br.com.indt.biblioteca.models.Book;

public class FindBooksResponseDTO {
	
	public List<Book> books;
	public Integer page;
	public Integer pageSize;
	public Integer totalBooks;
	
	public FindBooksResponseDTO() {
		super();
	}
	public FindBooksResponseDTO(List<Book> books, Integer page, Integer pageSize, Integer totalBooks) {
		super();
		this.books = books;
		this.page = page;
		this.pageSize = pageSize;
		this.totalBooks = totalBooks;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getTotalBooks() {
		return totalBooks;
	}
	public void setTotalBooks(Integer totalBooks) {
		this.totalBooks = totalBooks;
	}
	@Override
	public String toString() {
		return "FindBooksResponseDTO [books=" + books + ", page=" + page + ", pageSize=" + pageSize + ", totalBooks="
				+ totalBooks + "]";
	}
	
}
