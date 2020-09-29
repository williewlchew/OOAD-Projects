package com.company;

import java.beans.PropertyChangeListener;

public class ZooAnnouncer extends ZooEmployee{

    private MessageBean bean;

    private final PropertyChangeListener ZooAnnouncingListener = (e -> {
        System.out.println("Hi, this is Zoo Announcer, " + this.name + ". The Zookeeper is about to " + e.getNewValue() + " the animals!");
    });

    public ZooAnnouncer(AnimalNames names){
        this.name = names.GetRandomName("Z", "M");
        this.pay = 0;
    }

    public void Arrive(MessageBean bean){
        this.bean = bean;
        bean.addPropertyChangeListener(ZooAnnouncingListener);
    }

    public void Leave(){
        this.bean = bean;
        bean.removePropertyChangeListener(ZooAnnouncingListener);
    }
}
