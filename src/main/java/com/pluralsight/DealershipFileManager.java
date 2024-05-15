package com.pluralsight;

import java.io.*;
import java.util.ArrayList;

public class DealershipFileManager {

    private static final String FILE_NAME = "dealership.csv";

    public Dealership getDealership() {

        Dealership dealership = null;

        ArrayList<Vehicle> inventory = new ArrayList<>();

        try {

            FileReader fileReader = new FileReader(FILE_NAME);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {

                String[] parts = line.split("\\|");

                if (parts.length == 3) {

                    String name = parts[0];
                    String address = parts[1];
                    String phone = parts[2];

                    dealership = new Dealership(name, address, phone);

                } else if (parts.length == 8) {

                    int vin = Integer.parseInt(parts[0]);
                    int year = Integer.parseInt(parts[1]);
                    String make = parts[2];
                    String model = parts[3];
                    String vehicleType = parts[4];
                    String color = parts[5];
                    int odometer = Integer.parseInt(parts[6]);
                    double price = Double.parseDouble(parts[7]);


                    Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);

                    inventory.add(vehicle);

                }

            }

            bufferedReader.close();

        } catch (FileNotFoundException e) {

            System.out.println("File Not Found. Please enter correct file name.");

        } catch (IOException e) {

            System.out.println("Error reading file.");

        }

        if (dealership != null){

            for (Vehicle vehicle : inventory) {

                dealership.addVehicle(vehicle);

            }

        }

        return dealership;
    }

    public void saveDealership(Dealership dealership) {


        try  {

            // overwrite the content of the file
            FileWriter fileWriter = new FileWriter(FILE_NAME, false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);


            // Write dealership information
            bufferedWriter.write(dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhone() + "\n");


            // Write inventory information
            ArrayList<Vehicle> inventory = dealership.getAllVehicles();

            for (Vehicle vehicle : inventory) {

                bufferedWriter.write(vehicle.getVin() + "|" + vehicle.getYear() + "|" + vehicle.getMake() + "|" + vehicle.getModel() + "|" +
                        vehicle.getVehicleType() + "|" + vehicle.getColor() + "|" + vehicle.getOdometer() + "|" + vehicle.getPrice() + "\n");

            }

            bufferedWriter.flush();
            bufferedWriter.close();

        } catch (IOException e) {

            System.out.println("Error writing to file.");

        }

    }


}
