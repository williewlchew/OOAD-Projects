package roll.store;

public interface RollFactory {
    public Roll createRoll();
}

public class SpringRollFactory implements  RollFactory{
    public SpringRollFactory(){

    }

    public Roll createRoll(){
        return null;
    }
}
