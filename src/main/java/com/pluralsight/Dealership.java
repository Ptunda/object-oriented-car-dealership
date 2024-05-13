package com.pluralsight;

import java.util.ArrayList;

public class Dealership {

    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;


    // constructor
    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }


    // getters
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }



    public ArrayList<Vehicle> getVehiclesByPrice(double min, double max) {
        return null;
    }

    public ArrayList<Vehicle> getVehiclesByMakeModel(String make, String model) {
        return null;
    }

    public ArrayList<Vehicle> getVehiclesByYear(int min, int max) {
        return null;
    }

    public ArrayList<Vehicle> getVehiclesByColor(String color) {
        return null;
    }

    public ArrayList<Vehicle> getVehiclesByMileage(int min, int max) {
        return null;
    }

    public ArrayList<Vehicle> getVehiclesByType(String vehicleType) {
        return null;
    }

    public ArrayList<Vehicle> getAllVehicles() {

        return inventory;

    }

    public void addVehicle(Vehicle vehicle) {

        // add vehicle to inventory
        Vehicle vehicle1 = new Vehicle(12237, 2024, "Ford", "Escape", "SUV", "Mate Black", 35000, 50335.0);
        inventory.add(vehicle1);

    }

    public void removeVehicle(Vehicle vehicle) {
        // Implement logic to remove vehicle from inventory
    }


}
