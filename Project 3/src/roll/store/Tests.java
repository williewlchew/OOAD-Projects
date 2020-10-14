package roll.store;
*/
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class UnitTests {

    public UnitTests(){
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
    }
}
*/