package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Objects;
import java.util.Random;

/* This class holds the names from the U.S. Census.
* It splits the names into female and male names, and returns
* a random name from GetRandomNameHelper.
* This class implements a significant amount of encapsulation, as
* it holds all of the data, and uses a simple 'API / function call'
* to get a random name, without needing to be very explicit.
* The data and the methods that operate on the data (GetRandomName) exist together in one class.
* names.GetRandomName("A", "F") is all one needs to get a random female name that starts with an A
* after instantiation of the class as an object.
 */
public class AnimalNames {

    AnimalNames() throws FileNotFoundException {
        this.MaleNamesPath = "../../../data/names/animal_names_M.csv";
        this.FemaleNamesPath = "../../../data/names/animal_names_F.csv";
        this.SetNames("M");
        this.SetNames("F");
    }

    // Variables
    private String MaleNamesPath;
    private String FemaleNamesPath;
    private List<String> MaleNames = new ArrayList<String>();
    private List<String> FemaleNames = new ArrayList<String>();
    private static final Random rand = new Random();


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

    // Helper Functions

    /* This function takes the first character (FirstChar) of the specific type of animal
    * (such as 'H' for Hippo) and filters out all of the names that do not start with FirstChar.
    * Then it uses a random number generator to randomly pick one of those names from the list of names
    * that start with FirstChar.
     */
    private String GetRandomNameHelper(String FirstChar, List<String> names) {

        // https://beginnersbook.com/2017/10/java-8-stream-filter/
        List<String> FirstCharNames = names.stream().filter(str -> str.startsWith(FirstChar)).collect(Collectors.toList());

        String name = FirstCharNames.get(this.rand.nextInt(FirstCharNames.size()));
        return name;
    }

    /*  ReadNames reads in the files and adds then returns the names.
    * It uses the BufferedReader.
    * */
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

    // Setters
    /*
    * A wrapper function for ReadNames essentially that sets the names,
    * for Male and Female Names.
    * */
    public void SetNames(String sex) {
        if (Objects.equals(sex, "M")) {
            this.MaleNames = ReadNames(this.MaleNamesPath);
        }
        else if (Objects.equals(sex, "F")) {
            this.FemaleNames = ReadNames(this.FemaleNamesPath);
        }
        return;
    }
}
