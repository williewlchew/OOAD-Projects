package roll.store;

public class SausageRollFactory implements RollFactory {
    public SausageRollFactory() {

    }

    public String getName() {
        return "Sausage Roll";
    }

    public double getCost() {return 2.5; }
}
