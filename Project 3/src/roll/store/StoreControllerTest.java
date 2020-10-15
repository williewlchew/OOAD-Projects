package roll.store;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class StoreControllerTest {

    MessageBean storeBean = new MessageBean();
    Store store = new Store(storeBean);
    StoreController storeController = new StoreController(store);

    @Test
    public void CheckMadeRolls1() {
        Roll testRoll1 = storeController.SpringRollSlot();
        assertEquals("Spring Roll", testRoll1.getDescription());
        assertEquals(1.00, testRoll1.getCost());
    }

    @Test
    public void CheckMadeRolls2() {
        Roll testRoll2 = storeController.PastryRollSlot();
        testRoll2 = storeController.ExtraSauceSlot(testRoll2, "Sour sauce");
        assertEquals("Pastry Roll with Sour sauce, ",  testRoll2.getDescription());
        testRoll2 = storeController.ExtraToppingSlot(testRoll2, "Colorful toppings");
        assertEquals("Pastry Roll with Sour sauce, Colorful toppings, ", testRoll2.getDescription());
        assertEquals(4.00, testRoll2.getCost());
    }

    @Test
    public void CheckCustomer1() {
        Customer cust1 = new Customer(new BusinessFactory());
        assertEquals("Business", cust1.CustomerType);
    }

}