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

    // Output related
    private StringBuilder buffer;

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

        buffer = new StringBuilder();
    }


    public String RunSimulation()
    {
        for (this.day = 0; day < this.daysToSimulate; day++) {
            // Customer logic
            List<Customer> customers = GenerateCustomers();

            for (int i = 0 ; i < customers.size(); i++){
                Customer c = customers.get(i);

                String s = "";
                for (int element: c.GetOrder()) {
                    s += element;
                }
                System.out.println(s);
            }

            // End of day outputting
            buffer.append("---Day " + day + "---\n");
            buffer.append(storeObserver.retrieveNewData());
            buffer.append("--- End of Day " + day + "---\n\n");

        }
        buffer.append("---Totals---\n");
        buffer.append(storeObserver.retrieveSumData());
        return buffer.toString();
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

        CausalFactory casualFactory = new CausalFactory();
        BusinessFactory businessFactory = new BusinessFactory();
        CateringFactory cateringFactory = new CateringFactory();

        List<Customer> Customers = new ArrayList<>();

        for (int i = 0; i < CasualCount; i++){
            Customers.add(new Customer(casualFactory));
        }
        for (int i = 0; i < BusinessCount; i++){
            Customers.add(new Customer(businessFactory));
        }
        for (int i = 0; i < CateringCount; i++){
            Customers.add(new Customer(cateringFactory));
        }
        Collections.shuffle(Customers);
        return Customers;
    }
}


