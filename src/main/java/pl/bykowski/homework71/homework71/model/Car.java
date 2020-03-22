package pl.bykowski.homework71.homework71.model;


public class Car {

  private long carId;
  private String mark;
  private String model;
  private String color;
  private long year;

  public Car(long carId, String mark, String model, String color, long year) {
    this.carId = carId;
    this.mark = mark;
    this.model = model;
    this.color = color;
    this.year = year;
  }

  public Car() {
  }

  public long getCarId() {
    return carId;
  }

  public void setCarId(long carId) {
    this.carId = carId;
  }


  public String getMark() {
    return mark;
  }

  public void setMark(String mark) {
    this.mark = mark;
  }


  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }


  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }


  public long getYear() {
    return year;
  }

  public void setYear(long year) {
    this.year = year;
  }

  @Override
  public String toString() {
    return "Cars{" +
            "carId=" + carId +
            ", mark='" + mark + '\'' +
            ", model='" + model + '\'' +
            ", color='" + color + '\'' +
            ", year=" + year +
            '}';
  }
}
