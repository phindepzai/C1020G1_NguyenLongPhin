package bai4_oop.baitap.fan;

public class Fan {
    public static final int SLOW = 1;
    public static final int MEDIUM = 2;
    public static final int FAST = 3;
    private int speed;
    private boolean on;
    private int radius;
    private String color;

    public Fan() {
        this(SLOW , false, 5, "blue");
    }

    public Fan(int speed, boolean on, int radius, String color) {
        this.speed = speed;
        this.on = on;
        this.radius = radius;
        this.color = color;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        if (on){
            return "Fan is on," +
                    "speed=" + speed +
                    ", radius=" + radius +
                    ", color='" + color + '\'';
        }
        return "Fan is off" +
                ", radius=" + radius +
                ", color='" + color + '\'';
    }
}
