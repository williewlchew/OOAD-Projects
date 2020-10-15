package roll.store;

import java.util.List;

public interface CustomerFactory {
    String getCustomerType();
    StrategyContext getStrat();
    int getRollMax();
}
