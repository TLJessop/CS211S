package VideoCodeAlong;

public class ArrayQueue<T> implements QueueInterface<T>{

    //Instance data
    private T[] queue;
    private int frontIndex, backIndex, numberOfEntries;

    //Class Constants
    private static final int MIN_SIZE = 10;
    private static final int DEFAULT_SIZE = 25;

    //Constructors
    public ArrayQueue(int newSize){
        int capacity;
        if (newSize >= MIN_SIZE){
            capacity = newSize + 1;
        } else {
            capacity = MIN_SIZE + 1;
        }
        queue = (T[]) new Object[capacity];
        frontIndex = 0;
        backIndex = queue.length -1;
        numberOfEntries= 0;
    }

    public ArrayQueue(){
        this(DEFAULT_SIZE);
    }

    //Core methods
    public void enqueue(T newEntry) {
        if(isArrayFull()){
            doubleArray();
        }

        backIndex = (backIndex + 1) % queue.length;
        queue[backIndex] = newEntry;
        numberOfEntries++;
    }

    public T dequeue() {
        T front = null;

        if(!isEmpty()){
            front = queue[frontIndex];
            queue[frontIndex] = null;
            frontIndex = (frontIndex + 1) % queue.length;
        }
        numberOfEntries--;
        return front;
    }

    public T getFront() {
        T front = null;

        if(!isEmpty()){
            front = queue[frontIndex];
        }

        return front;
    }

    public boolean isEmpty() {
        return frontIndex == (backIndex + 1) % queue.length;
    }

    public void clear() {
        for (int i = frontIndex; i != backIndex; i = (i + 1 ) % queue.length) {
            queue[i] = null;
        }
        queue[backIndex] = null;
        frontIndex = 0;
        backIndex = queue.length -1;
        numberOfEntries = 0;
    }

    public int getNumberOfEntries() {
        return numberOfEntries;
    }

    public String toString(){
        StringBuilder outString = new StringBuilder("ArrayQueue [");
        for (int i = frontIndex; i != backIndex && queue[i] != null; i = (i + 1) % queue.length ) {
            outString.append(queue[i]);
                outString.append(", ");

        }
        outString.append(queue[backIndex]);

        outString.append("]");

        return outString.toString();
    }

    //helper methods
    private boolean isArrayFull(){
        return frontIndex == (backIndex + 2) % queue.length;
    }

    private void doubleArray(){
        T[] temp = queue;
        int newSize = (queue.length * 2) + 1;

        queue = (T[]) new Object[newSize];

        for (int i = frontIndex; i < temp.length -1; i++){
            queue[i] = temp[frontIndex];
            frontIndex = (frontIndex + 1) % temp.length;


        }
        frontIndex = 0;
        backIndex = temp.length -2;
    }
}//ArrayQueue
