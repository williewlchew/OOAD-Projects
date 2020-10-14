package roll.store;

import java.util.List;

public interface CustomerFactory {
    int getRollMax();
    int getRollTypeMax();
    String getCustomerType();
    List<Integer> Rolls = null;

    static Roll IntToRoll(int r) {
        return switch (r) {
            case 0 -> StoreController.SpringRollSlot();
            case 1 -> StoreController.EggRollSlot();
            case 2 -> StoreController.SausageRollSlot();
            case 3 -> StoreController.PastryRollSlot();
            case 4 -> StoreController.JellyRollSlot();
        };
    }

}
