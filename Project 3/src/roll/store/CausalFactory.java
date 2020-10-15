package roll.store;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CausalFactory implements CustomerFactory{

    CasualCustomerStrategy strat = new CasualCustomerStrategy();

    @Override
    public String getCustomerType() {
        return "casual";
    }

    @Override
    public StrategyContext getStrat() {
        return strat;
    }

    @Override
    public int getRollMax() {
        return 3;
    }
}
