package bai4_oop.baitap.stop_watch;

import java.util.Date;

public class StopWatch {
    private long startTime;
    private long endTime;
    public StopWatch() {
        startTime = System.currentTimeMillis();
    }
    
    public long getElapsedTime(){
        return endTime - startTime;
    }
    public void start(){
        startTime = System.currentTimeMillis();
    }

    public void end(){
        endTime = System.currentTimeMillis();
    }
    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }
}
