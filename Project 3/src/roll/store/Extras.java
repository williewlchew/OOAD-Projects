package roll.store;

public abstract class Extras extends Roll {
    public Extras(RollFactory factory) {
        super(factory);
    }

    protected Extras() {
    }

    public abstract String getDescription(String sauceName);
}

