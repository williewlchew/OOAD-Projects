package roll.store;

import java.util.ArrayList;

public class Roll {
    protected String name;
    protected double cost;
    protected ArrayList<String> extras;

    public Roll(){
        extras = new ArrayList<String>();
    }

    public Roll(RollFactory factory){
        extras = new ArrayList<String>();
        name = factory.getName();
        cost = factory.getCost();
    }

    public String getType() {return name;}

    public ArrayList<String> getExtras() {return extras;}

    public String getDescription(){
        String ret = getType();
        if(extras.size() >= 1){
            ret += " with ";
            for (String i : extras){
                ret += i + ", ";
            }
        }
        return ret;
    }

    public double getCost(){
        return cost;
    }
}

