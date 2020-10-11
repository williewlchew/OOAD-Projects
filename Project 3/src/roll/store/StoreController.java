package roll.store;

public class StoreController {
    private Store store;
    private ICommand[] commandSlots = new ICommand[5];

    public StoreController(Store store){
        this.store = store;
        commandSlots[0] = new SpringRollCommand(store);
    }

    public void SpringRollSlot(Customer customer){
        commandSlots[0].make(customer);
    }

}
