package roll.store;

import java.util.ArrayList;
import java.util.List;

public class OutageLogicBusiness implements OutageLogicStrategy{

    @Override
    public List<Integer> CheckRolls(List<Integer> Rolls, Store store) {
        boolean FLAG = false;

        // Iterate over the rolls, check for ones that are out of stock.
        for (int roll: Rolls) {
            int roll_stock = store.getStock(roll);
            if (roll_stock == 0) {
                FLAG = true;
            }

        }

        if (FLAG) {
            // No more rolls left, return empty list of rolls
             List<Integer> NewRolls = new ArrayList<>();
             return NewRolls;

        }
        return Rolls;
    }
}
