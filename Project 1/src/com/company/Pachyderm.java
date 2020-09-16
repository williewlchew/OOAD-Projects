package com.company;

import java.io.FileNotFoundException;

public abstract class Pachyderm extends Animal {

    Pachyderm(String _sex, AnimalNames names) {
        super(_sex, names);

    }

    public String Charge() {
        String charge_str = super.GetName() + " the " + super.GetSpecies() + " has charged.\n";
        return charge_str;
    }

    @Override
    public String Roam() {

        float prob = rand.nextFloat();
        String output_str = "";

        if (prob < 0.25f) {
            output_str = this.Charge();
        }
        else {
            output_str = super.GetName() + " the " + super.GetSpecies() + " has roamed / exercised.\n";
        }
        return output_str;
    }
}



class Hippo extends Pachyderm {

    Hippo(String _sex, AnimalNames names) {
        super(_sex, names);
        super.SetSpecies("Hippo");
        super.SetName("H", names);
        super.SetNoise("growns");

    }
}



class Elephant extends Pachyderm {
    Elephant(String _sex, AnimalNames names)    {
        super(_sex, names);
        super.SetSpecies("Elephant");
        super.SetName("E", names);
        super.SetNoise("trumpets");
    }

}



class Rhino extends Pachyderm {
    Rhino(String _sex, AnimalNames names)   {
        super(_sex, names);
        super.SetSpecies("Rhino");
        super.SetName("R", names);
        super.SetNoise("growls");
    }

}