package com.company;

import java.io.FileNotFoundException;

public abstract class Pachyderm extends Animal {

    Pachyderm(String _sex, AnimalNames names) throws FileNotFoundException {
        super(_sex, names);

    }

    public String Charge() {
        return null;
    }

    @Override
    public String Exercise() {
        return super.Exercise();
    }

    @Override
    public String Roam() {
        return super.Roam();
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