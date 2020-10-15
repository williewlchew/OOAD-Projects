package roll.store;

public class BusinessCustomerStrategy  implements StrategyContext{

    public BusinessCustomerStrategy(){

    }

    @Override
    public int[] BuildOrder() {
        int[] ret = {0,0,1,1,2,2,3,3,4,4};
        return ret;
    }

    @Override
    public int Outage() {
        return 0;
    }
}
