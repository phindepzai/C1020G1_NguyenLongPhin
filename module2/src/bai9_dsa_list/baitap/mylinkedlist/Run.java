package bai9_dsa_list.baitap.mylinkedlist;

public class Run {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        System.out.println(list);
    }
}
