package roll.store;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class BusinessFactory implements CustomerFactory{

    BusinessCustomerStrategy strat = new BusinessCustomerStrategy();

    @Override
    public String getCustomerType() {
        return "business";
    }

    @Override
    public StrategyContext getStrat() {
        return strat;
    }

    @Override
    public int getRollMax() {
        return 10;
    }
}