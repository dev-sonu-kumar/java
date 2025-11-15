package examples_oops.Example_1_Class;

public class CarMain {

    public static void main(String[] args) {

        // Creating an object of the Car class
        Car myCar = new Car();

        // Setting object values
        myCar.color = "Red";
        myCar.model = "Honda City";
        myCar.year = 2022;

        // Using object methods
        myCar.startEngine();
        myCar.showDetails();

        // Creating another object
        Car secondCar = new Car();
        secondCar.color = "Blue";
        secondCar.model = "Toyota Fortuner";
        secondCar.year = 2023;

        secondCar.startEngine();
        secondCar.showDetails();
    }
}
