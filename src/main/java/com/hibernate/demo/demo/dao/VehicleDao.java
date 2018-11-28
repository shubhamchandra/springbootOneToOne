package com.hibernate.demo.demo.dao;

import com.hibernate.demo.demo.models.Vehicle;

import java.util.List;

public interface VehicleDao {

    List <Vehicle> getAllVehicles();

    Vehicle getVehicleById(int id);

    void deleteVehicle(int id);

    void addVehicle(Vehicle vehicle);

}
