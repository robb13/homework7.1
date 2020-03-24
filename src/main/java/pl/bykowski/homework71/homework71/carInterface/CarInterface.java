package pl.bykowski.homework71.homework71.carInterface;

import pl.bykowski.homework71.homework71.model.Car;

import java.util.List;

public interface CarInterface {

    void saveCar(long carId, String mark, String model, String color, long year);

    List<Car> findAll();

    List<Car> findByYear();

}
