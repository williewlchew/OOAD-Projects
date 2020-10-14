package roll.store;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CausalFactory implements CustomerFactory{
    private Random RollTypeInt = new Random(5);
    private Random RollCountInt = new Random(3);

    public List<Roll> createRolls() {

        // https://stackoverflow.com/questions/56199667/how-do-i-generate-a-list-with-specified-size-of-random-integers-within-a-range-i
        List<Integer> RollInts = IntStream.range(1, RollCountInt.nextInt(3) + 1).mapToObj(i -> RollTypeInt.nextInt(5) + 1).collect(Collectors.toList());

        List<Roll> Rolls = RollInts.forEach((r) -> Simulation::IntToRoll(r)).collect(Collectors.toList());

        return Rolls;
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