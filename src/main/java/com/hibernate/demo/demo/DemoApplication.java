package com.hibernate.demo.demo;

import com.hibernate.demo.demo.config.AppConfig;
import com.hibernate.demo.demo.dao.PersonDao;
import com.hibernate.demo.demo.models.Person;
import com.hibernate.demo.demo.models.Vehicle;
import com.hibernate.demo.demo.repositories.PersonRepository;
import com.hibernate.demo.demo.repositories.VehicleRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		//SpringApplication.run(DemoApplication.class, args);
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(AppConfig.class);
		context.refresh();
		Person shubham = new Person("Shubham Chandra", 24);
		Person satish = new Person("Satish Kr", 24);
		Person sachin = new Person("Sachin", 25);
		Vehicle audi = new Vehicle("Audi Q6", "car");
		Vehicle porsche = new Vehicle("Porsche", "car");
		Vehicle maruti = new Vehicle("Maruti 800", "car");

		/* map from Person to Vehicle*/
		shubham.setVehicle(audi);
		satish.setVehicle(porsche);
		sachin.setVehicle(maruti);

		/* map from Vehicle to Person */
		audi.setPerson(shubham);
		porsche.setPerson(satish);
		maruti.setPerson(sachin);

		/* Accept in Dao interface not in repository object otherwise ClassCastException */
		PersonDao personDao = (PersonDao) context.getBean("personRepository");
		personDao.addPerson(shubham);
		personDao.addPerson(satish);
		personDao.addPerson(sachin);

	}
}
