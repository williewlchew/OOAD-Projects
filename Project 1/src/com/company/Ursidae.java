package com.company;

import java.io.FileNotFoundException;


// The abstract class Ursidae
public abstract class Ursidae extends Animal{
    Ursidae(String _sex, AnimalNames names) throws FileNotFoundException {
        super(_sex, names);
    }


    // The Ursidaes get to eat the occasional large meal.
    @Override
    public String Eat() {
        /* Only need to use one random number generator in the Abstract Animal superclass. */
        float prob = super.rand.nextFloat();

        String food_str;

        if (prob < 0.20f) {
            food_str = super.GetName() + " the " + super.GetSpecies() + " feasts on a large meal.\n";
        }
        else {
            food_str = super.Eat();
        }
        return food_str;
    }
}

// The class Brown Bear, which is an animal in the zoo
class BrownBear extends Pachyderm {
    BrownBear(String _sex, AnimalNames names) throws FileNotFoundException   {
        super(_sex, names);
        super.SetSpecies("Brown Bear");
        super.SetName("B", names);
        super.SetNoise("growels");
    }

}

// The class Sun Bear, which is an animal in the zoo.
class SunBear extends Pachyderm {
    SunBear(String _sex, AnimalNames names) throws FileNotFoundException   {
        super(_sex, names);
        super.SetSpecies("Sun Bear");
        super.SetName("S", names);
        super.SetNoise("roars aggressively");
    }

    /* Due to the aggressive nature of the Sun Bear, there is a chance() that
    *  when ordered to sleep, it does not.*/
    @Override
    public String Sleep() {
        float prob = super.rand.nextFloat();

        String sleep_str = "";

        if (prob < 0.30f) {
            sleep_str = super.Roam();
        }
        else if ((prob > 0.30f) && (prob < 0.60f)) {
            sleep_str = super.MakeNoise() + super.Roam();
        }
        else {
            sleep_str = super.Sleep();
        }
        return sleep_str;
    }
}
