package bai11_map_tree.baitap.product;

import java.util.*;

public class ProductManager {

    private class SortIncrease implements Comparator<Product> {

        @Override
        public int compare(Product o1, Product o2) {
            return o1.getPrice() - o2.getPrice();
        }
    }
    private class SortDecrease implements Comparator<Product> {

        @Override
        public int compare(Product o1, Product o2) {
            return o2.getPrice() - o1.getPrice();
        }
    }

    private List<Product> productList;
    Scanner scanner = new Scanner(System.in);

    public List<Product> getProductList() {
        return productList;
    }

    public ProductManager() {
        productList = new ArrayList<>();
    }
    

    public void add(Product product) {
        productList.add(product);
    }

    public boolean check(String name,int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getName().equals(name) || productList.get(i).getId() == id){
                return false;
            }
        }
        return true;
    }

    public void search(String name) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getName().equals(name)){
                System.out.println(i+1+"."+productList.get(i));
            }
        }
    }

    private int search(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (id == productList.get(i).getId()) {
                return i;
            }
        }
        return -1;
    }

    public void set(int id) {
        int index = search(id);
        int choose;
        do {
            System.out.println("Nhập vào lựa chọn của bạn : ");
            System.out.println("1."+productList.get(index).getName());
            System.out.println("2."+productList.get(index).getId());
            System.out.println("3."+productList.get(index).getPrice());
            System.out.println("0.thoát khỏi trình sửa chửa.");
            choose = scanner.nextInt();
            scanner.nextLine();
            switch (choose) {
                case 1:
                    String name;
                    do {
                        System.out.println("Nhập vào tên bạn muốn sửa : ");
                        name = scanner.nextLine();
                    } while (!check(name, -1));
                    productList.get(index).setName(name);
                    break;
                case 2:
                    int idAfter;
                    do {
                        System.out.println("Nhập vào id bạn muốn sửa : ");
                        idAfter = scanner.nextInt();
                    } while (!check("",idAfter));
                    productList.get(index).setId(idAfter);
                    break;
                case 3:
                    System.out.println("Nhập vào giá bạn muốn sửa : ");
                    int price = scanner.nextInt();
                    productList.get(index).setPrice(price);
                    break;
                case 0:
                    System.out.println("Bạn đã thoát khỏi sửa chửa");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!\nVui lòng nhập lại");
            }
        } while (choose != 0);
    }

    public void delete(int id) {
        int index = search(id);
        if (index != -1){
            productList.remove(index);
        } else {
            System.out.println("ID không hợp lệ hoặc không có trong danh sách !");
        }
    }

    public void showMenu() {
        for (int i = 0; i < productList.size(); i++) {
            System.out.println(i + 1 + "." + productList.get(i));
        }
    }

    public void sortIncrease(){
        SortIncrease sortIncrease = new SortIncrease();
        Collections.sort(productList,sortIncrease);
    }

    public void sortDecrease(){
        SortDecrease sortDecrease = new SortDecrease();
        Collections.sort(productList,sortDecrease);
    }
}
