package roll.store;

public class PastryRollFactory implements RollFactory {
    public PastryRollFactory() {

    }

    public String getName() {
        return "Pastry Roll";
    }

    public double getCost() {return 3.0; }
}
