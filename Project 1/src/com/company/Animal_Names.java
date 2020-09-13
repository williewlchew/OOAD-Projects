package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AnimalNames {

    // Variables
    private String MaleNamesPath;
    private String FemaleNamesPath;

    private List<String> MaleNames = new ArrayList<String>();
    private List<String> FemaleNames = new ArrayList<String>();

    // Setters
    private void SetMaleNamesPath(String file_path) {
        this.MaleNamesPath = file_path;
    }

    private void SetFemaleNamesPath(String file_path) {
        this.FemaleNamesPath = file_path;
    }

    // Getters



    // Other Functions
    private static List<String> read_names(String file_path) throws FileNotFoundException {

        List<String> names = new ArrayList<String>();


        BufferedReader br = new BufferedReader(new FileReader(file_path)) {
            String line;
            while((line = br.readLine()) != null) {
                names.add(line);
            }
        };
        return names;
    }

    private void set_names(String sex) throws FileNotFoundException {

        if ((sex == "M") || (sex == "Male")) {
            this.MaleNames = read_names(this.MaleNamesPath);
        }
        else if ((sex == "F") || (sex == "Female")) {
            this.FemaleNames = read_names(this.FemaleNamesPath);
        }
    }
}
