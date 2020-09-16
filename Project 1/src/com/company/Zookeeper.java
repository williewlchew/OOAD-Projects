package com.company;

public class Zookeeper extends ZooEmployee {

    // Variables
    private String name;
    private float pay;

    // Constructor
    public Zookeeper(AnimalNames names){
        this.name = names.GetRandomName("Z", "M");
        this.pay = 0;
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
        String buffer = "Zookeeper " + name + " wakes up " + animal.GetName() + " the " + animal.GetSpecies() + ".\n";
        return(buffer + animal.WakeUp());
    }

    public String RollCall(Animal animal){
        String buffer = "Zookeeper " + name + " roll calls " + animal.GetName() + " the " + animal.GetSpecies() + ".\n";
        return(buffer + animal.MakeNoise());
    }

    public String Feed(Animal animal){
        String buffer = "Zookeeper " + name + " feeds " + animal.GetName() + " the " + animal.GetSpecies() + ".\n";
        return(buffer + animal.Eat());
    }

    public String Exercise(Animal animal){
        String buffer = "Zookeeper " + name + " exercises " + animal.GetName() + " the " + animal.GetSpecies() + ".\n";
        return(buffer + animal.Roam());
    }

    public String Sleep(Animal animal){
        String buffer = "Zookeeper " + name + " tucks in " + animal.GetName() + " the " + animal.GetSpecies() + ".\n";
        return(buffer + animal.Sleep());
    }
}
