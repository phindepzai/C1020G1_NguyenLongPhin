package bai7_abstract_interface.thuchanh.animal;

public class Tiger extends Animal{

    @Override
    public String makeSound() {
        return "Tiger: roarrrrr!";
    }

    @Override
    public String howtoEat() {
        return "could be fried";
    }
}
