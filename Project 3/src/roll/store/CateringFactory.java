package roll.store;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CateringFactory implements CustomerFactory{

    private final Random RollTypeInt = new Random(5);
    private final Random RollCountInt = new Random(3);

    public List<Integer> createRolls() {
        List<Integer> RollInts = new ArrayList<>();
        int r1 = RollTypeInt.nextInt(5);
        int r2 = RollTypeInt.nextInt(5);
        int r3 = RollTypeInt.nextInt(5);
        while (r1 == r2){
            r2 = RollTypeInt.nextInt(5);
        }
        while(r2 == r3 || r2 == r1){
            r3 = RollTypeInt.nextInt(5);
        }
        for (int i = 0; i < getRollMax() / getRollTypeMax(); i++) {
            RollInts.add(r1);
        }
        for(int i = 0; i < getRollMax() / getRollTypeMax(); i++) {
            RollInts.add(r2);
        }
        for(int i = 0; i < getRollMax() / getRollTypeMax(); i++) {
            RollInts.add(r3);
        }

        return RollInts;
    }

    public String getCustomerType() {
        return "Catering";
    }
    public int getRollMax() {
        return 15;
    }
    public int getRollTypeMax() {
        return 3;
    }
}
