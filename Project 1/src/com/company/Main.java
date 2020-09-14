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

        Hippo hippo1 = new Hippo("M", names);
        Hippo hippo2 = new Hippo("F", names);



        System.out.println(hippo1.GetName());
        System.out.println(hippo1.GetSpecies());

        for (int i = 0; i < 10; i++) {
            System.out.println(hippo1.Roam());
            System.out.println(hippo2.Roam());
        }

        System.out.println(hippo2.GetName());
        System.out.println(hippo2.GetSpecies());

        System.out.println(zoo.SimulateDays(7));

    }
}
