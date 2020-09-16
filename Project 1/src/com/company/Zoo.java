package com.company;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Random;

public class Zoo {

    // Variables
    private AnimalNames names = new AnimalNames();
    private Animal[] animals;
    private Zookeeper keeper;
    private static Random rand = new Random();

    // Constructor
    public Zoo() throws FileNotFoundException{
        //## init animals
        this.InitAnimals();

        //## init keepers
        this.keeper = new Zookeeper(names);
    }

    // Initialization Methods
    public void InitAnimals() throws FileNotFoundException {
        int animalsCounts = 0;
        int[] speciesCounts = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for(int i = 0; i < speciesCounts.length; i++){
            speciesCounts[i] = 2 + this.rand.nextInt(3);
            animalsCounts += speciesCounts[i];
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
            case 0 -> (new Hippo(sexes[rnd], this.names));
            case 1 -> (new Elephant(sexes[rnd], this.names));
            case 2 -> (new Rhino(sexes[rnd], this.names));
            case 3 -> (new Cat(sexes[rnd], this.names));
            case 4 -> (new Lion(sexes[rnd], this.names));
            case 5 -> (new Tiger(sexes[rnd], this.names));
            case 6 -> (new Wolf(sexes[rnd], this.names));
            case 7 -> (new Dog(sexes[rnd], this.names));
            case 8 -> (new BrownBear(sexes[rnd], this.names));
            case 9 -> (new SunBear(sexes[rnd], this.names));
            default -> throw new IllegalStateException("Unexpected value: " + x);
        };

        // should never get here
    }

    // Methods
    public String SimulateDays(int days){

        StringBuilder buffer = new StringBuilder();
        buffer.append("Zoo uptime: " + days + " days.\n\n");
        for(int day = 0; day < days; day++){
            buffer.append("Day #" + (day + 1) + "\n");
            buffer.append("\n");
            buffer.append(this.keeper.Arrive());
            buffer.append("--------------------\n");
            buffer.append(this.ZooKeeping());
            buffer.append("--------------------\n");
            buffer.append(this.keeper.Leave());
            buffer.append("\n");
        }

        return buffer.toString();
    }

    public String ZooKeeping(){
        StringBuilder buffer = new StringBuilder();
        Arrays.stream(this.animals).map(a -> this.keeper.Wake(a)).forEach(buffer::append);
        Arrays.stream(this.animals).map(a -> this.keeper.RollCall(a)).forEach(buffer::append);
        Arrays.stream(this.animals).map(a -> this.keeper.Feed(a)).forEach(buffer::append);
        Arrays.stream(this.animals).map(a -> this.keeper.Exercise(a)).forEach(buffer::append);
        Arrays.stream(this.animals).map(a -> this.keeper.Sleep(a)).forEach(buffer::append);
        return buffer.toString();
    }
}
