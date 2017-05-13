package br.com.indt.biblioteca.dao.implementations;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import br.com.indt.biblioteca.dao.BookDAO;
import br.com.indt.biblioteca.models.Book;

@Component
@Transactional
public class BookDAOImpl implements BookDAO{
	@PersistenceContext
	private EntityManager entityManager;
	
	public Book save(Book book) {
		entityManager.persist(book);
		return book;
	}

	public List<Book> find() {
//		return entityManager.createQuery("select b from Book b where b.id = :id",
//			    Book.class).setParameter("id", id).getResultList();
		return entityManager.createQuery("SELECT b FROM Book b ORDER BY b.id DESC", Book.class).getResultList();
	}

}
