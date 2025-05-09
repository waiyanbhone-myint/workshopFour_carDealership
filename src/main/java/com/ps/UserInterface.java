package com.ps;

import javax.swing.*;
import java.util.Scanner;

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
    }

    public void processGetByMakeModelRequest() {
        // Process request to get vehicles by make and model
    }

    public void processGetByYearRequest() {
        // Process request to get vehicles by year
    }

    public void processGetByColorRequest() {
        // Process request to get vehicles by color
    }

    public void processGetByMileageRequest() {
        // Process request to get vehicles by mileage
    }

    public void processGetByVehicleTypeRequest() {
        // Process request to get vehicles by vehicle type
    }

    public void processGetAllVehiclesRequest() {
        // Process request to get all vehicles
    }

    public void processAddVehicleRequest() {
        // Process request to add a new vehicle
    }

    public void processRemoveVehicleRequest() {
        // Process request to remove a vehicle
    }
}
