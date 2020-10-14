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
        commandSlots[6] = new ExtraToppingCommand(store);
        commandSlots[7] = new ExtraFillingCommand(store);
    }

    public Roll SpringRollSlot(){
        this.commandSlots[0].make();
        return commandSlots[0].getResult();
    }
    public Roll EggRollSlot() {
        this.commandSlots[1].make();
        return this.commandSlots[1].getResult();
    }
    public Roll SausageRollSlot() {
        this.commandSlots[2].make();
        return this.commandSlots[2].getResult();
    }
    public Roll PastryRollSlot() {
        this.commandSlots[3].make();
        return this.commandSlots[3].getResult();
    }
    public Roll JellyRollSlot() {
        this.commandSlots[4].make();
        return this.commandSlots[4].getResult();
    }
    public Roll ExtraSauceSlot(Roll roll, String sauce){
        this.commandSlots[5].make(roll, sauce);
        return this.commandSlots[5].getResult();
    }

    public Roll ExtraToppingSlot(Roll roll, String sauce){
        this.commandSlots[6].make(roll, sauce);
        return this.commandSlots[6].getResult();
    }

    public Roll ExtraFillingSlot(Roll roll, String sauce){
        this.commandSlots[7].make(roll, sauce);
        return this.commandSlots[7].getResult();
    }
}
