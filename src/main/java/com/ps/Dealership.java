package com.ps;
import java.util.ArrayList;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }

    public String getName() { return name; }
    public String getAddress() { return address; }
    public String getPhone() { return phone; }
    public ArrayList<Vehicle> getAllVehicles() { return inventory; }

    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
        System.out.println("Vehicle added: " + vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        inventory.remove(vehicle);
        System.out.println("Vehicle removed: " + vehicle);
    }
}
