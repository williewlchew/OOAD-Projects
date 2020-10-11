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
        // prilimenary testing implementation
        SpringRollFactory testFactory = new SpringRollFactory();
        Roll testRoll = new Roll(testFactory);
        return testRoll.getDescription();
    }
}

