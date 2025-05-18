package com.ps;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ContractFileManager {
    public static void saveContract(Contract contract) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("contracts.csv", true))) {
            bw.write(contract.toString());
            bw.newLine();
            System.out.println("Contract saved successfully.");
        } catch (IOException e) {
            System.err.println("Error saving contract: " + e.getMessage());
        }
    }
}
