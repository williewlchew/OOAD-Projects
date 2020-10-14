package roll.store;

public class SausageRollCommand implements ICommand{

    private Store store;
    private SausageRollFactory factory;
    private Roll result;

    public SausageRollCommand(Store store){
        this.store = store;
        this.factory = new SausageRollFactory();
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
