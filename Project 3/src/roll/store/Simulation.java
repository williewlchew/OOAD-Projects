package roll.store;


import org.testng.collections.Lists;

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

    // Extras
    List<String> Sauces = Lists.newArrayList("Sour Sauce", "Spicy Sauce", "Fire Sauce", "Jelly Sauce", "Mike's Hard Lemonade Sauce");
    List<String> Toppings = Lists.newArrayList("Fruit Topping", "Vegetables Topping", "Chocolate Topping", "Sprinkles Topping");
    Random Extras = new Random();

    public Simulation(int daysToSimulate){
        this.daysToSimulate = daysToSimulate;

        simBean = new MessageBean();
        storeBean = new MessageBean();

        store = new Store(storeBean);
        storeController = new StoreController(store);
        storeObserver = new StoreObserver(simBean, storeBean, daysToSimulate);
    }


    public String RunSimulation()
    {

        StrategyContext contextCasual = new StrategyContext(new OutageLogicCasual());
        StrategyContext contextBusiness = new StrategyContext(new OutageLogicBusiness());
        StrategyContext contextCatering = new StrategyContext(new OutageLogicCatering());
        for (this.day = 0; day < this.daysToSimulate; day++) {
            List<Customer> Customers = GenerateCustomers();
            List<Integer> rolls2 = new ArrayList<>();

            for (Customer c: Customers){
                if (c.CustomerType.equals("Casual")) {
                    rolls2 = contextCasual.ExecuteStrategy(c.rolls, store);
                }
                if (c.CustomerType.equals("Business")) {
                    rolls2 = contextBusiness.ExecuteStrategy(c.rolls, store);
                }
                if (c.CustomerType.equals("Catering")) {
                    rolls2 = contextCatering.ExecuteStrategy(c.rolls, store);
                }

                System.out.println(rolls2);
                for (int r: rolls2) {
                    Roll roll = TakeOrders(r);
                    Roll roll2 = AddExtras(roll);
                    c.Rolls.add(roll2);
                    System.out.println(roll2.name);
                }

            }

        }
        return "exit testing...";
    }

    private Roll TakeOrders(int type){
        Roll ret;
        switch (type) {
            case (0) -> ret = storeController.SpringRollSlot();
            case (1) -> ret = storeController.EggRollSlot();
            case (2) -> ret = storeController.SausageRollSlot();
            case (3) -> ret = storeController.PastryRollSlot();
            case (4) -> ret = storeController.JellyRollSlot();
            default -> ret = new Roll();
        }
        return ret;
    }

    private Roll AddExtras(Roll roll) {
        int ex = Extras.nextInt(4) + 5;
        Roll r2 = new Roll();
        if (ex == 5) {
            r2 = TakeExtraOrders(roll, 5, Sauces.get(Extras.nextInt(Sauces.size())));
        }
        if (ex == 6) {
            r2 = TakeExtraOrders(roll, 6, Sauces.get(Extras.nextInt(Toppings.size())));
        }
        if (ex == 7) {
            r2 = TakeExtraOrders(roll, 6, "Extra Filling");
        }
        if (ex == 8) {
            r2 = roll;
        }
        return r2;
    }

    private Roll TakeExtraOrders(Roll roll, int type, String extraName){
        Roll ret = roll;
        switch (type) {
            case (5) -> ret = storeController.ExtraSauceSlot(roll, extraName); // sauce
            case (6) -> ret = storeController.ExtraToppingSlot(roll, extraName); // topping
            case (7) -> ret = storeController.ExtraFillingSlot(roll, extraName); // filling
            case (8) -> ret = ret; // return the plain roll.
            default -> ret = ret;
        }
        return ret;
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


