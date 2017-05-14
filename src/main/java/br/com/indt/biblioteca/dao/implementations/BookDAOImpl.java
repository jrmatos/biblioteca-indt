package br.com.indt.biblioteca.dao.implementations;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
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

	public List<Book> find(Book bookFilter, Integer page, Integer pageSize) {
		
		Integer skip = (page != null) ? (page - 1) * pageSize: 0;
		
		Criteria criteria = entityManager.unwrap(Session.class).createCriteria(Book.class);
		addFilters(criteria, bookFilter);		
		criteria.addOrder(Order.desc("id"));
		criteria.setFirstResult(skip);
		criteria.setMaxResults(pageSize);
		
		return criteria.list();
	}
	
	
	
	public void delete(String bookId) {
		Book book = entityManager.find(Book.class, Integer.parseInt(bookId));
		entityManager.remove(book);
	}
	
	public Integer getBooksQuantity() {
		return entityManager
				.unwrap(Session.class)
				.createCriteria(Book.class)
				.list()
				.size();
	}
	
	public Integer getBooksQuantityFilter(Book bookFilter) {
		Criteria criteria = entityManager.unwrap(Session.class).createCriteria(Book.class);
		addFilters(criteria, bookFilter);
		return criteria.list().size();
	}
	
	private void addFilters(Criteria criteria, Book bookFilter) {
		addRestrictionIfNotNull(criteria, "title", bookFilter.getTitle());
		addRestrictionIfNotNull(criteria, "author", bookFilter.getAuthor());
		addRestrictionIfNotNull(criteria, "publisher", bookFilter.getPublisher());
		addRestrictionIfNotNull(criteria, "year", bookFilter.getYear());
		addRestrictionIfNotNull(criteria, "pages", bookFilter.getPages());
		addRestrictionIfNotNull(criteria, "isbn", bookFilter.getIsbn());
	}
	
	private void addRestrictionIfNotNull(Criteria criteria, String propertyName, Object value) {
	    if (value != null) {
	    	if(value instanceof Integer) {
	    		criteria.add(Restrictions.eq(propertyName, value));
	    	}
	    	else {
	    		criteria.add(Restrictions.like(propertyName, String.valueOf(value), MatchMode.ANYWHERE).ignoreCase());
	    	}
	    }
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> findall() {
		return entityManager
				.unwrap(Session.class)
				.createCriteria(Book.class)
				.list();
	}

}
