package bai11_map_tree.baitap.product;

import java.util.Scanner;

public class Run {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        int choose;
        do {
            System.out.println("            Menu           ");
            System.out.println("1.Thêm sản phẩm ");
            System.out.println("2.Sửa sản phẩm theo id ");
            System.out.println("3.Xóa sản phẩm theo id ");
            System.out.println("4.Hiển thị danh sách sản phẩm ");
            System.out.println("5.Tìm kiếm sản phẩm theo tên ");
            System.out.println("6.Sắp xếp sản phẩm ");
            System.out.println("0.Thoát chương trình ");
            System.out.println("-----------------------------");
            System.out.println("Nhập vào lựa chọn của bạn : ");
            choose = scanner.nextInt();
            scanner.nextLine();
            switch (choose) {
                case 1:
                    add(productManager);
                    break;
                case 2:
                    set(productManager);
                    break;
                case 3:
                    delete(productManager);
                    break;
                case 4:
                    productManager.showMenu();
                    System.out.println("Nhập vào 0 để out khỏi phần hiển thị.");
                    int out = scanner.nextInt();
                    if (out == 0){
                        break;
                    }
                case 5:
                    search(productManager);
                    break;
                case 6:
                    sort(productManager);
                    break;
                case 0:
                    System.out.println("Đã thoát chương trình!");
                    break;
                default:
                    System.err.println("Choose ERROR!");
            }
        } while (choose != 0);
    }

    private static void sort(ProductManager productManager) {
        System.out.println("Nhập vào thứ tự bạn muốn sắp xếp : ");
        System.out.println("1.Giá tăng dần");
        System.out.println("2.Giá giảm dần");
        int upOrDown = scanner.nextInt();
        switch (upOrDown) {
            case 1:
                productManager.sortIncrease();
                break;
            case 2:
                productManager.sortDecrease();
                break;
        }
    }

    private static void search(ProductManager productManager) {
        String name;
        System.out.println("Nhập tên sản phẩm bạn muốn tìm ");
        name = scanner.nextLine();
        productManager.search(name);
    }

    private static void delete(ProductManager productManager) {
        int id;
        System.out.println("Nhập vào id sản phẩm muốn xóa : ");
        id = scanner.nextInt();
        productManager.delete(id);
    }

    private static void set(ProductManager productManager) {
        int id;
        System.out.println("Nhập vào id sản phẩm muốn sửa : ");
        id = scanner.nextInt();
        productManager.set(id);
    }

    private static void add(ProductManager productManager) {
        String name;
        int id;
        int price;
        do {
            do {
                System.out.println("Nhập vào tên sản phẩm : ");
                name = scanner.nextLine();
            } while (!productManager.check(name, -1));
            do {
                System.out.println("Nhập vào id sản phẩm : ");
                id = scanner.nextInt();
            } while (!productManager.check("", id));
            System.out.println("Nhập vào giá tiền của sản phẩm : ");
            price = scanner.nextInt();
        } while (!productManager.check(name, id));
        productManager.add(new Product(name, id, price));
    }
}
