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
    private char dummy;

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
        dummy = '0';

        store = new Store(storeBean);
        storeController = new StoreController(store);
        storeObserver = new StoreObserver(simBean, storeBean, daysToSimulate);

        buffer = new StringBuilder();
    }

    // run simulation
    public String RunSimulation()
    {
        for (this.day = 0; day < this.daysToSimulate; day++) {

            System.out.println("---Day " + day + "---\n");
            
            // Start of day logic
            store.restock();

            // Customer logic
            List<Customer> customers = GenerateCustomers();
            boolean storeClose = false;

            for (int i = 0 ; i < customers.size(); i++){
                Customer c = customers.get(i);
                c.RecieveRolls(ServeCustomer(c.GetOrder(), c.GetOutage()));

                String s = "Customer " + c.GetType() + " ordered [ ";
                for (Roll r : c.GetRolls()) {
                    s += r.getDescription() + " ";
                }
                s += "]\n";
                System.out.println(s);

                storeClose = store.CheckClose();
                if(storeClose) {
                    break;
                }
            }

            if(storeClose == false){
                store.Close();
            }

            // End of day outputting
            buffer.append("---Day " + day + "---\n");
            buffer.append(storeObserver.retrieveNewData());
            buffer.append("--- End of Day " + day + "---\n\n");
            System.out.println("---End of Day " + day + "---\n");

            // End of day logic
            if(dummy == '0') dummy = '1';
            else if(dummy == '1') dummy = '0';
            simBean.setMessage(dummy + "day");

        }
        buffer.append("---Totals---\n");
        buffer.append(storeObserver.retrieveSumData());
        return buffer.toString();
    }

    // RunSimulation helpers
    private Roll[] ServeCustomer(int[] order, int outage){
        Roll[] ret = new Roll[order.length];
        boolean servable = true;
        int[] orderTracker = {0,0,0,0,0};

        for (int i = 0; i < order.length; i++)
        {
            if (store.getStock(order[i]) - orderTracker[order[i]] <= 0)
            {
                if(outage == 1) {
                    order[i] = WhatsLeft(orderTracker);
                    if(order[i] == -1){
                        servable = false;
                        break;
                    }
                }
                else {
                    servable = false;
                    break;
                }
            }
            orderTracker[order[i]] += 1;
        }

        if(servable)
        {
            for (int i = 0; i < order.length; i++)
            {
                ret[i] = TakeOrders(order[i]);
                ret[i] = AddExtras(ret[i]);
            }
        }
        else {
            ret = new Roll[0];
        }
        return ret;
    }

    private int WhatsLeft(int[] tracker){
        int ret = -1;
        for(int i = 0; i < 5; i++){
            if(store.getStock(i) - tracker[i] > 0){
                ret = i;
                break;
            }
        }
        return ret;
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


