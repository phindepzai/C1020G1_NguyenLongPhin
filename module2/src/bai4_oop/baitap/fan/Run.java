package bai4_oop.baitap.fan;

public class Run {
    public static void main(String[] args) {
        Fan fan1 = new Fan(Fan.FAST,true,10,"yellow");
        Fan fan2 = new Fan(Fan.SLOW,false,5,"blue");
        System.out.println(fan1.toString());
        System.out.println(fan2.toString());
    }
}
