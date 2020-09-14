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

        StringBuilder buffer = new StringBuilder();

        for(int day = 0; day < days; day++){
            buffer.append(keeper.Arrive());
            buffer.append(keeper.Leave());
        }

        return buffer.toString();
        //asdfasdfasdf
    }
}
