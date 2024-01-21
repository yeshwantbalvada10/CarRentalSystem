import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Car car1 = new Car("C001","Tesla","compact sedan",60.0,true);
        Car car2 = new Car("C002","Ferrari","Portofino",70,true);
        Car car3 = new Car("C003","Lamborghini","avantador",150,true);
        Car car4 = new Car("C004","Audi","avant",180,true);





        CarRentalSystem rentalSystem = new CarRentalSystem();


        rentalSystem.addCar(car1);
        rentalSystem.addCar(car2);
        rentalSystem.addCar(car3);
        rentalSystem.addCar(car4);

        rentalSystem.menu();
    }
}
