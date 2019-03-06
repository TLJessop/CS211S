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

}//ArrayUtilities
