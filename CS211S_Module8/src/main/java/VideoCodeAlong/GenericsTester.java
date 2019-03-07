package VideoCodeAlong;

import java.util.Arrays;

public class GenericsTester {

    private static final int ARRAY_SIZE = 100;
    private static final int MAX_NUM = 500;

    public static void main(String[] args) {

        Integer[] nums = new Integer[ARRAY_SIZE];

        String[] words = new String[ARRAY_SIZE];

        fillArray(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(ArrayUtilities.findDupliicates(nums)+"\n");

        fillArray(words);
        System.out.println(Arrays.toString(words));
        System.out.println(ArrayUtilities.findDupliicates(words));

    }//main

    private static void fillArray(Integer[] nums){
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) (Math.random() * MAX_NUM);
        }
    }

    private static void fillArray(String[] words){
        int wordLength = 3;
        for( int i = 0; i < words.length; i++){
            char[] wordChar = new char[wordLength];
            for (int j = 0; j < wordLength; j++) {
                 wordChar[j] = (char) (97 + (int) (Math.random() * 10));
            }

            words[i] = String.valueOf(wordChar);
        }

    }


}//GenericsTester
