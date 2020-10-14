package roll.store;

public class ExtraSauceCommand implements ICommand{

    private Store store;
    private SpringRollFactory factory;
    private Roll result;

    public ExtraSauceCommand(Store store){
        this.store = store;
    }

    @Override
    public void make() {

    }

    @Override
    public void make(Roll roll, String sauce){
        store.getIngredients(5);
        Roll newSaucyRoll = new ExtraSauce(roll, sauce);
        result = newSaucyRoll;
    }

    public Roll getResult(){
        return result;
    }
}
