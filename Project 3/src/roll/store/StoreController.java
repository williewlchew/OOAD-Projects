package roll.store;

public class StoreController {
    private Store store;
    private ICommand[] commandSlots = new ICommand[8];

    public StoreController(Store store){
        this.store = store;
        commandSlots[0] = new SpringRollCommand(store);
        commandSlots[1] = new EggRollCommand(store);
        commandSlots[2] = new SausageRollCommand(store);
        commandSlots[3] = new PastryRollCommand(store);
        commandSlots[4] = new JellyRollCommand(store);
        commandSlots[5] = new ExtraSauceCommand(store);
    }

    public Roll SpringRollSlot(){
        commandSlots[0].make();
        return commandSlots[0].getResult();
    }

    public Roll ExtraSauceSlot(Roll roll, String sauce){
        commandSlots[5].make(roll, sauce);
        return commandSlots[5].getResult();
    }

}
