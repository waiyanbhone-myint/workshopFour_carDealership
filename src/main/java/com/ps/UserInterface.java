package com.ps;

import java.util.Scanner;
import java.util.ArrayList;

public class UserInterface {
    private Dealership dealership;
    private Scanner scanner = new Scanner(System.in);

    // Initialization to load dealership data
    private void init() {
        dealership = DealershipFileManager.getDealership();
        if (dealership == null) {
            System.out.println("Dealership data not found. Please enter dealership details.");
            System.out.print("Enter Dealership Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Dealership Address: ");
            String address = scanner.nextLine();
            System.out.print("Enter Dealership Phone: ");
            String phone = scanner.nextLine();
            dealership = new Dealership(name, address, phone);
            DealershipFileManager.saveDealership(dealership);
            System.out.println("New dealership created and saved.");
        }
    }

    // Constructor
    public UserInterface() {
        init();
    }

    // Main menu display and input handling
    public void display() {
        System.out.println("Welcome to Dealership Program.");

        while (true) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Get by price");
            System.out.println("2. Get by make/model");
            System.out.println("3. Get by year");
            System.out.println("4. Get by color");
            System.out.println("5. Get by mileage");
            System.out.println("6. Get by type");
            System.out.println("7. Get all vehicles");
            System.out.println("8. Add vehicle");
            System.out.println("9. Remove vehicle");
            System.out.println("10. Sell/Lease a Vehicle");
            System.out.println("0. Exit");
            System.out.print("Command: ");

            int mainMenuCommand;
            if (scanner.hasNextInt()) {
                mainMenuCommand = scanner.nextInt();
                scanner.nextLine(); // consume newline
            } else {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine(); // Clear the invalid input
                continue; // Restart the loop
            }

            switch (mainMenuCommand) {
                case 1 -> processGetByPriceRequest();
                case 2 -> processGetByMakeModelRequest();
                case 3 -> processGetByYearRequest();
                case 4 -> processGetByColorRequest();
                case 5 -> processGetByMileageRequest();
                case 6 -> processGetByVehicleTypeRequest();
                case 7 -> processGetAllVehiclesRequest();
                case 8 -> processAddVehicleRequest();
                case 9 -> processRemoveVehicleRequest();
                case 10 -> processSellOrLeaseVehicle();
                case 0 -> {
                    System.out.println("Exiting...");
                    return; // Exit the program
                }
                default -> System.out.println("Command not found, try again.");
            }
        }
    }

    // Get vehicles by price
    public void processGetByPriceRequest() {
        System.out.print("Enter maximum price: ");
        double maxPrice = scanner.nextDouble();
        scanner.nextLine();

        ArrayList<Vehicle> vehicles = dealership.getAllVehicles();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getPrice() <= maxPrice) {
                System.out.println(vehicle);
            }
        }
        pause();
    }

    // Get vehicles by make and model
    public void processGetByMakeModelRequest() {
        System.out.print("Enter make: ");
        String make = scanner.nextLine();
        System.out.print("Enter model: ");
        String model = scanner.nextLine();

        ArrayList<Vehicle> vehicles = dealership.getAllVehicles();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model)) {
                System.out.println(vehicle);
            }
        }
        pause();
    }

    // Get vehicles by year
    public void processGetByYearRequest() {
        System.out.print("Enter year: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        ArrayList<Vehicle> vehicles = dealership.getAllVehicles();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getYear() == year) {
                System.out.println(vehicle);
            }
        }
        pause();
    }

    public void processGetByColorRequest() {
        System.out.print("Enter color: ");
        String color = scanner.nextLine();

        ArrayList<Vehicle> vehicles = dealership.getAllVehicles();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getColor().equalsIgnoreCase(color)) {
                System.out.println(vehicle);
            }
        }
        pause();
    }

    public void processGetByMileageRequest() {
        System.out.print("Enter maximum mileage: ");
        int maxMileage = scanner.nextInt();
        scanner.nextLine();

        ArrayList<Vehicle> vehicles = dealership.getAllVehicles();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getOdometer() <= maxMileage) {
                System.out.println(vehicle);
            }
        }
        pause();
    }

    public void processGetByVehicleTypeRequest() {
        System.out.print("Enter vehicle type: ");
        String type = scanner.nextLine();

        ArrayList<Vehicle> vehicles = dealership.getAllVehicles();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getType().equalsIgnoreCase(type)) {
                System.out.println(vehicle);
            }
        }
        pause();
    }

    public void processGetAllVehiclesRequest() {
        ArrayList<Vehicle> vehicles = dealership.getAllVehicles();
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles available.");
        } else {
            for (Vehicle vehicle : vehicles) {
                System.out.println(vehicle);
            }
        }
        pause();
    }

    public void processAddVehicleRequest() {
        System.out.println("Adding a new vehicle:");
        System.out.print("Enter VIN: ");
        int vin = scanner.nextInt();
        scanner.nextLine();
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
        pause();
    }

    public void processRemoveVehicleRequest() {
        System.out.print("Enter VIN to remove: ");
        int vin = scanner.nextInt();
        scanner.nextLine();

        ArrayList<Vehicle> vehicles = dealership.getAllVehicles();
        boolean found = false;

        for (int i = 0; i < vehicles.size(); i++) {
            if (vehicles.get(i).getVin() == vin) {
                vehicles.remove(i);
                found = true;
                System.out.println("Vehicle removed successfully!");
                DealershipFileManager.saveDealership(dealership);
                break;
            }
        }
        if (!found) {
            System.out.println("Vehicle not found.");
        }
        pause();
    }

    private void pause() {
        System.out.println("Press Enter to return to the menu...");
        scanner.nextLine();
    }

    public void processSellOrLeaseVehicle() {
        System.out.print("Enter VIN: ");
        int vin = scanner.nextInt();
        scanner.nextLine();

        Vehicle vehicle = null;
        for (Vehicle v : dealership.getAllVehicles()) {
            if (v.getVin() == vin) {
                vehicle = v;
                break;
            }
        }

        if (vehicle == null) {
            System.out.println("Vehicle not found.");
            return;
        }

        System.out.print("Enter Customer Name: ");
        String customerName = scanner.nextLine();
        System.out.print("Enter Customer Email: ");
        String customerEmail = scanner.nextLine();

        System.out.print("Is this a Sale or Lease (S/L)? ");
        String type = scanner.nextLine().toUpperCase();

        double totalPrice;
        double monthlyPayment = 0.0;

        if (type.equals("S")) {
            totalPrice = vehicle.getPrice() * 1.05; // Including 5% tax
            System.out.print("Finance? (yes/no): ");
            boolean finance = scanner.nextLine().equalsIgnoreCase("yes");
            if (finance) {
                double rate = (vehicle.getPrice() >= 10000) ? 0.0425 : 0.0525;
                int months = (vehicle.getPrice() >= 10000) ? 48 : 24;
                monthlyPayment = (totalPrice * rate) / months;
            }
            System.out.println("Sale Contract Created.");
        } else if (type.equals("L")) {
            if (vehicle.getYear() < 2022) {
                System.out.println("Cannot lease a vehicle older than 3 years.");
                return;
            }
            totalPrice = vehicle.getPrice() * 1.07; // Including 7% lease fee
            monthlyPayment = (totalPrice * 0.04) / 36; // Lease rate
            System.out.println("Lease Contract Created.");
        } else {
            System.out.println("Invalid choice.");
            return;
        }

        Contract contract = new Contract("2021-09-28", customerName, customerEmail, type, totalPrice, monthlyPayment);
        ContractFileManager.saveContract(contract);
    }

}
