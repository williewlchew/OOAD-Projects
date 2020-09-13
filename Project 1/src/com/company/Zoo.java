package com.company;

public class Zoo {

    // Variables
    private Animal[] animals;
    private Zookeeper keeper;

    // Constructor
    public Zoo(){
        //## init animals
        //## init keepers
        keeper = new Zookeeper();
    }

    // Methods
    public String SimulateDays(int days){

        String buffer = "";

        for(int day = 0; day < days; day++){
            buffer = buffer + keeper.Arrive();
            buffer = buffer + keeper.Leave();
        }

        return buffer;
    }
}
