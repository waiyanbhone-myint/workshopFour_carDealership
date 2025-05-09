package com.ps;

import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;

public class DealershipFileManager {
    public static Dealership getDealership(){
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("inventory.csv"));

            String input = bufferedReader.readLine();
            String[] dealershipDetails = input.split("\\|");
            String name = dealershipDetails[0];
            String address = dealershipDetails[1];
            String phone = dealershipDetails[2];

            while((input = bufferedReader.readLine()) != null){
                String[] vehicleDetails = input.split("\\|");
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
        catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
    public static void saveDealership(Dealership dealership){
        try{
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("inventory_test.csv"));

            String firstLine = String.format("%s|%s|%s", dealership.getName(),
                    dealership.getAddress(),
                    dealership.getPhone());

            bufferedWriter.write(firstLine);

            ArrayList<Vehicle> vehicles = dealership.getAllVehicle();

            for(Vehicle vehicle: vehicles){
                String vehicleLine = String.format("%d|%d|%s|%s|%s|%s|%d|%f",
                        vehicle.getVin(),
                        vehicle.getYear(),
                        vehicle.getMake(),
                        vehicle.getModel(),
                        vehicle.getType(),
                        vehicle.getColor(),
                        vehicle.getOdometer(),
                        vehicle.getPrice()
                );
                bufferedWriter.write(vehicleLine);
            }
            bufferedWriter.close();

        }catch (IOException e){
            throw new RuntimeException(e);
        }

    }
}
