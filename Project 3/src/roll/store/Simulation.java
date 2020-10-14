package roll.store;



public class Simulation {

    // Simulation-related
    private int day;
    private int daysToSimulate;

    // Observer beans
    private MessageBean storeBean;
    private MessageBean simBean;

    // Store-related
    private Store store;
    private StoreController storeController;
    private StoreObserver storeObserver;


    public Simulation(int daysToSimulate){
        this.daysToSimulate = daysToSimulate;

        storeBean = new MessageBean();
        simBean = new MessageBean();

        store = new Store(storeBean);
        storeController = new StoreController(store);
        storeObserver = new StoreObserver(simBean, storeBean, daysToSimulate);
    }


    public String RunSimulation(){
        // preliminary testing implementation

        SpringRollFactory testFactory = new SpringRollFactory();
        Roll testRoll = new Roll(testFactory);
        System.out.println(testRoll.getDescription());

        Roll testRoll2 = storeController.SpringRollSlot();
        System.out.println(testRoll2.getDescription());
        testRoll2 = storeController.ExtraSauceSlot(testRoll2, "Sour sauce");
        System.out.println(testRoll2.getDescription());
        testRoll2 = storeController.ExtraSauceSlot(testRoll2, "Sweet sauce");
        System.out.println(testRoll2.getDescription());

        return "exit testing...";
    }


    public static Roll IntToRoll(int r) {
        return switch (r) {
            case 1 -> StoreController.SpringRollSlot();
            case 2 -> StoreController.EggRollSlot();
            case 3 -> StoreController.SausageRollSlot();
            case 4 -> StoreController.PastryRollSlot();
            case 5 -> StoreController.JellyRollSlot();
        };
    }
}

