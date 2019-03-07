package VideoCodeAlong;

import java.util.ArrayList;

public class ArrayUtilities {

    public static <T> ArrayList<T> findDupliicates(T[] things){
        ArrayList<T> returnList = new ArrayList<>();

        for (int i = 0; i < things.length; i++) {
            for (int j = i+1; j < things.length ; j++) {
                    if (things[j].equals(things[i]) && !returnList.contains(things[j]) ){
                        returnList.add(things[j]);
                    }
            }
        }
        return returnList;
    }

    public static <T extends Comparable<T>> Pair<T> findMinAndMax(T[] things){
        T min = things[0], max = things[0];

        for (int i = 0; i < things.length; i++) {
            if (things[i].compareTo(max) > 0){
                max = things[i];
            } else if (things[i].compareTo(min) < 0){
                min = things[i];
            }
        }

        return new Pair<>(min,max);
    }

}//ArrayUtilities
