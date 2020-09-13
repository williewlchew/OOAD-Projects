package com.company;

import com.company.AnimalNames;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {

        // Read in the names of the animals
        AnimalNames names = new AnimalNames();

        names.SetMaleNamesPath("data/names/animal_names_M.csv");
        names.SetFemaleNamesPath("data/names/animal_names_F.csv");

        try {
            names.SetNames("M");
            names.SetNames("F");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
