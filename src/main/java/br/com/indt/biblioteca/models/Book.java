package br.com.indt.biblioteca.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
 
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name="book")
public class Book implements Serializable{
     
    private static final long serialVersionUID = 1L;
     
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
    private Integer id;
    
    @Column(name="title")
    private String title;
    
    @Column(name="author")
    private String author;
    
    @Column(name="publisher")
    private String publisher;
    
    @Column(name="year")
    private Integer year;
    
    @Column(name="pages")
    private Integer pages;
    
    @Column(name="isbn")
    private Integer isbn;
    
	public Book() {
		super();
	}

	public Book(String title, String author, String publisher, Integer year, Integer pages, Integer isbn) {
		super();
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.year = year;
		this.pages = pages;
		this.isbn = isbn;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getPages() {
		return pages;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}

	public Integer getIsbn() {
		return isbn;
	}

	public void setIsbn(Integer isbn) {
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", publisher=" + publisher + ", year="
				+ year + ", pages=" + pages + ", isbn=" + isbn + "]";
	}
    
    		
	   
}