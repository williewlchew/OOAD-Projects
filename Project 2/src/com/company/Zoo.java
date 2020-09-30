package com.company;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Random;

public class Zoo {

    // Variables
    private AnimalNames names = new AnimalNames();
    private Animal[] animals;

    private Zookeeper keeper;
    private MessageBean keeperBean;
    private MessageBean foodBean;
    private ZooAnnouncer announcer;
    private ZooFoodServer foodserver;

    private ZooClock clock;
    private MessageBean clockBean;

    private static Random rand = new Random();

    // Constructor
    public Zoo() throws FileNotFoundException{
        //init animals
        this.InitAnimals();

        //init keepers
        /* Because of both encapsulation and abstraction,
         * we can name the zookeeper!
         * His name always starts with a 'Z', since that's what he is.
        */
        this.keeper = new Zookeeper(names);
        this.announcer = new ZooAnnouncer(names);
        this.foodserver = new ZooFoodServer(names);

        // init keeper bean
        keeperBean = new MessageBean();

        // init food server bean
        foodBean = new MessageBean();

        // init clock
        clockBean = new MessageBean();
        this.clock = new ZooClock(clockBean);
    }

    // Initialization Methods

    /*
     * This function initializes the animals in the zoo, and assigns
     * them a frequency of: 2 < f < 5. It then populates the zoo
     * by initializing animals in the animals list. Each index is a different
     * species in speciesCounts, with the value in there being f.
     *
     * Each of these animals have their own unique identity, so the
     * JVM / compiler does not get confused by the same animal species,
     * even if they may just have different names at the end of the day.
     */
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

    /*
    * This function initializes an animal based on the
    * index of speciesCount in InitAnimals() above. It then calls
    * the different constructors that initialize a new animal
    * given it's specific sex, and the names encapsulation class.
    * A switch statement is used to construct these classes.
    * */
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

    /*
    * This function runs the zoo for n days. It is primarily for aggregating
    * the return string statements made by the animals and the zookeepers,
    * as well as some utility strings that tell the date, and the
    * arrival, departure of the zookeeper. These strings are appended to
    * a StringBuilder buffer and returned.
    * */
    public String SimulateDays(int days){
        StringBuilder buffer = new StringBuilder();
        buffer.append("Zoo uptime: " + days + " days.\n\n");
        for(int day = 0; day < days; day++){
            clock.ResetTime();
            buffer.append(ZooKeeping());
        }

        return buffer.toString();
    }

    /*
     * This function implements the Zookeeper's actions for each animal in the zoo.
     * It then appends the outputs of both the Zookeeper and the animals to the buffer,
     * and returns the string buffer.
     */
    public String ZooKeeping(){
        StringBuilder buffer = new StringBuilder();

        keeper.Arrive(animals, clockBean, keeperBean);
        announcer.Arrive(keeperBean);

        while(clock.GetTime() < 20){
            clock.ProgressTime();
        }

        buffer.append(keeper.Leave());
        announcer.Leave();

        return buffer.toString();
    }


    public String ZooFoodServing(){
        StringBuilder buffer = new StringBuilder();
        foodserver.Arrive(clockBean, foodBean);
        announcer.Arrive(foodBean);

        while(clock.GetTime() < 20){
            clock.ProgressTime();
        }

        buffer.append(foodserver.Leave());
        announcer.Leave();

        return buffer.toString();
    }
}
