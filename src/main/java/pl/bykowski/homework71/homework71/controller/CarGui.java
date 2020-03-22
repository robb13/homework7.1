package pl.bykowski.homework71.homework71.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.bykowski.homework71.homework71.carDao.CarDaoImpl;
import pl.bykowski.homework71.homework71.model.Car;
import pl.bykowski.homework71.homework71.service.CarSearchByYear;

@Controller
public class CarGui {

    private CarDaoImpl carDao;
    private CarSearchByYear carSearchByYear;

    @Autowired
    public CarGui(CarDaoImpl carDao, CarSearchByYear carSearchByYear) {
        this.carDao = carDao;
        this.carSearchByYear = carSearchByYear;

    }

    @GetMapping
    public String getCarDb(Model model) {
        model.addAttribute("cars", carDao.findAll());
        model.addAttribute("search", carSearchByYear);
        model.addAttribute("addNew", new Car());
        return "cars";
    }

    @PostMapping("/find-by-year")
    public String getByYear(Model model, @RequestParam long startYear, long endYear) {
        carSearchByYear.setStartYear(startYear);
        carSearchByYear.setEndYear(endYear);
        model.addAttribute("years", carDao.findByYear());
        carDao.findByYear();
        return "years";
    }

    @PostMapping("/add-car")
    public String addNewCar(@RequestParam long carId, String mark, String model, String color, long year) {
        carDao.saveCar(carId, mark, model, color, year);
        return "redirect:/";
    }


}
