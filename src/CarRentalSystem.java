import java.util.ArrayList;              // Pojo Class must have
import java.util.List;                   // 1. Constructor
import java.util.Scanner;                //2. getter(),setter()
                                         //3. toString() 4.hashcode 5.equals()
public class CarRentalSystem {
    private List<Car> cars; //int [] arr = new int [];

    private List<Customer>customers;

    private List<Rental>rentals;

                                             public CarRentalSystem(List<Car> cars) {
                                                 this.cars = cars;
                                             }

                                             //    public CarRentalSystem(){
//        cars = new ArrayList<>();
//        customers = new ArrayList<>();
//        rentals = new ArrayList<>();
//    }
    public void addCar(Car car){
        cars.add(car);
    }

    public void addCustomer(Customer customer){
        customers.add(customer);
    }
    public void rentCar(Car car,Customer customer,int days){
        if (car.isAvailable()){
            car.rent();
            rentals.add(new Rental(car,customer,days));
        } else {
            System.out.println("car is not available for rent");
        }
    }
    public void returnCar(Car car) {
        car.returnCar();
        Rental rentalToRemove = null;
        for (Rental rental : rentals) {
            if (rental.getCar() == car) {
                rentalToRemove = rental;
                break;
            }
        }
        if (rentalToRemove != null) {
            rentals.remove(rentalToRemove);
            System.out.println("Car returned Sucessfully");

        } else {
            System.out.println("Car was not rented");
        }
    }

        public void menu(){
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("**** Car Rental System ****");
            System.out.println("1. Rent a Car");
            System.out.println("2. Return a car");
            System.out.println("3. Exit");
            System.out.println("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice==1) {
                System.out.println("\n== Rent a Car==\n");
                System.out.println("Enter your name");
                String customerName = scanner.nextLine();

                System.out.println("\nAvailable ");
                for (Car car : cars) {
                    if (car.isAvailable()) {
                        System.out.println(car.getCarId() + " - " + car.getBrand() + " " + car.getModel());
                    }
                }
                System.out.print("\nEnter the car Id you want to rent: ");
                String carId = scanner.nextLine();

                System.out.print("enter the no.of days for rental");
                int rentalDays = scanner.nextInt();
                scanner.nextLine();

                Customer newCustomer = new Customer("CUS" + (customers.size() + 1), customerName);
                addCustomer(newCustomer);

                Car selectedCar = null;
                for (Car car : cars) {
                    if (car.getCarId().equals(carId) && car.isAvailable()) {
                        selectedCar = car;
                        break;
                    }
                }
                if (selectedCar != null) {
                    double totalPrice = selectedCar.calculatePrice(rentalDays);
                    System.out.println("\n== Rental Information ==\n");
                    System.out.println("Customer ID:" + newCustomer.getCustomerId());
                    System.out.println("Customer Name:" + newCustomer.getName());
                    System.out.println("Car: " + selectedCar.getBrand() + " " + selectedCar.getModel());
                    System.out.println("Rental days:" + rentalDays);
                    System.out.printf("Total Price: $%2f%n", totalPrice);

                    System.out.println("\nConfirm rental(Y/N):");
                    String confirm = scanner.nextLine();

                    if (confirm.equalsIgnoreCase("Y")) {
                        rentCar(selectedCar, newCustomer, rentalDays);
                        System.out.println("\nCar rented Successfully.");
                    } else {
                        System.out.println("\nRental Cancelled");
                    }
                } else {
                    System.out.println("\nInvalid Car selection or car not available for rent");
                }
            }     else if (choice == 2){
                          System.out.println("\n== Return a Car ==\n");
                          System.out.println("enter a car ID you want to return");
                          String carID = scanner.nextLine();

                          Car carToReturn = null;
                          for (Car car:cars){
                              if (car.getCarId().equals(carID) && !car.isAvailable()){
                                  carToReturn = car;
                                  break;
                              }
                          }
                          if (carToReturn!= null){
                              Customer customer = null;
                              for (Rental rental:rentals){
                                  if (rental.getCar() == carToReturn){
                                      customer = rental.getCustomer();
                                      break;
                                  }
                              }
                              if(customer!= null){
                                  returnCar(carToReturn);
                                  System.out.println("Car returned successfully by " + customer.getName());
                              }else {
                                  System.out.println("car was not rented or rental information is missing");
                              }
                          } else{
                              System.out.println("Invalid Car ID or car not rented");
                          }



                      } else if (choice==3){
                          break;
                      }else {
                          System.out.println("Invalid choice. enter a valid option");
                      }



                  }
                         System.out.println("Thank You For Using Yeshwant Car Rental System");
            }
        }









