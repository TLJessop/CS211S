package VideoCodeAlong;

public class Pair<T> {

    //Instance data
    private T first;
    private T second;

    //Getters and Setters
    public Pair(T first, T second){
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }
    //End of Getters and Setters

    @Override
    public String toString(){
        return  "Pair holding " + first.toString() + " and " + second.toString();
    }

    @Override
    public boolean equals(Object obj){
        if (obj == null) return false;
        if (obj == this) return true;

        if (obj instanceof Pair<?>){
            Pair<?> otherPair = (Pair<?>) obj;

            if ((this.first.equals(otherPair.first) && this.second.equals(otherPair.second)) ||
                    (this.first.equals(otherPair.second) && this.second.equals(otherPair.first))){
                return true;
            } else {
                return false;
            }

        } else {
            return false;
        }
    }
}//Pair
