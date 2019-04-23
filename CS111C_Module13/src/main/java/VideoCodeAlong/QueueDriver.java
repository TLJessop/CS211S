package VideoCodeAlong;

public class QueueDriver {

    public static void main(String[] args) {
        QueueInterface<Integer> numQueque = new ArrayQueue<>();

        System.out.println(numQueque);

        numQueque.enqueue(1);
        numQueque.enqueue(2);
        numQueque.enqueue(3);
        numQueque.enqueue(4);
        numQueque.enqueue(5);

        numQueque.enqueue(1);
        numQueque.enqueue(2);
        numQueque.enqueue(3);
        numQueque.enqueue(4);
        numQueque.enqueue(5);

        numQueque.enqueue(1);
        numQueque.enqueue(2);
        numQueque.enqueue(3);
        numQueque.enqueue(4);
        numQueque.enqueue(5);

        numQueque.enqueue(1);
        numQueque.enqueue(2);
        numQueque.enqueue(3);
        numQueque.enqueue(4);
        numQueque.enqueue(5);

        numQueque.enqueue(1);
        numQueque.enqueue(2);
        numQueque.enqueue(3);
        numQueque.enqueue(4);
        numQueque.enqueue(5);

        numQueque.enqueue(1);
        numQueque.enqueue(2);
        numQueque.enqueue(3);
        numQueque.enqueue(4);
        numQueque.enqueue(5);


        System.out.println(numQueque);

        System.out.println(numQueque.isEmpty());

        System.out.println(numQueque.dequeue());
        System.out.println(numQueque.dequeue());
        System.out.println(numQueque.dequeue());
        System.out.println(numQueque.dequeue());
        System.out.println(numQueque.dequeue());
        numQueque.clear();

        System.out.println(numQueque);

        System.out.println(numQueque.isEmpty());

    }

}//QueueDriver
