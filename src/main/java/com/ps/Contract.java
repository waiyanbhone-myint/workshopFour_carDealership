package com.ps;

public class Contract {
    private String date;
    private String customerName;
    private String customerEmail;
    private String type;
    private double totalPrice;
    private double monthlyPayment;

    public Contract(String date, String customerName, String customerEmail, String type, double totalPrice, double monthlyPayment) {
        this.date = date;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.type = type;
        this.totalPrice = totalPrice;
        this.monthlyPayment = monthlyPayment;
    }

    @Override
    public String toString() {
        return type + "|" + date + "|" + customerName + "|" + customerEmail + "|" + totalPrice + "|" + monthlyPayment;
    }
}
