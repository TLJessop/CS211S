package VideoCodeAlong;

public class Box<T extends Comparable<T> > implements Comparable<Box<T>> {

    private T item;

    public Box(T item){
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    @Override
    public String toString(){
        return "Box holding " + item.toString();
    }

    @Override
    public boolean equals(Object obj){
        if (obj == null) return false;
        if (obj == this) return true;

        if (obj instanceof Box<?>){
            Box<?> otherBox = (Box<?>) obj;

            if (this.item.equals(otherBox.item)){
                return true;
            }else {
                return false;
            }

        } else {
            return false;
        }
    }

    @Override
    public int compareTo(Box<T> other) {
        return this.item.compareTo(other.item);
    }
}//Box
