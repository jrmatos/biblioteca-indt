package br.com.indt.biblioteca.services;

import java.util.List;

import br.com.indt.biblioteca.models.Person;
 
public interface PersonService {
     
    Person create(final Person person);
    Person findById(final String personId);
    List<Person> findAll();
    Person update(Person person);
    void delete(final String personId);
 
}