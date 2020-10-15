package roll.store;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Simulation {

    // Simulation-related
    private int day;
    private int daysToSimulate;

    // Customer-Related
    Random CasualCustomerCount = new Random();
    Random BusinessCustomerCount = new Random();
    Random CateringCustomerCount = new Random();

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
//        Roll testRoll2 = storeController.SpringRollSlot();
//        System.out.println(testRoll2.getDescription());
//        testRoll2 = storeController.ExtraSauceSlot(testRoll2, "Sour sauce");
//        System.out.println(testRoll2.getDescription());
//        testRoll2 = storeController.ExtraSauceSlot(testRoll2, "Sweet sauce");
//        System.out.println(testRoll2.getDescription());
//        testRoll2 = storeController.ExtraSauceSlot(testRoll2, "Soy sauce");
//        System.out.println(testRoll2.getDescription());

        for (this.day = 0; day < this.daysToSimulate; day ++) {
            List<Customer> Customers = GenerateCustomers();
            for (Customer c : Customers){
                System.out.println((c.CustomerType));
                System.out.println((c.rolls));
            }

        }

//
//        int[] results = storeObserver.retrieveNewData();
//        for (int i : results){
//            System.out.println(("Data: " + i ));
//        }
        return "exit testing...";
    }


    public List<Customer> GenerateCustomers(){
        int CasualCount = CasualCustomerCount.nextInt(11) + 1;
        int BusinessCount = BusinessCustomerCount.nextInt(2) + 1;
        int CateringCount = CateringCustomerCount.nextInt(3) + 1;
        List<Customer> Customers = new ArrayList<>();

        for (int i = 0; i < CasualCount; i++){
            Customers.add(new Customer(new CausalFactory()));
        }
        for (int i = 0; i < BusinessCount; i++){
            Customers.add(new Customer(new BusinessFactory()));
        }
        for (int i = 0; i < CateringCount; i++){
            Customers.add(new Customer(new CateringFactory()));
        }
        Collections.shuffle(Customers);
        return Customers;
    }

}


