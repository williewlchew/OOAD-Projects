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
    private double[] profit;

    private int currentDay = 0;
    private int maxDay = 0;


    private final PropertyChangeListener SimulationListener = (e -> {
        buffer = (String) e.getNewValue();
        if(buffer.equals("day")){
            calculateProfit();
            currentDay += 1;
        }
    });

    private final PropertyChangeListener StoreListener = (e -> {
        buffer = (String) e.getNewValue();

        if(buffer.charAt(1) == '-'){
            int c = Integer.parseInt(buffer.substring(2));
            switch (c) {
                case (0) -> springRollsSold[currentDay] += 1;
                case (1) -> eggRollsSold[currentDay] += 1;
                case (2) -> sausageRollsSold[currentDay] += 1;
                case (3) -> pastryRollsSold[currentDay] += 1;
                case (4) -> jellyRollsSold[currentDay] += 1;
                case (5) -> sauceSold[currentDay] += 1;
                case (6) -> toppingsSold[currentDay] += 1;
                case (7) -> fillingSold[currentDay] += 1;
            }
        }
        else if (buffer.charAt(1) == '+'){
            int c = Integer.parseInt(String.valueOf(buffer.charAt(2)));
            switch (c) {
                case (0) -> springRollsLeft[currentDay] = Integer.parseInt(buffer.substring(4));
                case (1) -> eggRollsLeft[currentDay] = Integer.parseInt(buffer.substring(4));
                case (2) -> sausageRollsLeft[currentDay] += Integer.parseInt(buffer.substring(4));
                case (3) -> pastryRollsLeft[currentDay] += Integer.parseInt(buffer.substring(4));
                case (4) -> jellyRollsLeft[currentDay] += Integer.parseInt(buffer.substring(4));
            }
        }
    });

    private void calculateProfit()
    {
        double profits  = 0;
        profits += springRollsSold[currentDay] * 1.0;
        profits += eggRollsSold[currentDay] * 1.5;
        profits += sausageRollsSold[currentDay] * 2.5;
        profits += pastryRollsSold[currentDay] * 3.0;
        profits += jellyRollsSold[currentDay] * 2.0;
        profits += sauceSold[currentDay] * 0.25;
        profits += toppingsSold[currentDay] * 0.50;
        profits += fillingSold[currentDay] * 0.75;
        profit[currentDay] = profits;
    }

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
        profit = new double[maxDay];
    }

    public String retrieveNewData(){

        calculateProfit();
        String ret = "";
        ret += "Spring rolls sold today: " + springRollsSold[currentDay] + "\n";
        ret += "Egg rolls sold today: " + eggRollsSold[currentDay] + "\n";
        ret += "Sausage rolls sold today: " + sausageRollsSold[currentDay] + "\n";
        ret += "Pastry rolls sold today: " + pastryRollsSold[currentDay] + "\n";
        ret += "Jelly rolls sold today: " + jellyRollsSold[currentDay] + "\n";
        ret += "Extra sauce sold today: " + sauceSold[currentDay] + "\n";
        ret += "Extra topping sold today: " + toppingsSold[currentDay] + "\n";
        ret += "Sausage filling sold today: " + fillingSold[currentDay] + "\n";
        ret += "The store made $" + profit[currentDay] + " today.\n";
        ret += "Spring rolls left today: " + springRollsLeft[currentDay] + "\n";
        ret += "Egg rolls left today: " + eggRollsLeft[currentDay] + "\n";
        ret += "Sausage rolls left today: " + sausageRollsLeft[currentDay] + "\n";
        ret += "Pastry rolls left today: " + pastryRollsLeft[currentDay] + "\n";
        ret += "Jelly rolls left today: " + jellyRollsLeft[currentDay] + "\n";

        return(ret);
    }
}