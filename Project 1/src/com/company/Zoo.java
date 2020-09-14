package com.company;

import java.io.FileNotFoundException;
import java.util.Random;

public class Zoo {

    // Variables
    AnimalNames names = new AnimalNames();
    private Animal[] animals;
    private Zookeeper keeper;

    // Constructor
    public Zoo() throws FileNotFoundException{
        //## init animals
        InitAnimals();

        //## init keepers
        keeper = new Zookeeper();
    }

    // Initialization Methods
    public void InitAnimals() throws FileNotFoundException {
        int[] speciesCounts = {0,0,0,0,0,0,0,0,0,0};
        int animalsCounts = 0;
        int rnd;
        for(int speciesCount : speciesCounts){
            rnd = new Random().nextInt(3);
            speciesCount = 2 + rnd;
            animalsCounts += speciesCount;
        };

        animals = new Animal[animalsCounts];
        int animalIndex = 0;
        for (int i = 0; i < 10; i++){
            for(int j = 0; j < i; j++){
                animals[animalIndex] = InitAnimal(i);
                animalIndex++;
            }
        }
    }

    public Animal InitAnimal(int x) throws FileNotFoundException {
        String[] sexes = {"M", "F"};
        int rnd = new Random().nextInt(sexes.length);
        switch (x){
            case 1:
                return(new Hippo(sexes[rnd], names));
                break;
            case 2:
                return(new Elephant(sexes[rnd], names));
                break;
            case 3:
                return(new Rhino(sexes[rnd], names));
                break;
            case 4:
                return(new Cat(sexes[rnd], names));
                break;
            case 5:
                return(new Lion(sexes[rnd], names));
                break;
            case 6:
                return(new Tiger(sexes[rnd], names));
                break;
            case 7:
                return(new Wolf(sexes[rnd], names));
                break;
            case 8:
                return(new Dog(sexes[rnd], names));
                break;
            case 9:
                return(new BrownBear(sexes[rnd], names));
                break;
            case 10:
                return(new SunBear(sexes[rnd], names));
            break;
        }

        return(new Hippo(sexes[rnd], names)); // should never get here
    }

    // Methods
    public String SimulateDays(int days){

        StringBuilder buffer = new StringBuilder();

        for(int day = 0; day < days; day++){
            buffer.append(keeper.Arrive());
            buffer.append(ZooKeeping());
            buffer.append(keeper.Leave());
        }

        return buffer.toString();
    }

    public String ZooKeeping(){
        StringBuilder buffer = new StringBuilder();
        for(Animal a : animals){
            buffer.append(keeper.Wake(a));
        }
        for(Animal a : animals){
            buffer.append(keeper.RollCall(a));
        }
        for(Animal a : animals){
            buffer.append(keeper.Feed(a));
        }
        for(Animal a : animals){
            buffer.append(keeper.Exercise(a));
        }
        for(Animal a : animals){
            buffer.append(keeper.Sleep(a));
        }
        return buffer.toString();
    };
}
