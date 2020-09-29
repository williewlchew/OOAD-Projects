package com.company;
import java.beans.PropertyChangeListener;

// An extension of ZooEmployee, a zookeeper performs the actions necessary to take care of the animals
// at the zoo.
public class Zookeeper extends ZooEmployee {

    // Variables
    private StringBuilder buffer = new StringBuilder();
    private Animal[] animals;
    private MessageBean bean;

    private MessageBean selfBean;
    private String selfState = ""; /// last thing added

    private final PropertyChangeListener ZooKeepingListener = (e -> {
        if((int) e.getNewValue() == 9){
            selfState = "wake";
            selfBean.setMessage(selfState);
            for(int i = 0; i < animals.length; i++){
                buffer.append(Wake(animals[i]));
            }
        }

        else if((int) e.getNewValue() == 10){
            selfState = "roll call";
            selfBean.setMessage(selfState);
            for(int i = 0; i < animals.length; i++){
                buffer.append(RollCall(animals[i]));
            }
        }

        else if((int) e.getNewValue() == 12){
            selfState = "feed";
            selfBean.setMessage(selfState);
            for(int i = 0; i < animals.length; i++){
                buffer.append(Feed(animals[i]));
            }
        }

        else if((int) e.getNewValue() == 15){
            selfState = "exercise";
            selfBean.setMessage(selfState);
            for(int i = 0; i < animals.length; i++){
                buffer.append(Exercise(animals[i]));
            }
        }

        else if((int) e.getNewValue() == 19){
            selfState = "tuck in";
            selfBean.setMessage(selfState);
            for(int i = 0; i < animals.length; i++){
                buffer.append(Sleep(animals[i]));
            }
        }
    });

    // ~
    public Zookeeper(AnimalNames names){
        this.name = names.GetRandomName("Z", "M");
        this.pay = 0;
    }

    // Basic Methods
    public void Arrive(Animal[] animals, MessageBean inputbean, MessageBean outputbean){
        this.animals = animals;
        this.bean = inputbean;
        this.selfBean = outputbean;
        this.buffer = new StringBuilder();
        buffer.append("Zookeeper " + name + " arrives at the Zoo.\n");
        this.ZooKeeping(bean);
    }

    public String Leave(){
        bean.removePropertyChangeListener(ZooKeepingListener);
        buffer.append("Zookeeper " + name + " leaves at the Zoo.\n");
        this.animals = null;
        this.bean = null;
        this.selfBean = null;
        return(buffer.toString());
    }

    // Zookeeping Methods

    public void ZooKeeping(MessageBean bean){
        bean.addPropertyChangeListener(ZooKeepingListener);
    }

    /*
     * All of these zookeeping methods are simple return statements that append  the zookeeper's
     * output with the animal's output, by calling each animal's action.
     */

    public String Wake(Animal animal){
        String buffer = "Zookeeper " + name + " wakes up " + animal.GetName() + " the " + animal.GetSpecies() + ".\n";
        return(buffer + animal.WakeUp());
    }

    public String RollCall(Animal animal){
        String buffer = "Zookeeper " + name + " roll calls " + animal.GetName() + " the " + animal.GetSpecies() + ".\n";
        return(buffer + animal.MakeNoise());
    }

    public String Feed(Animal animal){
        String buffer = "Zookeeper " + name + " feeds " + animal.GetName() + " the " + animal.GetSpecies() + ".\n";
        return(buffer + animal.Eat());
    }

    public String Exercise(Animal animal){
        String buffer = "Zookeeper " + name + " exercises " + animal.GetName() + " the " + animal.GetSpecies() + ".\n";
        return(buffer + animal.Roam());
    }

    public String Sleep(Animal animal){
        String buffer = "Zookeeper " + name + " tucks in " + animal.GetName() + " the " + animal.GetSpecies() + ".\n";
        return(buffer + animal.Sleep());
    }
}