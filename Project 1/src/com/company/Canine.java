package com.company;

import java.io.FileNotFoundException;

public abstract class Canine extends Animal{


    Canine(String _sex, AnimalNames names) throws FileNotFoundException {
        super(_sex, names);
    }
}
