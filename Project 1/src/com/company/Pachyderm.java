package com.company;


// Pachyderm Class
/* All specific species are polymorphic, as they are both a member of their own family
* (i.e. Pachyderm, Canine, Fline, Ursidae) and they are all of the Animal Class.*/
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


// The Hippo class
class Hippo extends Pachyderm {
    /* All animals have an overloaded constructor wherein, their sex, name,
    * species, and the noise they make are set.
    * */
    Hippo(String _sex, AnimalNames names) {
        super(_sex, names);
        super.SetSpecies("Hippo");
        super.SetName("H", names);
        super.SetNoise("growns");

    }
}


// The Elephant Class
class Elephant extends Pachyderm {
    Elephant(String _sex, AnimalNames names)    {
        super(_sex, names);
        super.SetSpecies("Elephant");
        super.SetName("E", names);
        super.SetNoise("trumpets");
    }

}


// The Rhino Class
class Rhino extends Pachyderm {
    Rhino(String _sex, AnimalNames names)   {
        super(_sex, names);
        super.SetSpecies("Rhino");
        super.SetName("R", names);
        super.SetNoise("growls");
    }

}