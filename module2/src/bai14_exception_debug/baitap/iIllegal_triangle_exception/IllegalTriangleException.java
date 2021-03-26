package bai14_exception_debug.baitap.iIllegal_triangle_exception;

public class IllegalTriangleException extends Exception{
    public IllegalTriangleException(){
        super("1 hoặc nhiều cạnh mang giá trị âm!");
    }

    public IllegalTriangleException(String e){
        super(e);
    }
}
