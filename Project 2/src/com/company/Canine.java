package com.company;

// The abstract class canine
public abstract class Canine extends Animal {


    Canine(String _sex, AnimalNames names) {
        super(_sex, names);
    }

    @Override
    /* The canines may make noises if they are told to eat. And then th
    * they will eat.*/
    public String Eat() {

        float prob = super.rand.nextFloat();
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
// The Wolf Class
class Wolf extends Canine {

    Wolf(String _sex, AnimalNames names) {
        super(_sex, names);
        super.SetSpecies("Wolf");
        super.SetName("W", names);
        super.SetNoise(new NoiseHowl());
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

// The Dog Class
class Dog extends Canine {

    Dog(String _sex, AnimalNames names) {
        super(_sex, names);
        super.SetSpecies("Dog");
        super.SetName("D", names);
        super.SetNoise(new NoiseBark());
    }


    // The dog can dig a hole.
    public String Dig() {
        String dig_str = super.GetName() + " the " + super.GetSpecies() + " has dug a hole.\n";
        return dig_str;
    }

    // The dog may dig a hole if it's told to roam / exercise.
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
