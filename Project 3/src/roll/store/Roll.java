package roll.store;

public class Roll {
    private String name;
    private double cost;
    private  String[] extras;

    public Roll(){
    }

    public Roll(RollFactory factory){
        name = factory.getName();
        cost = factory.getCost();
    }

    public  String getType() {return name;}

//    public String getExtras() {return extras;}

    public String getDescription(){
        String ret = getType();
        if(extras.length > 0){
            ret += " with ";
            // loop through extras
        }
        return ret;
    }

    public double getCost(){
        return cost;
    }
}

