package com.company;

import java.io.FileNotFoundException;

// The abstract class Feline
public abstract class Feline extends Animal {

    Feline(String _sex, AnimalNames names){
        super(_sex, names);
    }

    /* Felines may not sleep when ordered to.*/
    @Override
    public String Sleep() {

        float prob = rand.nextFloat();

        String sleep_str = "";

        if (prob < 0.30f) {
            sleep_str = super.Roam();
        }
        else if ((prob > 0.30f) && (prob < 0.70f)) {
            sleep_str = super.MakeNoise();
        }
        else {
            sleep_str = super.Sleep();
        }
        return sleep_str;
    }
}

// The class Cat
class Cat extends Feline {
    Cat(String _sex, AnimalNames names) throws FileNotFoundException {
        super(_sex, names);
        super.SetSpecies("Cat");
        super.SetName("C", names);
        super.SetNoise(new NoisePurr());
    }
}

// The class Lion
class Lion extends Feline {
    Lion(String _sex, AnimalNames names) throws FileNotFoundException {
        super(_sex, names);
        super.SetSpecies("Lion");
        super.SetName("L", names);
        super.SetNoise(new NoiseRoar());
    }
}

// The class Tiger
class Tiger extends Feline {
    Tiger(String _sex, AnimalNames names) throws FileNotFoundException {
        super(_sex, names);
        super.SetSpecies("Tiger");
        super.SetName("T", names);
        super.SetNoise(new NoisePurr());
    }
}