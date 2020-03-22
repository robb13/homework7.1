package pl.bykowski.homework71.homework71.carDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Runner {

    private CarDaoImpl carDao;

    @Autowired
    public Runner(CarDaoImpl carDao) {
        this.carDao = carDao;
        //carDao.saveCar(3L,"VW","Passat","red", 2000);
    }
}
