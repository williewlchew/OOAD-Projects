package roll.store;

public class SpringRollFactory implements RollFactory {
    public SpringRollFactory() {

    }

    public String getName() {
        return "Spring Roll";
    }

    public double getCost() {return 1.0; }
}
