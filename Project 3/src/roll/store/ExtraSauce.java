package roll.store;

public class ExtraSauce extends Extras {
    Roll roll;

    public ExtraSauce(Roll roll, String sauceName) {
        this.roll = roll;
    }

    @Override
    public String getDescription(String sauceName) {
        return sauceName + " sauce";
    }
}
