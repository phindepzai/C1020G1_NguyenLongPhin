package bai10_stack_queue.baitap.queue_by_circularlinkedlist;

public class Queue {
    public Node front;
    public Node Rear;

    public class Node {
        private int data;
        private Node link;

        public Node(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }
    }

    public void enQueue(int data) {
        Node temp = new Node(data);
        if (front == null) {
            front = temp;
            Rear = front.link = front;
        } else {
            Rear.link = temp;
            Rear = Rear.link;
            Rear.link = front;
        }
    }

    public int deQueue() {
        Node temp = front;
        int data;
        if (front == null) {
            throw new IllegalArgumentException("null");
        } else if (front.link == front) {
            data = front.data;
            front = Rear = null;
        } else {
            while (temp.link != Rear) {
                temp = temp.link;
            }
            data = temp.link.data;
            Rear = temp;
            Rear.link = front;
        }
        return data;
    }

    public void display() {
        Node temp = Rear;
        do {
            System.out.println(temp.link.getData());
            temp = temp.link;
        } while (temp.link != front);
    }

    public Node getFront() {
        return front;
    }

    public Node getRear() {
        return Rear;
    }
}
