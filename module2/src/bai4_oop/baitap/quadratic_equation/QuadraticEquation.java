package bai4_oop.baitap.quadratic_equation;

public class QuadraticEquation {
    private double a,b,c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getDiscriminant(){
        return (b * b) - (4 * a * c);
    }

    public double getRoot1(){
        if (getDiscriminant() > 0){
            return ((-b + Math.pow(getDiscriminant(),0.5))/(2 * a));
        }
        return -b/(2*a);
    }

    public double getRoot2(){
        if (getDiscriminant() > 0){
            return ((b + Math.pow(getDiscriminant(),0.5))/(2 * a));
        }
        return getRoot1();

    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }
}
