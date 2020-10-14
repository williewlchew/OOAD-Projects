package roll.store;

import java.util.List;

public interface OutageLogicStrategy {

    public List<Integer> CheckRolls(List<Integer> Rolls, Store store);

}
