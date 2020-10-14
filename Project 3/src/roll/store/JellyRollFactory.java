package roll.store;

public class JellyRollFactory implements RollFactory {
    public JellyRollFactory() {

    }

    public String getName() {
        return "Jelly Roll";
    }

    public double getCost() {return 2.0; }
}
