package roll.store;
import java.beans.PropertyChangeListener;

public class StoreObserver {
    private MessageBean storeBean;
    private MessageBean simulationBean;
    private String buffer;

    private int[] springRollsSold;
    private int[] springRollsLeft;
    private int[] pastryRollsSold;
    private int[] pastryRollsLeft;
    private int[] eggRollsSold;
    private int[] eggRollsLeft;
    private int[] jellyRollsSold;
    private int[] jellyRollsLeft;
    private int[] sausageRollsSold;
    private int[] sausageRollsLeft;

    private int currentDay = 0;
    private int maxDay = 0;


    public StoreObserver(MessageBean bean1, MessageBean bean2, int numberOfDays){
        simulationBean = bean1;
        simulationBean.addPropertyChangeListener(SimulationListener);
        storeBean = bean2;
        simulationBean.addPropertyChangeListener(StoreListener);

        maxDay = numberOfDays;

        springRollsSold = new int[maxDay];
        springRollsSold[0] = 0;
        springRollsLeft = new int[maxDay];
        pastryRollsSold = new int[maxDay];
        pastryRollsSold[0] = 0;
        pastryRollsLeft = new int[maxDay];
        eggRollsSold = new int[maxDay];
        eggRollsSold[0] = 0;
        eggRollsLeft = new int[maxDay];
        jellyRollsSold = new int[maxDay];
        jellyRollsSold[0] = 0;
        jellyRollsLeft = new int[maxDay];
        sausageRollsSold = new int[maxDay];
        sausageRollsSold[0] = 0;
        sausageRollsLeft = new int[maxDay];
    }

    private final PropertyChangeListener SimulationListener = (e -> {
        buffer = (String) e.getNewValue();
        if(buffer.equals("day")){
            currentDay += 1;
        }
    });

    private final PropertyChangeListener StoreListener = (e -> {
        buffer = (String) e.getNewValue();

        if(buffer.equals("spring")){
            springRollsSold[currentDay] += 1;
        }
    });

}
