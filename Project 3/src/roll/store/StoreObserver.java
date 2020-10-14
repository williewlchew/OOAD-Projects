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
    private int[] sauceSold;
    private int[] fillingSold;
    private int[] toppingsSold;

    private int currentDay = 0;
    private int maxDay = 0;


    private final PropertyChangeListener SimulationListener = (e -> {
        buffer = (String) e.getNewValue();
        if(buffer.equals("day")){
            currentDay += 1;
        }
    });

    private final PropertyChangeListener StoreListener = (e -> {
        buffer = (String) e.getNewValue();
        int c = Integer.parseInt(buffer.substring(2));
        //System.out.println(buffer);
        if(buffer.charAt(1) == '-'){
            switch(c)
            {
                case(0):
                    springRollsSold[currentDay] += 1;
                    break;
                case(1):
                    eggRollsSold[currentDay] += 1;
                    break;
                case(2):
                    sausageRollsSold[currentDay] += 1;
                    break;
                case(3):
                    pastryRollsSold[currentDay] += 1;
                    break;
                case(4):
                    jellyRollsSold[currentDay] += 1;
                    break;
                case(5):
                    sauceSold[currentDay] += 1;
                    break;
                case(6):
                    toppingsSold[currentDay] += 1;
                    break;
                case(7):
                    fillingSold[currentDay] += 1;
                    break;
            }
        }
        else if (buffer.charAt(0) == '#'){
            switch (c)
            {
                //restocking
            }
        }
    });

    public StoreObserver(MessageBean bean1, MessageBean bean2, int numberOfDays){
        simulationBean = bean1;
        simulationBean.addPropertyChangeListener(SimulationListener);
        storeBean = bean2;
        storeBean.addPropertyChangeListener(StoreListener);

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
        sauceSold = new int[maxDay];
        sauceSold[0] = 0;
        fillingSold = new int[maxDay];
        fillingSold[0] = 0;
        toppingsSold = new int[maxDay];
        toppingsSold[0] = 0;
    }

    public int[] retrieveNewData(){
        int[] ret = {springRollsSold[currentDay],
                eggRollsSold[currentDay],
                sausageRollsSold[currentDay],
                pastryRollsSold[currentDay],
                jellyRollsSold[currentDay],
                sauceSold[currentDay]};
        return(ret);
    }
}