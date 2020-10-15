package roll.store;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    //temporary for testing
    public List<Integer> rolls;
    public List<Roll> Rolls = new ArrayList<>();
    int RollMax;
    int RollTypeMax;
    int currentRoll;
    String CustomerType;

    public Customer(CustomerFactory factory){

        this.RollMax = factory.getRollMax();
        this.RollTypeMax = factory.getRollTypeMax();
        this.CustomerType = factory.getCustomerType();
        this.rolls = factory.createRolls();

        currentRoll = 0;
    }
}
