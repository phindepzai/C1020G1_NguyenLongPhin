package bai16_io_binaryfile.baitap;

import java.io.*;

public class ProductManager {

    public static final String DATA = "src\\bai16_io_binaryfile\\baitap\\abc.io";

    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        Product product = new Product("123","ngc","ald",12345,"abc");
        productManager.writeProduct(product);
        productManager.readData();
    }

    private void writeProduct(Product product){
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                    new FileOutputStream(DATA));
            objectOutputStream.writeObject(product);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readData(){
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(DATA));
            for (int i = 0; i < 2; i++) {
                System.out.println((Product) objectInputStream.readObject());
            }
        } catch (EOFException e){
            System.out.println();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
