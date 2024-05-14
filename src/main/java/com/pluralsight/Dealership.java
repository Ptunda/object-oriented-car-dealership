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

    public void setName(String name){

        this.name = name;

    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address){

        this.address = address;

    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone){

        this.phone = phone;

    }



    public ArrayList<Vehicle> getVehiclesByPrice(double min, double max) {

        ArrayList<Vehicle> vehiclesInRange = new ArrayList<>();

        for (Vehicle vehicle : inventory) {

            if (vehicle.getPrice() >= min && vehicle.getPrice() <= max) {

                vehiclesInRange.add(vehicle);
            }
        }

        return vehiclesInRange;

    }

    public ArrayList<Vehicle> getVehiclesByMakeModel(String make, String model) {

        ArrayList<Vehicle> vehicles = new ArrayList<>();

        for (Vehicle vehicle : inventory) {

            if (vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model)) {

                vehicles.add(vehicle);

            }
        }

        return vehicles;

    }

    public ArrayList<Vehicle> getVehiclesByYear(int min, int max) {


        ArrayList<Vehicle> vehiclesInRange = new ArrayList<>();

        for (Vehicle vehicle : inventory) {

            if (vehicle.getYear() >= min && vehicle.getYear() <= max) {

                vehiclesInRange.add(vehicle);

            }
        }

        return vehiclesInRange;

    }

    public ArrayList<Vehicle> getVehiclesByColor(String color) {

        ArrayList<Vehicle> vehicles = new ArrayList<>();

        for (Vehicle vehicle : inventory) {

            if (vehicle.getColor().equalsIgnoreCase(color)) {

                vehicles.add(vehicle);

            }
        }

        return vehicles;

    }

    public ArrayList<Vehicle> getVehiclesByMileage(int min, int max) {

        ArrayList<Vehicle> vehiclesInRange = new ArrayList<>();

        for (Vehicle vehicle : inventory) {

            if (vehicle.getOdometer() >= min && vehicle.getOdometer() <= max) {

                vehiclesInRange.add(vehicle);

            }
        }

        return vehiclesInRange;

    }

    public ArrayList<Vehicle> getVehiclesByType(String vehicleType) {

        ArrayList<Vehicle> vehicles = new ArrayList<>();

        for (Vehicle vehicle : inventory) {

            if (vehicle.getVehicleType().equalsIgnoreCase(vehicleType)) {

                vehicles.add(vehicle);

            }
        }

        return vehicles;

    }

    public ArrayList<Vehicle> getAllVehicles() {

        return inventory;

    }

    public void addVehicle(Vehicle vehicle) {

        // add vehicle to inventory
        inventory.add(vehicle);


    }

    public void removeVehicle(Vehicle vehicle) {

        // remove vehicle from inventory
        inventory.remove(vehicle);

    }


}
