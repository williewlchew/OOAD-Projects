package roll.store;

import java.util.Random;

public class CasualCustomerStrategy implements StrategyContext{

    Random rand;
    int int_random;

    public CasualCustomerStrategy(){
        rand = new Random();
        int_random = 0;
    }

    @Override
    public int[] BuildOrder() {
        int[] ret = new int[3];

        for (int i = 0; i < 3; i++){
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
