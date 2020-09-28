package com.company;

import java.util.Arrays;
import java.util.Random;


/*
* The Abstract animal class provides the template for all animals, and a set of common methods,
* getters, setters, and variables that all animals share. This is an example of an abstract class.
* This template is extended by the 4 main families (which are also abstract classes themselves.)
* The Animals themselves are not abstract classes.
*/

public abstract class Animal {

    // Constructor: sets the sex and selects a random name for the animal.
    Animal(String _sex, AnimalNames names) {
        this.sex = _sex;
        this.SetName(_sex, names);
    }

    // Variables
    private String species = "";
    private String name = "";
    private boolean asleep = true;
    private final String sex;
    protected static Random rand = new Random();
    private String noise = "";
    

    // Setters
    protected void SetName(String FirstChar, AnimalNames names) {
        this.name = names.GetRandomName(FirstChar, this.sex);
    }
    protected void SetSpecies(String _species) {
        this.species = _species;
    }
    protected void SetNoise(String _noise){
        this.noise = _noise;
    }

    // Getters
    public String GetName(){
        return(this.name);

    }
    public String GetSpecies() {
        return(this.species);

    }

    public String GetNoise() {
        return(this.noise);
    }

    // Methods
    public String MakeNoise() {
        String noise_str;
        noise_str = this.GetName() + " the "  + this.GetSpecies() + " " + this.GetNoise() + ".\n";
        return noise_str;

    }

    public String Roam(){
        String roam_str;
        roam_str = this.GetName() + " the " + this.GetSpecies() + " has roamed / exercised.\n";
        return roam_str;

    }

    public String Sleep(){
        String sleep_str;

        // Quick check to see if the animal object is actually asleep or not.
        if (this.asleep) {
            sleep_str =  this.GetName() + " the " + this.GetSpecies() + " is already asleep.\n";
        }
        else {
            sleep_str = this.GetName() + " the "  + this.GetSpecies() + " slumbers.\n";
            this.asleep = true;
        }
        return sleep_str;
    }

    public String WakeUp(){
        String awake_str;

        // Quick check to see if the animal object is actually awake or not.
        if (this.asleep) {
            awake_str = this.GetName() + " the " + this.GetSpecies() + " has woken up.\n";
            this.asleep = false;
        }
        else {
            awake_str = this.GetName() + " the " + this.GetSpecies() + " is already awake.\n";
        }
        return awake_str;

    }

    public String Eat(){
        String eat_str;
        eat_str = this.GetName() + " the " + this.GetSpecies() + " has eaten.\n";
        return eat_str;

    }
}
