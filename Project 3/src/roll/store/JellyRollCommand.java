package roll.store;

public class JellyRollCommand implements ICommand{

    private Store store;
    private JellyRollFactory factory;
    private Roll result;

    public JellyRollCommand(Store store){
        this.store = store;
        this.factory = new JellyRollFactory();
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
