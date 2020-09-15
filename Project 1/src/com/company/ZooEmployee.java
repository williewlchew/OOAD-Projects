package com.company;

public abstract class ZooEmployee {

    // Variables
    private String name;
    private float pay;

    // Constructor
    public ZooEmployee(){
        name = "Willie";
        pay = 0;
    }

    // Methods
    public String GetName(){
        return(name);
    }
}
