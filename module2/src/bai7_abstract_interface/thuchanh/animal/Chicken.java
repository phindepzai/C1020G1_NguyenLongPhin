package bai7_abstract_interface.thuchanh.animal;

public class Chicken extends Animal {

    @Override
    public String makeSound() {
        return "Chicken: cluck-cluck!";
    }

    @Override
    public String howtoEat() {
        return "could be fried";
    }
}
