package roll.store;

public class ExtraFillingCommand implements ICommand{

    private Store store;
    private Roll result;

    public ExtraFillingCommand(Store store){
        this.store = store;
    }

    @Override
    public void make() {

    }

    @Override
    public void make(Roll roll, String sauce){
        store.getIngredients(5);
        Roll newRoll = new ExtraSauce(roll, sauce);
        result = newRoll;
    }

    public Roll getResult(){
        return result;
    }
}
