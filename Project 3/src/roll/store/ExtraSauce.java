package roll.store;

public class ExtraSauce extends Extras {
    Roll roll;

    public ExtraSauce(Roll roll) {
        this.roll = roll;
    }

    @Override
    public String getDescription() {
        return "";
    }
}
