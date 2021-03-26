package bai10_stack_queue.baitap.queue_by_circularlinkedlist;

public class Run {
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);
        queue.deQueue();
        queue.display();
    }
}
