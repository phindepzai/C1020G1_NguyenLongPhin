package bai4_oop.baitap.stop_watch;

public class Run {
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("Looping");
        }
        stopWatch.end();
        System.out.println(stopWatch.getElapsedTime());
    }
}
