package br.com.indt.biblioteca.dao.implementations;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
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
	
	public Book update(Book book) {
		entityManager.merge(book);
		return book;
	}

	public List<Book> find(Book bookFilter) {
		
		Criteria criteria = entityManager.unwrap(Session.class).createCriteria(Book.class);
		addRestrictionIfNotNull(criteria, "title", bookFilter.getTitle());
		addRestrictionIfNotNull(criteria, "author", bookFilter.getAuthor());
		addRestrictionIfNotNull(criteria, "publisher", bookFilter.getPublisher());
		addRestrictionIfNotNull(criteria, "year", bookFilter.getYear());
		addRestrictionIfNotNull(criteria, "pages", bookFilter.getPages());
		addRestrictionIfNotNull(criteria, "isbn", bookFilter.getIsbn());
		
		return criteria.list();
	}
	
	public void delete(String bookId) {
		Book book = entityManager.find(Book.class, Integer.parseInt(bookId));
		entityManager.remove(book);
	}
	
	private void addRestrictionIfNotNull(Criteria criteria, String propertyName, Object value) {
	    if (value != null) {
	        criteria.add(Restrictions.like(propertyName, (String) value, MatchMode.ANYWHERE));
	    }
	}

}
