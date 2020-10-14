package roll.store;

public class EggRollFactory implements RollFactory {
    public EggRollFactory() {

    }

    public String getName() {
        return "Egg Roll";
    }

    public double getCost() {return 1.5; }
}
