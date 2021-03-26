package bai6_inheritance.baitap.point;

public class Point3D extends Point2D{
    private float z;

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public Point3D() {
        this(1.0f,1.0f,1.0f);
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public void setXYZ(float x,float y,float z) {
        super.setXY(x,y);
        this.z = z;
    }

    public float[] getXYZ() {
        float[] arr = {getX(),getY(),getZ()};
        return arr;
    }

    @Override
    public String toString() {
        return "(" + getX() + "," + getY() + "," + getZ() + ")";
    }
}
