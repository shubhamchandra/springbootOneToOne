package com.hibernate.demo.demo.repositories;

import com.hibernate.demo.demo.dao.VehicleDao;
import com.hibernate.demo.demo.models.Vehicle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class VehicleRepository implements VehicleDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Vehicle> getAllVehicles() {
        List <Vehicle> list;
        Session session = sessionFactory.getCurrentSession();
        list = session.createQuery("from Vehicle").getResultList();
        return list;
    }

    @Override
    public Vehicle getVehicleById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Vehicle vehicle = session.get(Vehicle.class, id);
        return vehicle;
    }

    @Override
    public void deleteVehicle(int id) {
        Session session = sessionFactory.getCurrentSession();
        Vehicle vehicle = session.get(Vehicle.class, id);
        vehicle.getPerson().setVehicle(null);
        /* very important to break association otherwise error object re-saved due to cascading*/
        session.delete(vehicle);
    }

    @Override
    public void addVehicle(Vehicle vehicle) {
        Session session = sessionFactory.getCurrentSession();
        session.save(vehicle);
    }
}
