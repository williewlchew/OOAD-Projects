package com.company;

import java.io.FileNotFoundException;

public abstract class Ursidae extends Animal{
    Ursidae(String _sex, AnimalNames names) throws FileNotFoundException {
        super(_sex, names);
    }
}
