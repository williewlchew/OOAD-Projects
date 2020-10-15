package roll.store;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    //temporary for testing
    private Roll[] rolls;
    private int[] order;
    private StrategyContext strat;

    int RollMax;
    int currentRoll;
    String CustomerType;

    public Customer(CustomerFactory factory){
        this.CustomerType = factory.getCustomerType();
        this.RollMax = factory.getRollMax();

        // Strategy setting
        this.strat = factory.getStrat();
        this.order = strat.BuildOrder();

        currentRoll = 0;
    }

    public int[] GetOrder(){
        return order;
    }

    public int GetOutage(){
        return strat.Outage();
    }

    public Roll[] GetRolls(){
        return rolls;
    }

}
