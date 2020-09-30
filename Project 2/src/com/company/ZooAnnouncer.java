package com.company;

import java.beans.PropertyChangeListener;

public class ZooAnnouncer extends ZooEmployee{

    private MessageBean keeperBean;
    private MessageBean foodBean;
    private MessageBean selfBean;

    private String buffer = "";

    private final PropertyChangeListener ZooAnnouncingListener = (e -> {
        buffer = (String) e.getNewValue();

        if( buffer.length() < 10){
            if(buffer.equals("lunch")){
                buffer = "Hi, this is Zoo Announcer, " + this.name + ". Lunch is served!\n";
            }

            else if(buffer.equals("dinner")){
                buffer = "Hi, this is Zoo Announcer, " + this.name + ". Dinner is served!\n";
            }

            else{
                buffer = "Hi, this is Zoo Announcer, " + this.name + ". The Zookeeper is about to " + buffer + " the animals!\n";
            }
        }

        selfBean.setMessage(buffer);
    });

    public ZooAnnouncer(AnimalNames names, MessageBean bean){
        this.name = names.GetRandomName("Z", "M");
        this.pay = 0;
        selfBean = bean;
    }

    public void Arrive(MessageBean inputKeeperBean, MessageBean inputFoodBean){
        this.keeperBean = inputKeeperBean;
        this.foodBean = inputFoodBean;
        keeperBean.addPropertyChangeListener(ZooAnnouncingListener);
        foodBean.addPropertyChangeListener(ZooAnnouncingListener);
    }

    public void Leave(){
        keeperBean.removePropertyChangeListener(ZooAnnouncingListener);
        foodBean.removePropertyChangeListener(ZooAnnouncingListener);
        this.keeperBean = null;
        this.foodBean = null;
    }
}
