package roll.store;

public class PastryRollCommand implements ICommand{

    private Store store;
    private PastryRollFactory factory;
    private Roll result;

    public PastryRollCommand(Store store){
        this.store = store;
        this.factory = new PastryRollFactory();
    }

    @Override
    public void make(){
        store.getIngredients(0);
        Roll newRoll = new Roll(factory);
        result = newRoll;
    }

    @Override
    public void make(Roll roll, String sauce) {

    }

    public Roll getResult()
    {
        return result;
    }
}
