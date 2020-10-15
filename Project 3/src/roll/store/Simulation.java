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
        System.out.println("Before restock: " + store.getStock(0));
        store.restock();
        System.out.println("After restock: " + store.getStock(0));

        Roll testRoll2 = storeController.SpringRollSlot();
        System.out.println(testRoll2.getDescription());
        testRoll2 = storeController.ExtraSauceSlot(testRoll2, "Sour sauce");
        System.out.println(testRoll2.getDescription());
        testRoll2 = storeController.ExtraSauceSlot(testRoll2, "Sweet sauce");
        System.out.println(testRoll2.getDescription());
        testRoll2 = storeController.ExtraSauceSlot(testRoll2, "Soy sauce");
        System.out.println(testRoll2.getDescription());

        store.Close();
        System.out.println(storeObserver.retrieveNewData());

        return "exit testing...";
    }

}

