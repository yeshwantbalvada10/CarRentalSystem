import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Car> carArrayList = new ArrayList<>();
        Car car1 = new Car("C001","Tesla","compact sedan","60.0");
        Car car2 = new Car("C002","Ferrari","Portofino","70.0");
        Car car3 = new Car("C003","Lamborghini","avantador","150.0");
        Car car4 = new Car("C004","Audi","avant","180.0");

        carArrayList.add(car1);
        carArrayList.add(car2);
        carArrayList.add(car3);
        carArrayList.add(car4);



        CarRentalSystem rentalSystem = new CarRentalSystem(carArrayList);


//        rentalSystem.addCar(car1);
//        rentalSystem.addCar(car2);
//        rentalSystem.addCar(car3);

        rentalSystem.menu();
    }
}
