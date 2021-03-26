package bai9_dsa_list.baitap.mylinkedlist;

public class MyLinkedList<E> {
    Node head;
    int numNodes;

    private class Node {
        Node next;
        E data;

        public Node(E data) {
            this.data = data;
        }

        public E getData() {
            return data;
        }
    }

    public MyLinkedList() {
    }

    public void addFirst(E data) {
        Node temp = head;
        head = new Node(data);
        head.next = temp;
        numNodes++;
    }

    public void add(int index, E data) {
        int count = 0;
        Node temp = head;
        Node nodeNew = new Node(data);
        while (temp != null) {
            if (index == 0) {
                addFirst(data);
                break;
            } else if (index == numNodes) {
                addLast(data);
                break;
            } else if (count == index - 1) {
                nodeNew.next = temp.next.next;
                temp.next = nodeNew;
                break;
            }
            count++;
            temp = temp.next;
            numNodes++;
        }
    }

    public void addLast(E data) {
        if (head == null){
            head = new Node(data);
        }else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node(data);
        }
        numNodes++;
    }

    public void remove(int index) {
        Node temp = head;
        if (index == 0) {
            head = temp.next;
        } else if (index > 0) {
            for (int i = 0; i < index - 1 && temp.next != null; i++) {
                temp = temp.next;
            }
            if (index == numNodes - 1) {
                temp.next = null;
            } else {
                temp.next = temp.next.next;
            }
        }
        numNodes--;
    }

    public void remove(E data) {
        int index = 0;
        Node temp = head;
        while (temp.next != null) {
            if (temp.getData().equals(data)) {
                remove(index);
                break;
            }
            index++;
            temp = temp.next;
        }
    }

    public MyLinkedList<E> clone(){
        MyLinkedList<E> returnList = new MyLinkedList<>();
        Node temp = head;
        while (temp.next != null){
            returnList.addLast(temp.getData());
            temp = temp.next;
        }
        return returnList;
    }

    public int size() {
        return numNodes;
    }

    public E get(int index) {
        Node temp = head;
        int count = 0;
        while (temp != null) {
            if (count == index) {
                return temp.getData();
            }
            count++;
            temp = temp.next;
        }
        return null;
    }

    public boolean constant(E data){
        Node temp = head;
        while (temp != null){
            if (temp.getData().equals(data)){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public void clear(){
        head = null;
    }

    public int indexOf(E data){
        Node temp = head;
        int count = 0;
        while (temp != null){
            if (temp.getData().equals(data)){
                return count;
            }
            count++;
            temp = temp.next;
        }
        return -1;
    }

    @Override
    public String toString() {
        Node temp = head;
        String result = "[";
        for (int i = 0; temp != null; i++) {
            result += temp.data;
            if (i != numNodes - 1){
                result += ",";
            }
            temp = temp.next;
        }
        result += "]";
        return result;
    }
}
