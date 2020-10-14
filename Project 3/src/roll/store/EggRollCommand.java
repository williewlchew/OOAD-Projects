package roll.store;

public class EggRollCommand implements ICommand{

    private Store store;
    private EggRollFactory factory;
    private Roll result;

    public EggRollCommand(Store store){
        this.store = store;
        this.factory = new EggRollFactory();
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
