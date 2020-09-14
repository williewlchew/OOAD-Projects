package com.company;

import java.io.FileNotFoundException;

public abstract class Animal {

    Animal(String _sex, AnimalNames names) throws FileNotFoundException {

        this.sex = _sex;
        this.SetName(_sex, names);
    }

    // Variables
    private String name = "";
    private boolean asleep = false;
    private String sex;


    // Functions that get overridden
    public String MakeNoise() {
        return null;
    }

    public void SetName(String FirstChar, AnimalNames names) throws FileNotFoundException {
        this.name = names.GetRandomName(FirstChar, this.sex);
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

    // Getters
    public void GetName(){
        System.out.println(this.name);
    }


}
