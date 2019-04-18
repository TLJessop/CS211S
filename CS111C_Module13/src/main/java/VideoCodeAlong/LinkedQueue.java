package VideoCodeAlong;

public class LinkedQueue<T> implements QueueInterface<T> {

    //Instance data
    private Node headNode;
    private Node tailNode;
    private int numberOfEnteries;

    //Constructor
    public LinkedQueue(){
        headNode = null;
        tailNode = null;
        numberOfEnteries = 0;
    }

    /**
     * Task: Adds a new entry to the back of the queue.
     *
     * @param newEntry an object to be added
     */
    @Override
    public void enqueue(T newEntry) {

    }

    /**
     * Task: Removes and returns the entry at the front of the queue.
     *
     * @return either the object at the front of the queue or, if the
     * queue is empty before the operation, null
     */
    @Override
    public T dequeue() {
        if (headNode != null){
             T returnValue = headNode.data;
             headNode = headNode.next;
             numberOfEnteries--;
             return returnValue;
        } else {
            throw new EmptyQueueException();
        }
    }

    /**
     * Task: Retrieves the entry at the front of the queue.
     *
     * @return either the object at the front of the queue or, if the
     * queue is empty, null
     */
    @Override
    public T getFront() {
        return null;
    }

    /**
     * Task: Detects whether the queue is empty.
     *
     * @return true if the queue is empty, or false otherwise
     */
    @Override
    public boolean isEmpty() {
        return false;
    }

    /**
     * Task: Removes all entries from the queue.
     */
    @Override
    public void clear() {

    }

    //Doubly linked node private inner-class
    private class Node{

        //Instance data
        private T data;
        private Node before, next;

        //Constructor
        private Node(T entry, Node before, Node next){
            this.data = entry;
            this.before = before;
            this.next = next;
        }

        //Getters and Setters
        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node getBefore() {
            return before;
        }

        public void setBefore(Node before) {
            this.before = before;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}//LinkedQueue
