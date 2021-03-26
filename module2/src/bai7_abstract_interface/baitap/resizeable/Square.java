package bai7_abstract_interface.baitap.resizeable;

public class Square extends bai6_inheritance.thuchanh.shape.Square implements Resizeable {

    @Override
    public void resize(double percent) {
        setWitdh(getWitdh()+(percent*getWitdh()));
    }
}
