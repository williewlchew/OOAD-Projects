package roll.store;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CausalFactory implements CustomerFactory{

    private final Random RollTypeInt = new Random();
    private final Random RollCountInt = new Random();

    public List<Integer> createRolls() {

        // https://stackoverflow.com/questions/56199667/how-do-i-generate-a-list-with-specified-size-of-random-integers-within-a-range-i
        List<Integer> RollInts = IntStream.range(0, this.getRollMax()).mapToObj(i -> this.RollTypeInt.nextInt(getRollTypeMax()) + 1).collect(Collectors.toList());
        return RollInts;
    }

    public String getCustomerType() {
        return "casual";
    }

    public int getRollMax(){
        return 3;
    }
    public int getRollTypeMax() {
        return 3;
    }
}
