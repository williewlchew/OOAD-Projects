package roll.store;

import java.util.ArrayList;
import java.util.List;

public class BusinessFactory implements CustomerFactory{

    public Customer createBusiness() {

        Customer c =  new Customer("Business");


        return c;
    }

    private List<Roll> createRolls() {
        List<Roll> Rolls = new ArrayList<Roll>();


        return Rolls;
    }
}