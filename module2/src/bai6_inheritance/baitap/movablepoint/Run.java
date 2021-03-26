package bai6_inheritance.baitap.movablepoint;

public class Run {
    public static void main(String[] args) {
        MovablePoint movablePoint = new MovablePoint(1,1,1,1);
        System.out.println(movablePoint);
        movablePoint = movablePoint.move();
        System.out.println(movablePoint);
    }
}
