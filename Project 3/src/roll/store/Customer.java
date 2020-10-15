package roll.store;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    //temporary for testing
    private Roll[] rolls;
    private int[] order;
    private StrategyContext strat;
    private int RollMax;

    String CustomerType;

    public Customer(CustomerFactory factory){
        this.CustomerType = factory.getCustomerType();
        this.RollMax = factory.getRollMax();

        // Strategy setting
        this.strat = factory.getStrat();
        this.order = strat.BuildOrder();
    }

    public String GetType(){
        return CustomerType;
    }

    public int[] GetOrder(){
        return order;
    }

    public int GetMax(){
        return RollMax;
    }

    public int GetOutage(){
        return strat.Outage();
    }

    public void RecieveRolls(Roll[] rolls){
        this.rolls = rolls;
    }

    public Roll[] GetRolls(){
        return rolls;
    }

}
