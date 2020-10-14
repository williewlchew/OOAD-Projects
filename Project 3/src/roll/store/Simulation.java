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

        simBean = new MessageBean();
        storeBean = new MessageBean();

        store = new Store(storeBean);
        storeController = new StoreController(store);
        storeObserver = new StoreObserver(simBean, storeBean, daysToSimulate);
    }


    public String RunSimulation(){
        // preliminary testing implementation
        Roll testRoll2 = storeController.SpringRollSlot();
        System.out.println(testRoll2.getDescription());
        testRoll2 = storeController.ExtraSauceSlot(testRoll2, "Sour sauce");
        System.out.println(testRoll2.getDescription());
        testRoll2 = storeController.ExtraSauceSlot(testRoll2, "Sweet sauce");
        System.out.println(testRoll2.getDescription());
        testRoll2 = storeController.ExtraSauceSlot(testRoll2, "Soy sauce");
        System.out.println(testRoll2.getDescription());

        int[] results = storeObserver.retrieveNewData();
        for (int i : results){
            System.out.println(("Data: " + i ));
        }
        return "exit testing...";
    }

}

