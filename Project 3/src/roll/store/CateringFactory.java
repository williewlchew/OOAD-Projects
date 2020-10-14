package roll.store;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public abstract class CateringFactory implements CustomerFactory{

    private final Random RollTypeInt = new Random(5);
    private final Random RollCountInt = new Random(3);

    public List<Integer> createRolls() {
        List<Integer> RollInts = IntStream.range(1, RollCountInt.nextInt(this.getRollMax()) + 1).mapToObj(i -> this.RollTypeInt.nextInt(getRollTypeMax()) + 1).collect(Collectors.toList());

//        List<Roll> Rolls = RollInts.forEach(CustomerFactory::IntToRoll).collect(Collectors.toList());
        return RollInts;
    }

    public String getCustomerType() {
        return "business";
    }
    public int getRollMax() {
        return 15;
    }
    public int getRollTypeMax() {
        return 5;
    }
}