
public class Main {
    public static void main(String[] args)  {
        var pq = new PriorityQueue();
        pq.enqueue(1);
        pq.enqueue(2);
        pq.enqueue(5);
        pq.enqueue(10);
        pq.enqueue(3);
        pq.enqueue(4);
        System.out.println(pq.dequeue());
        System.out.println(pq.dequeue());
        System.out.println(pq.dequeue());
        System.out.println(pq.dequeue());
        System.out.println(pq.dequeue());
    }
}