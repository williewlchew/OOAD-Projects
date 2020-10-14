package roll.store;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class OutageLogicCasual implements OutageLogicStrategy {

    @Override
    public List<Integer> CheckRolls(List<Integer> Rolls, Store store) {
        boolean[] FLAGs = new boolean[6];
        List<Integer> NewRolls = new ArrayList<>();

        Arrays.fill(FLAGs, Boolean.FALSE);

        // Iterate over the rolls, check for ones that are out of stock.
        for (int roll: Rolls) {
            int roll_stock = store.getStock(roll);
            if (roll_stock == 0) {
                FLAGs[roll] = false;
            }
            else {
                FLAGs[roll] = true;
                NewRolls.add(roll);
            }
        }
        if (size(NewRolls) < 15) {

            for (int i = 0; i < size(FLAGs); i ++) {
                if (FLAGs[i]) {
                    NewRolls.add(i);
                }
            }
        }

    }
}
