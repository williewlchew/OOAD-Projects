package roll.store;

import java.util.List;

public interface CustomerFactory {
    int getRollMax();
    int getRollTypeMax();
    String getCustomerType();
    List<Integer> Rolls = null;

    List<Integer> createRolls();


    static Roll IntToRoll(int r, StoreController sc) throws Exception {
        return switch (r) {
            case 0 -> sc.SpringRollSlot();
            case 1 -> sc.EggRollSlot();
            case 2 -> sc.SausageRollSlot();
            case 3 -> sc.PastryRollSlot();
            case 4 -> sc.JellyRollSlot();
            default -> throw new Exception();
        };
    }

}
