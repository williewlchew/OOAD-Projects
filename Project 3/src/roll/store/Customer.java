package roll.store;

import java.util.List;

public class Customer {
    //temporary for testing
    public List<Integer> rolls;
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
