package VideoCodeAlong;

public class PairTester {

    public static void main(String[] args) {

        Pair<Integer> nums = new Pair<>(3,4);
        Pair<Integer> nums2 = new Pair<>(3,4);

        System.out.println(nums.equals(nums2));

        Pair<String> words = new Pair<>("hello", "world");

        System.out.println(nums);
        System.out.println(words);
    }//main

}//PairTester
