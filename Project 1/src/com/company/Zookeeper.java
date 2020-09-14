package com.company;

public class Zookeeper extends ZooEmployee {

    // Variables
    private String name;
    private float pay;

    // Constructor
    public Zookeeper(){
        name = "Willie"; //temp
        pay = 0;
    }

    // Basic Methods
    public String Arrive(){
        return("Zookeeper " + name + " arrives at the Zoo.\n");
    }

    public String Leave(){
        return("Zookeeper " + name + " left the Zoo.\n");
    }

    // Zookeeping Methods
    public String Wake(Animal animal){
        String buffer = "Zookeeper " + name + " feeds" + animal.GetName() +".\n";
        return(buffer + animal.Eat());
    }

    public String RollCall(){
        return("Testing\n");
    }

    public String Feed(){
        return("Testing\n");
    }

    public String Exercise(){
        return("Testing\n");
    }


}
