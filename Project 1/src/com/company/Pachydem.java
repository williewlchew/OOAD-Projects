package com.company;

import java.io.FileNotFoundException;

public abstract class Pachydem extends Animal {

    Pachydem(String _sex, AnimalNames names) throws FileNotFoundException {
        super(_sex, names);

    }
}


class Hippo extends Pachydem {

    Hippo(String _sex, AnimalNames names) throws FileNotFoundException {
        super(_sex, names);
        this.SetName("H", names);
    }

    @Override
    public void SetName(String FirstChar, AnimalNames names) throws FileNotFoundException {
        super.SetName("H", names);
    }
}