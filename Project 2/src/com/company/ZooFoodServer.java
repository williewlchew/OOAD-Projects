package com.company;
import java.beans.PropertyChangeListener;

public class ZooFoodServer extends ZooEmployee{

    // Variables
    private StringBuilder buffer = new StringBuilder();
    private MessageBean bean;

    private MessageBean selfBean;
    private String selfState = "";
    public ZooFoodServer(AnimalNames names){
        this.name = names.GetRandomName("Z", "M");
        this.pay = 0;
    }

    private final PropertyChangeListener ZooFoodServerListener = (e -> {
        if((int) e.getNewValue() == 8){
            this.selfState = "arrived at the zoo";
            this.selfBean.setMessage(selfState);
            buffer.append(Clean());
        }
        else if((int) e.getNewValue() == 10){
            this.selfState = "cooking";
            this.selfBean.setMessage(selfState);
            buffer.append(MakeFood());
        }
        else if((int) e.getNewValue() == 12){
            this.selfState = "serving";
            this.selfBean.setMessage(selfState);
            buffer.append(ServeFood());
        }
        else if((int) e.getNewValue() == 15){
            this.selfState = "cleaning";
            this.selfBean.setMessage(selfState);
            buffer.append(Clean());
        }
        else if((int) e.getNewValue() == 16){
            this.selfState = "cooking";
            this.selfBean.setMessage(selfState);
            buffer.append(MakeFood());
        }
        else if((int) e.getNewValue() == 17){
            this.selfState = "serving";
            this.selfBean.setMessage(selfState);
            buffer.append(ServeFood());
        }
        else if((int) e.getNewValue() == 19){
            this.selfState = "cleaning";
            this.selfBean.setMessage(selfState);
            buffer.append(Clean());
        }
        else if((int) e.getNewValue() == 20){
            this.selfState = "left the zoo";
            this.selfBean.setMessage(selfState);
        }
    });

    // Basic methods
    public void Arrive(MessageBean inputbean, MessageBean outputbean) {
        this.bean = inputbean;
        this.selfBean = outputbean;
        this.buffer = new StringBuilder();
        buffer.append("Zoo Food Server " + this.name + " arrives at the Zoo.\n");
        this.ZooFoodServing(bean);

    }

    public String Leave(){
        bean.removePropertyChangeListener(ZooFoodServerListener);
        buffer.append("Zoo Food Server " + this.name + " leaves the Zoo.\n");
        this.bean = null;
        this.selfBean = null;
        return(buffer.toString());
    }

    public void ZooFoodServing(MessageBean bean) {
        bean.addPropertyChangeListener(ZooFoodServerListener);
    }

    public String Clean(){
//        this.bean = inputbean;
//        this.selfBean = outputbean;
//        this.buffer = new StringBuilder();
        buffer.append("Zoo Food Server" + this.name + "is cleaning.\n");
//        this.ZooFoodServing(bean);
        return(buffer.toString());
    }
    public String MakeFood(){
//        this.bean = inputbean;
//        this.selfBean = outputbean;
//        this.buffer = new StringBuilder();
        buffer.append("Zoo Food Server" + this.name + "is preparing Food.\n");
//        this.ZooFoodServing(bean);
        return(buffer.toString());
    }
    public String ServeFood(){
//        this.bean = inputbean;
//        this.selfBean = outputbean;
//        this.buffer = new StringBuilder();
        buffer.append("Zoo Food Server" + this.name + "is serving food.\n");
//        this.ZooFoodServing(bean);
        return(buffer.toString());
    }
}
