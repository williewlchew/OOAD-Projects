package com.company;

import java.io.FileNotFoundException;

public abstract class Feline extends Animal {

    Feline(String _sex, AnimalNames names) throws FileNotFoundException {
        super(_sex, names);
    }

    @Override
    public String Sleep() {

        float prob = rand.nextFloat();

        String sleep_str = "";

        if (prob < 0.30f) {
            sleep_str = super.Roam();
        }
        else if ((0.30f < prob) && (prob < 0.70f)) {
            sleep_str = super.MakeNoise();
        }
        else {
            sleep_str = super.Sleep();
        }
        return sleep_str;
    }
}


class Cat extends Feline {
    Cat(String _sex, AnimalNames names) throws FileNotFoundException {
        super(_sex, names);
        super.SetSpecies("Cat");
        super.SetName("C", names);
        super.SetNoise("meows");
    }
}


class Lion extends Feline {
    Lion(String _sex, AnimalNames names) throws FileNotFoundException {
        super(_sex, names);
        super.SetSpecies("Lion");
        super.SetName("L", names);
        super.SetNoise("roars");
    }
}

class Tiger extends Feline {
    Tiger(String _sex, AnimalNames names) throws FileNotFoundException {
        super(_sex, names);
        super.SetSpecies("Tiger");
        super.SetName("T", names);
        super.SetNoise("purrs");
    }
}