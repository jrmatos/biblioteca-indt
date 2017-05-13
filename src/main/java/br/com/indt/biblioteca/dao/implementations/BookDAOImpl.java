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

	@Override
	public List<Book> find() {
//		return entityManager.createQuery("select e from Module e where e.status = :status",
//			    Book.class).setParameter("status", status).getResultList();
		return entityManager.createQuery("SELECT b FROM Book b", Book.class).getResultList();
	}

	

}
