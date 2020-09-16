package com.company;

import java.io.FileNotFoundException;

public abstract class Ursidae extends Animal{
    Ursidae(String _sex, AnimalNames names) throws FileNotFoundException {
        super(_sex, names);
    }

    @Override
    public String Eat() {

        float prob = rand.nextFloat();

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


class BrownBear extends Pachyderm {
    BrownBear(String _sex, AnimalNames names) throws FileNotFoundException   {
        super(_sex, names);
        super.SetSpecies("Brown Bear");
        super.SetName("B", names);
        super.SetNoise("growels");
    }

}

class SunBear extends Pachyderm {
    SunBear(String _sex, AnimalNames names) throws FileNotFoundException   {
        super(_sex, names);
        super.SetSpecies("Sun Bear");
        super.SetName("S", names);
        super.SetNoise("roars aggressively");
    }

    @Override
    public String Sleep() {
        float prob = rand.nextFloat();

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
