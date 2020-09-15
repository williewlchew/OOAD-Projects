package com.company;

import java.io.FileNotFoundException;

public abstract class Ursidae extends Animal{
    Ursidae(String _sex, AnimalNames names) throws FileNotFoundException {
        super(_sex, names);
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

}
