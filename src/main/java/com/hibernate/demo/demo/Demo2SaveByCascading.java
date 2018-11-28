package com.hibernate.demo.demo;

import com.hibernate.demo.demo.config.AppConfig;
import com.hibernate.demo.demo.dao.PersonDao;
import com.hibernate.demo.demo.dao.VehicleDao;
import com.hibernate.demo.demo.models.Person;
import com.hibernate.demo.demo.models.Vehicle;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Demo2SaveByCascading {
    public static void main(String ... args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();

        VehicleDao vehicleDao = (VehicleDao) context.getBean("vehicleRepository");
        /* important to break the association bw person and vehicle otherwise error :
         * object re-saved due to cascading in person entity*/
        vehicleDao.deleteVehicle(29);
    }
}
