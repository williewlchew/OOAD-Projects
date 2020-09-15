package com.company;

import java.io.FileNotFoundException;

public abstract class Canine extends Animal {


    Canine(String _sex, AnimalNames names) throws FileNotFoundException {
        super(_sex, names);
    }
}

class Wolf extends Canine {

    Wolf(String _sex, AnimalNames names) throws FileNotFoundException {
        super(_sex, names);
        super.SetSpecies("Wolf");
        super.SetName("W", names);
    }
}

class Dog extends Canine {

    Dog(String _sex, AnimalNames names) throws FileNotFoundException {
        super(_sex, names);
        super.SetSpecies("Dog");
        super.SetName("D", names);
    }

    public String Dig() {
        String dig_str = super.GetName() + " the " + super.GetSpecies() + " has dug a hole.";
        return dig_str;
    }

    @Override
    public String Roam() {

        float prob = rand.nextFloat();
        String output_str = "";

        if (prob < 0.25f) {
            output_str = this.Dig();
        }
        else {
            output_str = super.GetName() + " the " + super.GetSpecies() + " has roamed / exercised.";
        }
        return output_str;
    }
}
