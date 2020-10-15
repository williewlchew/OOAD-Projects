package roll.store;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OutageLogicCasual implements OutageLogicStrategy {

    @Override
    public List<Integer> CheckRolls(List<Integer> Rolls, Store store) {
        List<Boolean> FLAGs = new ArrayList<Boolean>(5);
        List<Integer> NewRolls = new ArrayList<>();

        // Iterate over the rolls, check for ones that are out of stock.
        for (int roll: Rolls) {
            int roll_stock = store.getStock(roll);
            if (roll_stock == 0) {
                FLAGs.set(roll, false);
            }
            else {
                FLAGs.set(roll, true);
                NewRolls.add(roll);
            }
        }
        if ((NewRolls.size() < 15)) {

            for (int i = 0; i < FLAGs.size(); i ++) {
                if (FLAGs.get(i)) {
                    NewRolls.add(i);
                }
            }
        }
        return NewRolls;
    }
}
