package com.hibernate.demo.demo.repositories;

import com.hibernate.demo.demo.dao.PersonDao;
import com.hibernate.demo.demo.models.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PersonRepository implements PersonDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Person> getAllPersons() {
        List <Person> list;
        Session session = sessionFactory.getCurrentSession();
        list = session.createQuery("from Person").getResultList();
        return list;
    }

    @Override
    public Person getPersonById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Person person = session.get(Person.class, id);
        return person;
    }

    @Override
    public void deletePerson(int id) {
        // must cascade and delete its vehicle
        Session session = sessionFactory.getCurrentSession();
        Person person = session.get(Person.class, id);
        session.delete(person);
    }

    @Override
    public void addPerson(Person person) {
        Session session = sessionFactory.getCurrentSession();
        session.save(person);
    }
}
