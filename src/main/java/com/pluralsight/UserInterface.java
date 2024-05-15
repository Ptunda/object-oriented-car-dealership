package com.pluralsight;


import java.util.Scanner;
import java.util.ArrayList;

public class UserInterface {

    // private attributes
    private final Scanner scanner = new Scanner(System.in);
    private Dealership dealership;

    public UserInterface() {

        init(); // Initialize the dealership object

    }

    private void init() {

        // Create an instance of DealershipFileManager and load the dealership
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        this.dealership = dealershipFileManager.getDealership();

    }

    public void display() {

        // Display options and handle user input
        // Call init() method to load the dealership
        init();

        boolean running = true;

        // Display menu options and process user commands
        String choice;

        while (running) {

            System.out.println("Menu:");
            System.out.println("1. Get vehicles by price range");
            System.out.println("2. Get vehicles by make and model");
            System.out.println("3. Get vehicle by year range");
            System.out.println("4. Get vehicle by color");
            System.out.println("5. Get vehicle by mileage range");
            System.out.println("6. Get vehicle by type");
            System.out.println("7. List all vehicles");
            System.out.println("8. Add a vehicle");
            System.out.println("9. Remove a vehicle");
            System.out.println("99. Quit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    processGetByPriceRequest();
                    break;
                case "2":
                    processGetByMakeModelRequest();
                    break;
                case "3":
                    processGetByYearRequest();
                    break;
                case "4":
                    processGetByColorRequest();
                    break;
                case "5":
                    processGetByMileageRequest();
                    break;
                case "6":
                    processGetByVehicleTypeRequest();
                    break;
                case "7":
                    processGetAllVehiclesRequest();
                    break;
                case "8":
                    processAddVehicleRequest();
                    break;
                case "9":
                    processRemoveVehicleRequest();
                    break;
                case "99":
                    System.out.println("Exiting...");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

        }

        scanner.close();


    }

    private void displayVehicles(ArrayList<Vehicle> vehicles) {

        // display all vehicles
        System.out.println("Vehicles ");
        System.out.println("====================================================================================================================================");
        System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s %-15s %s\n", "VIN", "Year", "Make", "Model", "Type", "Color", "Odometer", "Price");
        System.out.println("====================================================================================================================================");
        for (Vehicle vehicle : vehicles) {

            System.out.printf("%-15d %-15d %-15s %-15s %-15s %-15s %-15d %.2f\n", vehicle.getVin(), vehicle.getYear(), vehicle.getMake(),
                    vehicle.getModel(), vehicle.getVehicleType(), vehicle.getColor(), vehicle.getOdometer(), vehicle.getPrice());


        }

    }

    public void processGetByPriceRequest() {

        // get vehicles by price range
        System.out.print("Enter minimum price: ");
        double min = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Enter maximum price: ");
        double max = scanner.nextDouble();
        scanner.nextLine();

        ArrayList<Vehicle> vehicles = dealership.getVehiclesByPrice(min, max);
        displayVehicles(vehicles);

    }

    public void processGetByMakeModelRequest() {

        // get vehicles by make and model
        System.out.print("Enter make: ");
        String make = scanner.nextLine().trim();

        System.out.print("Enter model: ");
        String model = scanner.nextLine().trim();

        ArrayList<Vehicle> vehicles = dealership.getVehiclesByMakeModel(make, model);
        displayVehicles(vehicles);

    }

    public void processGetByYearRequest() {

        // get vehicles by year range
        System.out.print("Enter minimum year: ");
        int min = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter maximum year: ");
        int max = scanner.nextInt();
        scanner.nextLine();

        ArrayList<Vehicle> vehicles = dealership.getVehiclesByYear(min, max);
        displayVehicles(vehicles);

    }

    public void processGetByColorRequest() {

        // get vehicles by color
        System.out.print("Enter color: ");
        String color = scanner.nextLine().trim();

        ArrayList<Vehicle> vehicles = dealership.getVehiclesByColor(color);
        displayVehicles(vehicles);

    }

    public void processGetByMileageRequest() {

        // get vehicles by mileage range
        System.out.print("Enter minimum mileage: ");
        int min = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter maximum mileage: ");
        int max = scanner.nextInt();
        scanner.nextLine();

        ArrayList<Vehicle> vehicles = dealership.getVehiclesByMileage(min, max);
        displayVehicles(vehicles);

    }

    public void processGetByVehicleTypeRequest() {

        // get vehicles by type
        System.out.print("Enter vehicle type: ");
        String vehicleType = scanner.nextLine().trim();

        ArrayList<Vehicle> vehicles = dealership.getVehiclesByType(vehicleType);
        displayVehicles(vehicles);

    }

    public void processGetAllVehiclesRequest() {

        // get all vehicles
        ArrayList<Vehicle> vehicles = dealership.getAllVehicles();
        displayVehicles(vehicles);

    }

    public void processAddVehicleRequest() {

        // add a vehicle
        System.out.println("Enter vehicle details to add");

        System.out.print("VIN: ");
        int vin = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Year: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Make: ");
        String make = scanner.nextLine().trim();

        System.out.print("Model: ");
        String model = scanner.nextLine().trim();

        System.out.print("Vehicle Type: ");
        String vehicleType = scanner.nextLine().trim();

        System.out.print("Color: ");
        String color = scanner.nextLine().trim();

        System.out.print("Odometer: ");
        int odometer = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);

        dealership.addVehicle(vehicle);

        System.out.println("Vehicle was added successfully.");

        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        dealershipFileManager.saveDealership(dealership);


    }

    public void processRemoveVehicleRequest() {

        // remove a vehicle by VIN
        System.out.print("Enter VIN of the vehicle to remove: ");
        int vin = scanner.nextInt();
        scanner.nextLine();

        Vehicle vehicleToRemove = null;

        // Find the vehicle with the given VIN
        for (Vehicle vehicle : dealership.inventory) {

            if (vehicle.getVin() == vin) {

                vehicleToRemove = vehicle;
                break;

            }
        }

        // Remove the vehicle if it was found
        if (vehicleToRemove != null) {

            dealership.removeVehicle(vehicleToRemove);

            System.out.println("Vehicle was removed successfully.");

            DealershipFileManager dealershipFileManager = new DealershipFileManager();

            dealershipFileManager.saveDealership(dealership);


        } else {

            System.out.println("Vehicle not found.");

        }


    }


}
