package com.ps;

import java.io.*;
import java.util.ArrayList;

public class DealershipFileManager {

    public static Dealership getDealership() {
        Dealership dealership = null;
        try (BufferedReader br = new BufferedReader(new FileReader("inventory.csv"))) {
            String line = br.readLine();

            if (line != null) {
                String[] details = line.split("\\|");
                String name = details[0];
                String address = details[1];
                String phone = details[2];
                dealership = new Dealership(name, address, phone);

                while ((line = br.readLine()) != null) {
                    String[] vehicleDetails = line.split("\\|");
                    int vin = Integer.parseInt(vehicleDetails[0]);
                    int year = Integer.parseInt(vehicleDetails[1]);
                    String make = vehicleDetails[2];
                    String model = vehicleDetails[3];
                    String type = vehicleDetails[4];
                    String color = vehicleDetails[5];
                    int odometer = Integer.parseInt(vehicleDetails[6]);
                    double price = Double.parseDouble(vehicleDetails[7]);

                    Vehicle vehicle = new Vehicle(vin, year, make, model, type, color, odometer, price);
                    dealership.addVehicle(vehicle);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: Inventory file not found.");
        } catch (IOException e) {
            System.err.println("Error: Problem reading the inventory file.");
        } catch (NumberFormatException e) {
            System.err.println("Error: Incorrect data format in inventory file.");
        }

        if (dealership == null) {
            System.out.println("Warning: Dealership data not loaded. Creating a new empty dealership.");
            dealership = new Dealership("Unknown", "Unknown", "Unknown");
        }
        return dealership;
    }

    public static void saveDealership(Dealership dealership) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("inventory.csv"))) {
            // Save dealership info as the first line
            String firstLine = String.format("%s|%s|%s", dealership.getName(), dealership.getAddress(), dealership.getPhone());
            bw.write(firstLine);
            bw.newLine();

            // Save each vehicle on a new line
            ArrayList<Vehicle> vehicles = dealership.getAllVehicles();
            for (Vehicle vehicle : vehicles) {
                String vehicleLine = String.format("%d|%d|%s|%s|%s|%s|%d|%.2f",
                        vehicle.getVin(),
                        vehicle.getYear(),
                        vehicle.getMake(),
                        vehicle.getModel(),
                        vehicle.getType(),
                        vehicle.getColor(),
                        vehicle.getOdometer(),
                        vehicle.getPrice());
                bw.write(vehicleLine);
                bw.newLine();
            }
            System.out.println("Dealership data saved successfully.");
        } catch (IOException e) {
            System.err.println("Error: Unable to save dealership data.");
        }
    }
}
