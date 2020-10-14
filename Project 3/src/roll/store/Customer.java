package roll.store;

public class Customer {
    //temporary for testing
    Roll[] rolls;
    int RollMax;
    int RollTypeMax;
    int currentRoll;
    String CustomerType;

    public Customer(CustomerFactory factory){

        this.RollMax = factory.getRollMax();
        rolls = new Roll[factory.getRollMax()];
        this.RollTypeMax = factory.getRollTypeMax();
        this.CustomerType = factory.getCustomerType();
        this.rolls = factory.createRolls();

        currentRoll = 0;
    }

    public void RecieveRoll(Roll roll){
        rolls[currentRoll] = roll;
        currentRoll += 1;
    }

    public Roll[] GetRolls(){
        return rolls;
    }
}
