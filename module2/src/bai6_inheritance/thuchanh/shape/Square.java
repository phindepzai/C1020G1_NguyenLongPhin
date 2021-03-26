package bai6_inheritance.thuchanh.shape;

public class Square extends Rectangle{
    @Override
    public void setWitdh(double witdh) {
        super.setWitdh(witdh);
        super.setHeight(witdh);
    }

    @Override
    public void setHeight(double height) {
        super.setHeight(height);
        super.setWitdh(height);
    }

    @Override
    public String toString() {
        return "A Square with side="
                + getHeight()
                + ", which is a subclass of "
                + super.toString();
    }
}
