package roll.store;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class BusinessFactory implements CustomerFactory{


    private Random RollTypeInt = new Random();
    private Random RollCountInt = new Random();

    public List<Integer> createRolls() {
        List<Integer> RollInts = new ArrayList<>();
        int r1 = RollTypeInt.nextInt(5);
        int r2 = RollTypeInt.nextInt(5);
        while (r1 == r2){
            r2 = RollTypeInt.nextInt(5);
        }
        for (int i = 0; i < getRollMax() / getRollTypeMax(); i++) {
            RollInts.add(r1);
        }
        for(int i = 0; i < getRollMax() / getRollTypeMax(); i++) {
            RollInts.add(r2);
        }

        return RollInts;
    }

    public String getCustomerType() {
        return "business";
    }
    public int getRollMax() {
        return 10;
    }
    public int getRollTypeMax() {
        return 2;
    }
}