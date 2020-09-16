package com.company;

import com.company.AnimalNames;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        // Initialize a new Zoo
        Zoo zoo = new Zoo();

        // Simulate the Zoo for a week
        String gx = zoo.SimulateDays(7);
        System.out.println(gx);

        // Printing to a file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("dayatthezoo.out"))) {
            writer.write(gx);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
