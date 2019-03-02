package VideoCodeAlong;

import java.util.*;

public class IteratorSmallExmaple {

    public static void main(String[] args) {

        List<String> strings = new ArrayList<String>();
        strings.add("HI");
        strings.add("bye");
        strings.add("things");
        strings.add("word");

        Iterator<String> stringIterator = strings.iterator();

        while (stringIterator.hasNext()){
            System.out.println(stringIterator.next());
        }

        List<Integer> nums = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            nums.add(i);
        }

        Iterator<Integer> integerIterator = nums.iterator();

        while (integerIterator.hasNext()){
            System.out.println(integerIterator.next());
        }

        System.out.println();

        System.out.println(Arrays.toString(nums.toArray()));

        for (int i = 0; i < nums.size(); i++) {
                nums.remove(i);
        }
        System.out.println(Arrays.toString(nums.toArray()));

        System.out.println();

        ListIterator<Integer> integerListIterator = nums.listIterator();



    }//main

}//IteratorSmallExmaple
