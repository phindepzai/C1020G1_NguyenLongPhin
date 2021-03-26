package bai10_stack_queue.thuchanh.queue_by_linkedlist;

public class MyLinkedListQueue {
    private Node head;
    private Node tail;

    private class Node {
        private int key;
        private Node next;

        public Node(int key) {
            this.key = key;
            this.next = null;
        }

        public int getKey() {
            return key;
        }
    }

    public MyLinkedListQueue() {
    }

    public void enqueue(int key){
        Node temp = new Node(key);
        if (tail == null){
            head = tail = temp;
        }
        tail.next = temp;
        tail = temp;
    }

    public Node dequeue(){
        if (head == null){
            return null;
        }
        Node temp = head;
        head = head.next;
        if (head == null){
            tail = null;
        }
        return temp;
    }

    public int getFirstKey(){
        return head.getKey();
    }
}
