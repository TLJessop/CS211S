package VidoeCodeAlong;

public class Pair<T> {

    private T thing1;
    private T thing2;

    public Pair(T thing1, T thing2){
        this.thing1 = thing1;
        this.thing2 = thing2;
    }

    public T getThing1() {
        return thing1;
    }

    public void setThing1(T thing1) {
        this.thing1 = thing1;
    }

    public T getThing2() {
        return thing2;
    }

    public void setThing2(T thing2) {
        this.thing2 = thing2;
    }
}//Pair
