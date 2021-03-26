package bai5_accessmodifier_static.thuchanh.static_property;

public class Run {
    public static void main(String[] args) {
        Car car = new Car("bmw","blue",50000,"12/12/2001");
        Car car1 = new Car("toyota","black",30000,"11/11/2001");
        System.out.println(car);
        System.out.println(car1);
        System.out.println(Car.amount);
    }
}
