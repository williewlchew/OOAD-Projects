package roll.store;

import java.util.Random;

public class CateringCustomerStrategy implements StrategyContext{

    Random rand;
    int int_random;

    public CateringCustomerStrategy(){
        rand = new Random();
        int_random = 0;
    }

    @Override
    public int[] BuildOrder() {
        int[] ret = new int[15];

        for (int i = 0; i < 15; i++){
            int_random = rand.nextInt(5);
            ret[i] = int_random;
        }
        return ret;
    }

    @Override
    public int Outage() {
        return 1;
    }
}
