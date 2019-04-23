package VideoCodeAlong;

public class CirularLinkedQueue<T> implements  QueueInterface<T> {


    //Instance data
    private Node lastNode;
    private  int numberOfEntries;

    //Constructor
    public CirularLinkedQueue(){
        lastNode = null;
        numberOfEntries = 0;
    }

    public void enqueue(T newEntry) {
        Node newNode = new Node(newEntry, null);

        if (isEmpty()){
            lastNode = newNode;
            lastNode.next = lastNode;
        } else {
            newNode.next = lastNode.next;
            lastNode.next = newNode;

        }

        numberOfEntries++;
    }


    public T dequeue() {
        T returnValue = null;

        if (!isEmpty()){
            Node headNode = lastNode.next;
            returnValue = headNode.data;

            lastNode.next = headNode.next;

            if(lastNode == headNode){
                lastNode = null;
            }


        }
        numberOfEntries--;

        return returnValue;
    }


    public T getFront() {
        if (lastNode != null){
            return lastNode.next.data;
        } else {
            return null;
        }
    }


    public boolean isEmpty() {
        return lastNode == null;
    }


    public void clear() {
        lastNode = null;
        numberOfEntries = 0;
    }

    public int getNumberOfEntries() {
        return numberOfEntries;
    }


    public String toString() {
        StringBuilder outSring = new StringBuilder("CirclaralLinkedQueue [");
        Node currentNode;

        if (!isEmpty()){
            currentNode = lastNode.next;

            for (int i = 0; i < numberOfEntries; i++ ){
                outSring.append(currentNode.data);
                if(i + 1 != numberOfEntries){
                    outSring.append(", ");
                }
                currentNode = currentNode.next;
            }
        }


        outSring.append("]");
        return outSring.toString();
    }

    //Node private inner-class
    private class Node{

        //Instance data
        private T data;
        private Node next;

        //Constructor
        private Node(T entry, Node next){
            this.data = entry;
            this.next = next;
        }

        //Getters and Setters
        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

}//CirularLinkedQueue
