package com.company;

public abstract class Canine extends Animal {


    Canine(String _sex, AnimalNames names) {
        super(_sex, names);
    }

    @Override
    public String Eat() {

        float prob = rand.nextFloat();
        String output_str = "";

        if (prob < 0.10f) {
            output_str = super.MakeNoise() + super.Eat();
        }
        else {
            output_str = super.Eat();
        }
        return output_str;
    }
}

class Wolf extends Canine {

    Wolf(String _sex, AnimalNames names) {
        super(_sex, names);
        super.SetSpecies("Wolf");
        super.SetName("W", names);
        super.SetNoise("bark-howls");
    }

    @Override
    public String Roam() {
        float prob = rand.nextFloat();
        String output_str = "";

        if (prob < 0.50f) {
            output_str = super.MakeNoise();
        }
        else {
            output_str = super.GetName() + " the " + super.GetSpecies() + " has roamed / exercised.\n";
        }
        return output_str;
    }
}

class Dog extends Canine {

    Dog(String _sex, AnimalNames names) {
        super(_sex, names);
        super.SetSpecies("Dog");
        super.SetName("D", names);
        super.SetNoise("barks");
    }

    public String Dig() {
        String dig_str = super.GetName() + " the " + super.GetSpecies() + " has dug a hole.\n";
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
            output_str = super.GetName() + " the " + super.GetSpecies() + " has roamed / exercised.\n";
        }
        return output_str;
    }
}
