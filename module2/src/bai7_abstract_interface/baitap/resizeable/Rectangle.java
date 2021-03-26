package bai7_abstract_interface.baitap.resizeable;

public class Rectangle extends bai6_inheritance.thuchanh.shape.Rectangle implements Resizeable{

    @Override
    public void resize(double percent) {
        setHeight(getHeight()+(getHeight()*percent));
        setWitdh(getWitdh()+(getWitdh()*percent));
    }
}
