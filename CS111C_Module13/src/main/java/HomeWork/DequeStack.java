package HomeWork;

public class DequeStack<T> implements StackInterface<T> {

    //Instance data
    private DequeInterface<T> deque;
    private int numberOfEntries;

    //Constructor
    public DequeStack(){
        deque = new LinkedDeque<>();
        numberOfEntries = 0;
    }

    //Interface methods


    @Override
    public void push(T newEntry) {
        deque.addToFront(newEntry);
        numberOfEntries++;
    }

    @Override
    public T pop() {
        T item = null;

        if(!deque.isEmpty()){
           item = deque.removeFront();
           numberOfEntries--;
        }

        return item;
    }

    @Override
    public T peek() {
        return deque.getFront();
    }

    @Override
    public boolean isEmpty() {
        return deque.isEmpty();
    }

    @Override
    public void clear() {
        deque.clear();
    }

    //Getter
    //added both to aide in my testing and to round out the class as fully built
    public int getNumberOfEntries() {
        return numberOfEntries;
    }

}//DequeStack
