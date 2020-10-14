package roll.store;

public class ExtraTopping extends Extras {

    double cost = 0.25;

    public ExtraTopping(Roll roll, String name) {
        this.name = roll.getType();
        this.cost = roll.getCost() + cost;
        this.extras = roll.getExtras();
        this.extras.add(name);
    }
}
