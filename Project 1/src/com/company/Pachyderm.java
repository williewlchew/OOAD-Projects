package com.company;

import java.io.FileNotFoundException;

public abstract class Pachyderm extends Animal {

    Pachyderm(String _sex, AnimalNames names) throws FileNotFoundException {
        super(_sex, names);

    }

    public String Charge() {
        String charge_str = super.GetName() + " the " + super.GetSpecies() + "has charged.";
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
            output_str = super.GetName() + " the " + super.GetSpecies() + "has roamed / exercised.";
        }
        return output_str;
    }
}



class Hippo extends Pachyderm {

    Hippo(String _sex, AnimalNames names) throws FileNotFoundException {
        super(_sex, names);
        this.SetSpecies("Hippo");
        this.SetName("H", names);

    }

    @Override
    protected void SetName(String FirstChar, AnimalNames names) throws FileNotFoundException {
        super.SetName(FirstChar, names);
    }

    @Override
    protected void SetSpecies(String _species) {
        super.SetSpecies(_species);
    }
}



class Elephant extends Pachyderm {
    Elephant(String _sex, AnimalNames names) throws FileNotFoundException   {
        super(_sex, names);
        this.SetSpecies("Elephant");
        this.SetName("H", names);
    }

    @Override
    protected void SetName(String FirstChar, AnimalNames names) throws FileNotFoundException {
        super.SetName(FirstChar, names);
    }

    @Override
    protected void SetSpecies(String _species) {
        super.SetSpecies(_species);
    }
}



class Rhino extends Pachyderm {
    Rhino(String _sex, AnimalNames names) throws FileNotFoundException   {
        super(_sex, names);
        this.SetSpecies("Rhino");
        this.SetName("R", names);
    }

    @Override
    protected void SetName(String FirstChar, AnimalNames names) throws FileNotFoundException {
        super.SetName(FirstChar, names);
    }

    @Override
    protected void SetSpecies(String _species) {
        super.SetSpecies(_species);
    }
}