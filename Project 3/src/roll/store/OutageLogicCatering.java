package roll.store;

import java.util.ArrayList;
import java.util.List;

public class OutageLogicCatering implements OutageLogicStrategy {

    @Override
    public List<Integer> CheckRolls(List<Integer> Rolls, Store store) {
        boolean FLAG = false;
        List<Integer> NewRolls = new ArrayList<>();



        // Iterate over the rolls, check for ones that are out of stock.
        for (int roll: Rolls) {
            int roll_stock = store.getStock(roll);
            if (roll_stock == 0) {
                FLAG = true;

            }
            else {
                NewRolls.add(roll);
            }
        }

        if (FLAG) {
            // If some rolls are not available, then return the new list of rolls
            return NewRolls;

        }
        else {
            return Rolls;

        }
    }
}
