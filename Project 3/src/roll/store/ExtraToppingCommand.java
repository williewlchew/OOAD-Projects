package roll.store;

public class ExtraToppingCommand implements ICommand{

    private Store store;
    private Roll result;

    public ExtraToppingCommand(Store store){
        this.store = store;
    }

    @Override
    public void make() {

    }

    @Override
    public void make(Roll roll, String sauce){
        store.getIngredients(6);
        Roll newRoll = new ExtraSauce(roll, sauce);
        result = newRoll;
    }

    public Roll getResult(){
        return result;
    }
}
