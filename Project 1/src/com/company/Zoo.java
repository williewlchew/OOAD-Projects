package com.company;

import java.io.FileNotFoundException;
import java.util.Random;

public class Zoo {

    // Variables
    AnimalNames names = new AnimalNames();
    private Animal[] animals;
    private Zookeeper keeper;
    private static Random rand = new Random();

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
        for(int speciesCount : speciesCounts){
            speciesCount = 2 + rand.nextInt(3);
            animalsCounts += speciesCount;
        }

        animals = new Animal[animalsCounts];
        int animalIndex = 0;
        for (int i = 0; i < 10; i++){
            for(int j = 0; j < speciesCounts[i]; j++){
                animals[animalIndex] = InitAnimal(i);
                animalIndex++;
            }
        }
    }

    public Animal InitAnimal(int x) throws FileNotFoundException {
        String[] sexes = {"M", "F"};
        int rnd = new Random().nextInt(sexes.length);
        return switch (x) {
            case 1 -> (new Hippo(sexes[rnd], names));
            case 2 -> (new Elephant(sexes[rnd], names));
            case 3 -> (new Rhino(sexes[rnd], names));
            case 4 -> (new Cat(sexes[rnd], names));
            case 5 -> (new Lion(sexes[rnd], names));
            case 6 -> (new Tiger(sexes[rnd], names));
            case 7 -> (new Wolf(sexes[rnd], names));
            case 8 -> (new Dog(sexes[rnd], names));
            case 9 -> (new BrownBear(sexes[rnd], names));
            case 10 -> (new SunBear(sexes[rnd], names));
            default -> throw new IllegalStateException("Unexpected value: " + x);
        };

        // should never get here
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
    }
}
