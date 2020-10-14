package roll.store;

public interface CustomerFactory {
    public int getRollMax();
    public int getRollTypeMax();
    public String getCustomerType();
    public Roll[] createRolls();
}
