package roll.store;

public class ExtraFilling extends Extras {

    double cost = 0.50;

    public ExtraFilling(Roll roll, String name) {
        this.name = roll.getType();
        this.cost = roll.getCost() + cost;
        this.extras = roll.getExtras();
        this.extras.add(name);
    }
}
