package VideoCodeAlong;

//for example not real used
public class RawPair {

    private Object firstThing;
    private Object secondThing;

    public RawPair(Object firstThing, Object secondThing){
        this.firstThing =firstThing;
        this.secondThing = secondThing;
    }

    // Getters and Setters

    public Object getFirstThing() {
        return firstThing;
    }

    public void setFirstThing(Object firstThing) {
        this.firstThing = firstThing;
    }

    public Object getSecondThing() {
        return secondThing;
    }

    public void setSecondThing(Object secondThing) {
        this.secondThing = secondThing;
    }

    // End of Getters and Setters

    @Override
    public String toString(){
        return "RawPair holding " + firstThing.toString() + " and " + secondThing.toString();
    }
}//RawPair
