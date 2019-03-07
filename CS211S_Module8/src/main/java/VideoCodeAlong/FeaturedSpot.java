package VideoCodeAlong;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class FeaturedSpot<T extends Item> {

    private T item;
    private LocalDateTime start, end;
    private int count;

    public FeaturedSpot() {
        this.count =0;
        this.item = null;
    }

    public void featureItem(T item, int minFeatured){
        count++;

        this.item = item;
        this.start = LocalDateTime.now();
        this.end = this.start.plusMinutes(minFeatured);
    }

    public boolean isAnythingFeatured(){
        LocalDateTime now = LocalDateTime.now();

        if (now.isBefore(start) || now.isAfter(end)){
            return false;
        } else {
            return true;
        }
    }

    public T getItem(){
        return item;
    }

    @Override
    public String toString(){
        if(!isAnythingFeatured()){
            return "There is no featured item";
        } else {
            return "The current feature item is " + item.toString() +
                    "\nThis item will be featured until " + end.truncatedTo(ChronoUnit.MINUTES);
        }
    }
}//FeaturedSpot
