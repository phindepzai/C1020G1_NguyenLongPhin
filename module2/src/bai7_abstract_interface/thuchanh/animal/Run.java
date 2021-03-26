package bai7_abstract_interface.thuchanh.animal;

public class Run {
    public static void main(String[] args) {
        Animal[] arr = new Animal[2];
        Fruit[] arr1 = new Fruit[2];
        arr[0] = new Chicken();
        arr[1] = new Tiger();
        arr1[0] = new Apple();
        arr1[1] = new Orange();
        for (int i = 0; i < 2; i++) {
            System.out.println(arr[i].makeSound()+"\t"+arr[i].howtoEat());
            System.out.println(arr1[i].howtoEat());
        }
    }
}
