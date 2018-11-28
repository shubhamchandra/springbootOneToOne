package com.hibernate.demo.demo.dao;

import com.hibernate.demo.demo.models.Person;

import java.util.List;

public interface PersonDao {

    List <Person> getAllPersons();

    Person getPersonById(int id);

    void deletePerson(int id);

    void addPerson(Person person);
}
