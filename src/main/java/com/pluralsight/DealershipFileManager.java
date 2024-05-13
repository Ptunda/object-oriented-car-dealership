package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DealershipFileManager {

    public static final String FILE_NAME = "dealership.csv";

    public Dealership getDealership() {

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

                    Dealership dealership = new Dealership(name, address, phone);

                }

            }

            bufferedReader.close();

        } catch (FileNotFoundException e) {

            System.out.println("File Not Found. Please enter correct file name.");

        } catch (IOException e) {

            System.out.println("Error reading file.");

        }




        return null; // Stub implementation
    }

    public void saveDealership(Dealership dealership) {
        // Stub implementation
    }

}
