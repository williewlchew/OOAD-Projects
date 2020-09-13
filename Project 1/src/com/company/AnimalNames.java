package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;


public class AnimalNames {

    // Variables
    private String MaleNamesPath;
    private String FemaleNamesPath;
    private List<String> MaleNames = new ArrayList<>();
    private List<String> FemaleNames = new ArrayList<String>();
    private static Random rand = new Random();

    // Setters
    protected void SetMaleNamesPath(String file_path) {
        this.MaleNamesPath = file_path;
    }

    protected void SetFemaleNamesPath(String file_path) {
        this.FemaleNamesPath = file_path;
    }

    // Getters
    public String GetRandomName(String sex) throws FileNotFoundException {
        String name = "";
        if (Objects.equals(sex, "M")) {
            name = GetRandomNameHelper(this.MaleNames);
        }
        else if (Objects.equals(sex, "F")) {
            name = GetRandomNameHelper(this.FemaleNames);
        }
        return name;
    }

    private String GetRandomNameHelper(List<String> names) {
        String name = names.get(this.rand.nextInt(names.size()));
        return name;
    }

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
        if (Objects.equals(sex, "M")) {
            this.MaleNames = ReadNames(this.MaleNamesPath);
        }
        else if (Objects.equals(sex, "F")) {
            this.FemaleNames = ReadNames(this.FemaleNamesPath);
        }
        return;
    }
}
