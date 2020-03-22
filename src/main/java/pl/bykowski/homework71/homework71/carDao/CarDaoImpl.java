package pl.bykowski.homework71.homework71.carDao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.bykowski.homework71.homework71.model.Car;
import pl.bykowski.homework71.homework71.service.CarSearchByYear;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class CarDaoImpl implements CarInterface {

    private JdbcTemplate jdbcTemplate;
    private Car car;
    private CarSearchByYear carSearchByYear;

    @Autowired
    public CarDaoImpl(JdbcTemplate jdbcTemplate, CarSearchByYear carSearchByYear) {
        this.jdbcTemplate = jdbcTemplate;
        this.carSearchByYear = carSearchByYear;
    }

    @Override
    public void saveCar(long carId, String mark, String model, String color, long year) {
        car = new Car(carId, mark, model, color, year);
        String sql = "INSERT INTO cars VALUES (?,?,?,?,?)";
        jdbcTemplate.update(sql, car.getCarId(), car.getMark(), car.getModel(), car.getColor(), car.getYear());

    }

    @Override
    public List<Car> findAll() {
        String sql = "SELECT * FROM cars";
        return getCars(sql);
    }

    @Override
    public List<Car> findByYear() {
        String sql = "SELECT * FROM cars WHERE year BETWEEN " + carSearchByYear.getStartYear() + " AND " + carSearchByYear.getEndYear();
        return getCars(sql);
    }


    private List<Car> getCars(String sql) {
        List<Car> cars = new ArrayList<>();
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        maps.forEach(element -> cars.add(new Car(
                Long.parseLong(String.valueOf(element.get("car_id"))),
                String.valueOf(element.get("mark")),
                String.valueOf(element.get("model")),
                String.valueOf(element.get("color")),
                Long.parseLong(String.valueOf(element.get("year"))))));
        return cars;
    }

}
