package com.company;

import java.io.FileNotFoundException;
import java.util.Random;

public abstract class Animal {


    // Constructor
    Animal(String _sex, AnimalNames names) throws FileNotFoundException {

        this.sex = _sex;
        this.SetName(_sex, names);
    }

    // Variables
    private String species = "";
    private String name = "";
    private boolean asleep = true;
    private String sex;
    protected static Random rand = new Random();
    private String noise = "";





    // Setters
    protected void SetName(String FirstChar, AnimalNames names) throws FileNotFoundException {
        this.name = names.GetRandomName(FirstChar, this.sex);
    }

    protected void SetSpecies(String _species) {
        this.species = _species;
    }
    protected  void SetNoise(String _noise){
        this.noise = _noise;
    }

    // Actions
    public String MakeNoise() {
        String noise_str = "";
        noise_str = this.name + " the "  + this.species + " " + this.noise + ".\n";
        return noise_str;

    }

    public String Roam(){
        return null;

    }

    public String Sleep(){
        String sleep_str = "";
        if (this.asleep) {
            sleep_str =  this.name + " the " + this.species + " is already asleep.\n";
        }
        else {
            sleep_str = this.name + " the "  + this.species + " slumbers.\n";
            this.asleep = true;
        }
        return sleep_str;
    }

    public String WakeUp(){
        String awake_str = "";
        if (this.asleep) {
            awake_str = this.name + " the " + this.species + " has woken up.\n";
            this.asleep = false;
        }
        else {
            awake_str = this.name + " the " + this.species + " is already awake.\n";
        }
        return awake_str;

    }

    public String Eat(){
        String eat_str = "";
        eat_str = this.name + " the " + this.species + " has eaten.\n";
        return eat_str;

    }


    // Getters
    public String GetName(){
        return(this.name);

    }
    public String GetSpecies() {
        return(this.species);

    }



}
