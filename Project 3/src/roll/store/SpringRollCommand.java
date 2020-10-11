package roll.store;

public class SpringRollCommand implements ICommand{

    private Store store;
    private SpringRollFactory factory;

    public SpringRollCommand(Store store){
        this.store = store;
    }

    @Override
    public void make(Customer customer){
        store.getIngredients("spring");
        Roll newSpringRoll = new Roll(factory);

        // get and apply customer extras
        // append new roll to customer's bag
    }
}
