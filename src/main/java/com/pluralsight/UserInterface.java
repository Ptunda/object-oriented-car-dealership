package com.pluralsight;


import java.util.Scanner;
import java.util.ArrayList;

public class UserInterface {


    Dealership dealership;

    public UserInterface() {

        init(); // Initialize the dealership object

    }

    private void init(){

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
        Scanner scanner = new Scanner(System.in);
        String choice;
        while (running){
            System.out.println("Menu:");
            System.out.println("Enter your choice: ");
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

            choice = scanner.nextLine();

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



    }

    private void displayVehicles(ArrayList<Vehicle> vehicles) {
        System.out.println("Vehicles: ");
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }

    public void processGetByPriceRequest() {
        // get vehicles by price range

    }

    public void processGetByMakeModelRequest() {
        // get vehicles by make and model

    }

    public void processGetByYearRequest() {
        // get vehicles by year range
    }

    public void processGetByColorRequest() {
        // get vehicles by color

    }

    public void processGetByMileageRequest() {
        // get vehicles by mileage range

    }

    public void processGetByVehicleTypeRequest() {
        // get vehicles by type

    }

    public void processGetAllVehiclesRequest() {
        // get all vehicles

    }

    public void processAddVehicleRequest() {
        // add a vehicle

    }

    public void processRemoveVehicleRequest() {
        // remove a vehicle

    }

    public void processAllVehiclesRequest() {
        // Get all vehicles from the dealership and display them
        ArrayList<Vehicle> allVehicles = dealership.getAllVehicles();
        displayVehicles(allVehicles);
    }



}
