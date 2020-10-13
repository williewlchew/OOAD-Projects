package roll.store;

public class Customer {
    //temporary for testing
    Roll[] rolls;
    int currentRoll;

    public Customer(){
        rolls = new Roll[3];
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
