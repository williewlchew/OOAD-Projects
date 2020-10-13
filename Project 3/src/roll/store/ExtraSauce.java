package roll.store;

public class ExtraSauce extends Extras {


    public ExtraSauce(Roll roll, String sauceName) {
        this.name = roll.getType();
        this.cost = roll.getCost();
        this.extras = roll.getExtras();
        this.extras.add(sauceName);
    }
}
