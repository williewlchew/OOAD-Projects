package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Objects;
import java.util.Random;


public class AnimalNames {

    AnimalNames() throws FileNotFoundException {
        this.MaleNamesPath = "data/names/animal_names_M.csv";
        this.FemaleNamesPath = "data/names/animal_names_F.csv";
        this.SetNames("M");
        this.SetNames("F");
    }

    // Variables
    private String MaleNamesPath;
    private String FemaleNamesPath;
    private List<String> MaleNames = new ArrayList<String>();
    private List<String> FemaleNames = new ArrayList<String>();
    private static final Random rand = new Random();

    // Setters
    protected void SetMaleNamesPath(String file_path) {
        this.MaleNamesPath = file_path;
    }

    protected void SetFemaleNamesPath(String file_path) {
        this.FemaleNamesPath = file_path;
    }

    // Getters
    public String GetRandomName(String FirstChar, String sex) {
        String name = "";
        if (Objects.equals(sex, "M")) {
            name = GetRandomNameHelper(FirstChar, this.MaleNames);
        }
        else if (Objects.equals(sex, "F")) {
            name = GetRandomNameHelper(FirstChar, this.FemaleNames);
        }
        return name;
    }

    private String GetRandomNameHelper(String FirstChar, List<String> names) {

        // https://beginnersbook.com/2017/10/java-8-stream-filter/
        List<String> FirstCharNames = names.stream().filter(str -> str.startsWith(FirstChar)).collect(Collectors.toList());

        String name = FirstCharNames.get(this.rand.nextInt(FirstCharNames.size()));
        return name;
    }

    // Other Functions
    private static List<String> ReadNames(String file_path) {

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
