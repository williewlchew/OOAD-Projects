package com.company;

/*
* Talk about observer implementation...
*/
public class ZooClock {
    private int time = 0;
    MessageBean bean;

    public ZooClock(MessageBean inputBean){
        this.bean = inputBean;
        ResetTime();
    }

    public int GetTime(){
        return time;
    }

    public void ResetTime() {
        time = 8;
    }

    public void ProgressTime() {
        time += 1;
        this.bean.setMessage(time);
    }
}
