package roll.store;

public class Main {

    public static void main(String[] args) {
	    // testing rolls
        MessageBean storeBean = new MessageBean();
        Store store = new Store(storeBean);
        SpringRollFactory testFactory = new SpringRollFactory();
        Roll testRoll = new Roll(testFactory);
        System.out.println(testRoll.getDescription());
    }
}
