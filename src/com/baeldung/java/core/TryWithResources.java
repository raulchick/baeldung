package com.baeldung.java.core;

import java.io.*;
import java.util.Scanner;

public class TryWithResources {
    public static void main(String[] args) {
        createTestData();

        //Reading from the file using try without resources
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("test.txt"));
            System.out.println("Reading from the file using \"try without resources\": ");
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }

        //Reading from the file using try with resources
        try (Scanner sc = new Scanner(new File("test.txt"))) {
            System.out.println("Reading from the file using \"try with resources\": ");
            while (sc.hasNext()) {
                System.out.println(sc.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void createTestData(){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("test.txt"));
            writer.write("test data line1\n");
            writer.write("test data line2\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
