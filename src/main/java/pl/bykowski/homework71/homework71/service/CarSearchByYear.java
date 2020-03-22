package pl.bykowski.homework71.homework71.service;


import org.springframework.stereotype.Component;


@Component
public class CarSearchByYear {

    private long startYear;
    private long endYear;


    public CarSearchByYear(long startYear, long endYear) {
        this.startYear = startYear;
        this.endYear = endYear;
    }

    public CarSearchByYear() {

    }

    public long getStartYear() {
        return startYear;
    }

    public void setStartYear(long startYear) {
        this.startYear = startYear;
    }

    public long getEndYear() {
        return endYear;
    }

    public void setEndYear(long endYear) {
        this.endYear = endYear;
    }
}
