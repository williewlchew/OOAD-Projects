package com.company;

public abstract class Animal {

    // Variables
    private String name = "";
    private boolean asleep;
    private boolean sex;




    // Functions that get overridden
    public abstract String MakeNoise();

    public abstract void SetName();

    public abstract String Roam();

    public abstract String Sleep();

    public abstract String WakeUp();

    public abstract String Eat();






}


// Family Names



abstract class Feline extends Animal {

}

abstract class Canine extends Animal {

}

abstract class Ursidae extends Animal {

}