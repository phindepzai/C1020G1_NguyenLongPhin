package bai7_abstract_interface.baitap.resizeable;

public class Circle extends bai6_inheritance.baitap.circle_cylinder.Circle implements Resizeable {

    @Override
    public void resize(double percent) {
        setRadius(getRadius()+(getRadius()*percent));
    }
}
