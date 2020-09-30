package com.company;
import java.beans.PropertyChangeListener;

public class ZooFoodServer extends ZooEmployee{

    // Variables
    private MessageBean bean;

    private MessageBean selfBean;
    private String selfState = "";
    public ZooFoodServer(AnimalNames names){
        this.name = names.GetRandomName("Z", "M");
        this.pay = 0;
    }
    /* A propertychangelistener is used to implement actions with respect
    to the zoo clock.
     */
    private final PropertyChangeListener ZooFoodServerListener = (e -> {
        if((int) e.getNewValue() == 8){
            selfBean.setMessage(Clean());
        }
        else if((int) e.getNewValue() == 10){
            selfBean.setMessage(MakeFood());
        }
        else if((int) e.getNewValue() == 12){
            selfBean.setMessage(ServeFood());
            this.selfState = "lunch";
            this.selfBean.setMessage(selfState);
        }
        else if((int) e.getNewValue() == 15){
            selfBean.setMessage(Clean());
        }
        else if((int) e.getNewValue() == 16){
            selfBean.setMessage(MakeFood());
        }
        else if((int) e.getNewValue() == 17){
            selfBean.setMessage(ServeFood());
            this.selfState = "dinner";
            this.selfBean.setMessage(selfState);
        }
        else if((int) e.getNewValue() == 19){
            selfBean.setMessage(Clean());
        }
    });

    // Basic methods
    public void Arrive(MessageBean inputbean, MessageBean outputbean) {
        this.bean = inputbean;
        this.selfBean = outputbean;
        selfBean.setMessage("Zoo Food Server " + name + " arrives at the Zoo.\n");
        this.ZooFoodServing(bean);
    }

    public void Leave(){
        bean.removePropertyChangeListener(ZooFoodServerListener);
        selfBean.setMessage("Zoo Food Server " + name + " leaves at the Zoo.\n");
        this.bean = null;
        this.selfBean = null;
    }

    public void ZooFoodServing(MessageBean bean) {
        bean.addPropertyChangeListener(ZooFoodServerListener);
    }

    public String Clean(){
        return("Zoo Food Server " + this.name + " is cleaning.\n");
    }
    public String MakeFood(){
        return("Zoo Food Server " + this.name + " is preparing Food.\n");
    }
    public String ServeFood(){
        return("Zoo Food Server " + this.name + " is serving Food.\n");
    }
}
