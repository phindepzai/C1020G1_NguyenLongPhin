package manager;

import models.Customer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ManagerCinema4D {
    Queue<Customer> customerQueue = new LinkedList<>();
    private int numTicket;
    private List<Integer> list;

    public ManagerCinema4D(){
        list = new ArrayList<>();
        numTicket = 25;
    }

    public int getNumTicket() {
        return numTicket;
    }

    public void showAllBooking(){
        int count = 0;
        for (Customer customer:customerQueue) {
            System.out.println(customer.getName() + " bought " + list.get(count));
            count++;
        }
    }

    public void bookingTicket(Customer customer, int numBuy){
        customerQueue.add(customer);
        numTicket -= numBuy;
        list.add(numBuy);
    }
}
