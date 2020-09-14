package com.company;

import java.io.FileNotFoundException;

public abstract class Feline extends Animal {
    Feline(String _sex, AnimalNames names) throws FileNotFoundException {
        super(_sex, names);
    }
}
