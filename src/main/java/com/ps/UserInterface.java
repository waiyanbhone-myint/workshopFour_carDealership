package com.ps;

import javax.swing.*;
import java.util.Scanner;
import java.util.ArrayList;

public class UserInterface {
    private Dealership dealership = new Dealership();
    private Scanner scanner = new Scanner(System.in);

    private void init() {
        dealership = DealershipFileManager.getDealership();
    }

    public UserInterface() {
        // Constructor
    }

    public void display() {
        // Create main menu
        System.out.println("Welcome to Dealership Program.");

        int mainMenuCommand;

        do{
            System.out.println("1. Get by price");
            System.out.println("2. Get by make/model");
            System.out.println("3. Get by year");
            System.out.println("4. Get by color");
            System.out.println("5. Get by mileage");
            System.out.println("6. Get by type");
            System.out.println("7. Get all");
            System.out.println("8. Add vehicle");
            System.out.println("9. Remove vehicle");
            System.out.println("0. Exit");

            System.out.println("Command: ");
            mainMenuCommand = scanner.nextInt();

            switch (mainMenuCommand){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 0:
                    System.out.println("Exiting.....");
                    break;
                default:
                    System.out.println("Command not found, try again.");
            }
        }while (mainMenuCommand !=0 );
    }

    public void processGetByPriceRequest() {
        // Process request to get vehicles by price
        System.out.print("Enter maximum price: ");
        double maxPrice = scanner.nextDouble();
        scanner.nextLine(); // consume newline

        ArrayList<Vehicle> vehicles = dealership.getAllVehicle();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getPrice() <= maxPrice) {
                System.out.println(vehicle);
            }
        }
    }

    public void processGetByMakeModelRequest() {
        // Process request to get vehicles by make and model
        System.out.print("Enter make: ");
        String make = scanner.nextLine();
        System.out.print("Enter model: ");
        String model = scanner.nextLine();

        ArrayList<Vehicle> vehicles = dealership.getAllVehicle();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model)) {
                System.out.println(vehicle);
            }
        }
    }

    public void processGetByYearRequest() {
        // Process request to get vehicles by year
        System.out.print("Enter year: ");
        int year = scanner.nextInt();
        scanner.nextLine(); // consume newline

        ArrayList<Vehicle> vehicles = dealership.getAllVehicle();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getYear() == year) {
                System.out.println(vehicle);
            }
        }
    }

    public void processGetByColorRequest() {
        // Process request to get vehicles by color
        System.out.print("Enter color: ");
        String color = scanner.nextLine();

        ArrayList<Vehicle> vehicles = dealership.getAllVehicle();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getColor().equalsIgnoreCase(color)) {
                System.out.println(vehicle);
            }
        }
    }

    public void processGetByMileageRequest() {
        // Process request to get vehicles by mileage
        System.out.print("Enter maximum mileage: ");
        int maxMileage = scanner.nextInt();
        scanner.nextLine(); // consume newline

        ArrayList<Vehicle> vehicles = dealership.getAllVehicle();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getOdometer() <= maxMileage) {
                System.out.println(vehicle);
            }
        }
    }

    public void processGetByVehicleTypeRequest() {
        // Process request to get vehicles by vehicle type
        System.out.print("Enter vehicle type: ");
        String type = scanner.nextLine();

        ArrayList<Vehicle> vehicles = dealership.getAllVehicle();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getType().equalsIgnoreCase(type)) {
                System.out.println(vehicle);
            }
        }
    }

    public void processGetAllVehiclesRequest() {
        // Process request to get all vehicles
        ArrayList<Vehicle> vehicles = dealership.getAllVehicle();
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles available.");
        } else {
            for (Vehicle vehicle : vehicles) {
                System.out.println(vehicle);
            }
        }
    }

    public void processAddVehicleRequest() {
        // Process request to add a new vehicle
        System.out.println("Adding a new vehicle:");

        System.out.print("Enter VIN: ");
        int vin = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.print("Enter year: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter make: ");
        String make = scanner.nextLine();

        System.out.print("Enter model: ");
        String model = scanner.nextLine();

        System.out.print("Enter type: ");
        String type = scanner.nextLine();

        System.out.print("Enter color: ");
        String color = scanner.nextLine();

        System.out.print("Enter mileage: ");
        int odometer = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        Vehicle newVehicle = new Vehicle(vin, year, make, model, type, color, odometer, price);
        dealership.addVehicle(newVehicle);
        DealershipFileManager.saveDealership(dealership);

        System.out.println("Vehicle added successfully!");
    }

    public void processRemoveVehicleRequest() {
        // Process request to remove a vehicle
        System.out.print("Enter VIN to remove: ");
        int vin = scanner.nextInt();
        scanner.nextLine();

        ArrayList<Vehicle> vehicles = dealership.getAllVehicle();
        boolean found = false;

        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVin() == vin) {
                vehicles.remove(vehicle);
                found = true;
                System.out.println("Vehicle removed successfully!");
                DealershipFileManager.saveDealership(dealership);
                break;
            }
        }

        if (!found) {
            System.out.println("Vehicle not found.");
        }
    }
    }
}
