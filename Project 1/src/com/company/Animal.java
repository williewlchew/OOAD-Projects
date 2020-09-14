package com.company;

import java.io.FileNotFoundException;

public abstract class Animal {

    // Constructor
    Animal(String _sex, AnimalNames names) throws FileNotFoundException {

        this.sex = _sex;
        this.SetName(_sex, names);
    }

    // Variables
    private String species = "";
    private String name = "";
    private boolean asleep = false;
    private String sex;




    // Setters
    protected void SetName(String FirstChar, AnimalNames names) throws FileNotFoundException {
        this.name = names.GetRandomName(FirstChar, this.sex);
    }

    protected void SetSpecies(String _species) {
        this.species = _species;
    }


    // Actions
    public String MakeNoise() {
        return null;

    }

    public String Roam(){
        return null;

    }

    public String Sleep(){
        return null;

    }

    public String WakeUp(){
        return null;

    }

    public String Eat(){
        return null;

    }

    public String Exercise(){
        return null;
    }

    // Getters
    public String GetName(){
        return(this.name);

    }
    public String GetSpecies() {
        return(this.species);

    }


}
