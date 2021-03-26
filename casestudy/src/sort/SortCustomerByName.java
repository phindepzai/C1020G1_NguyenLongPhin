package sort;

import models.Customer;

import java.util.Comparator;
import java.util.Date;

public class SortCustomerByName implements Comparator<Customer> {
    @Override
    public int compare(Customer o1, Customer o2) {
        int i = o1.getName().compareTo(o2.getName());
        if (i == 0){
            return sortBirth(o1.getBirthDay(),o2.getBirthDay());
        }
        return i;
    }

    private int sortBirth(String birth1,String birth2){
        String[] birthArr = birth1.split("/");
        String[] birth2Arr = birth2.split("/");
        Date date1 = new Date(Integer.parseInt(birthArr[2]),Integer.parseInt(birthArr[1]),Integer.parseInt(birthArr[0]));
        Date date2 = new Date(Integer.parseInt(birth2Arr[2]),Integer.parseInt(birth2Arr[1]),Integer.parseInt(birth2Arr[0]));
        return (int) (date2.getTime() - date1.getTime());
    }
}
