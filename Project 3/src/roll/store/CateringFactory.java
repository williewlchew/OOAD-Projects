package roll.store;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CateringFactory implements CustomerFactory{

    CateringCustomerStrategy strat = new CateringCustomerStrategy();

    @Override
    public String getCustomerType() {
        return "catering";
    }

    @Override
    public StrategyContext getStrat() {
        return strat;
    }

    @Override
    public int getRollMax() {
        return 15;
    }
}
