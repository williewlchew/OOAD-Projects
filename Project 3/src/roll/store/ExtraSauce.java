package roll.store;

public class ExtraSauce extends Extras {

    double sauceCost = 0.50;

    public ExtraSauce(Roll roll, String sauceName) {
        this.name = roll.getType();
        this.cost = roll.getCost() + sauceCost;
        this.extras = roll.getExtras();
        this.extras.add(sauceName);
    }
}
