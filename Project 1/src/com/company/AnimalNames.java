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
    protected void SetMaleNamesPath(String file_path) {
        this.MaleNamesPath = file_path;
    }

    protected void SetFemaleNamesPath(String file_path) {
        this.FemaleNamesPath = file_path;
    }

    // Getters
//    private String GetRandomName(String sex) {
//
//    }


    // Other Functions
    private static List<String> ReadNames(String file_path) throws FileNotFoundException {

        List<String> names = new ArrayList<String>();
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(file_path))) {
            while((line = br.readLine()) != null) {
                names.add(line);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Done reading the file: " + file_path);
        return names;
    }

    public void SetNames(String sex) throws FileNotFoundException {

        if ((sex == "M") || (sex == "Male")) {
            this.MaleNames = ReadNames(this.MaleNamesPath);
        }
        else if ((sex == "F") || (sex == "Female")) {
            this.FemaleNames = ReadNames(this.FemaleNamesPath);
        }
        return;
    }
}
