package roll.store;

public class StoreObserver {
    private MessageBean storeObservingBean;
    private StringBuilder observations;

    public StoreObserver(MessageBean bean){
        storeObservingBean = bean;
    }
}
