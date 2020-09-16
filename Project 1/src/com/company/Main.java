package com.company;

import com.company.AnimalNames;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        // Read in the names of the animals

        AnimalNames names = new AnimalNames();
        Zoo zoo = new Zoo();

        String gx = zoo.SimulateDays(7);
        System.out.println(gx);

        // Printing to a file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {
            writer.write(gx);

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
