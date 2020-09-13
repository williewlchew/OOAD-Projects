package com.company;

import com.company.AnimalNames;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        // Read in the names of the animals
        AnimalNames names = new AnimalNames();
        Zoo zoo = new Zoo();

        names.SetMaleNamesPath("data/names/animal_names_M.csv");
        names.SetFemaleNamesPath("data/names/animal_names_F.csv");


        names.SetNames("M");
        names.SetNames("F");


        System.out.println(names.GetRandomName("F"));
        System.out.println(names.GetRandomName("M"));

        System.out.println(zoo.SimulateDays(7));

    }
}
