package Midterm;

import java.io.*;
import java.util.*;

public class TestArea {

    public static void main(String[] args) {

        List<Integer> numList = new ArrayList<Integer>();
        numList.add(3);
        numList.add(2);
        numList.add(34);
        numList.add(13);
        numList.add(66);
        numList.add(4);
        numList.add(3);

        List<String> wordList = new ArrayList<String>();
        wordList.add("hi");
        wordList.add("there");
        wordList.add("moo");
        wordList.add("new");
        wordList.add("friend");

        Integer[] nums = new Integer[5];
        nums[0] = 1;
        nums[1] = 2;
        nums[2] = 3;
        nums[3] = 4;
        nums[4] = 5;

        String[] names = new String[5];
        names[0] = "Aurthor";
        names[1] = "Bruce";
        names[2] = "moo";
        names[3] = "Damien";
        names[4] = "Ed";



        List<Animal> animals = new ArrayList<Animal>();

        animals.add(new Cow("moo",3));
        animals.add(new Horse("may",6,new RawFoodFeeder()));

        Map<String, Animal> animalMap = new HashMap<>();
        animalMap.put("moo",animals.get(0));
        animalMap.put("may", animals.get(1));

        Collection<Animal> mapView = animalMap.values();

        for (Animal animal: mapView
             ) {
            System.out.println(animal.getStatus());
        }

        adoptionUpdates(animalMap,wordList);

        for (Animal animal: mapView
        ) {
            System.out.println(animal.getStatus());
        }

    }//main

    public static void randomNumListFill(List<Integer> list){
        list.clear();

        for (int i = 0; i < list.size(); i++) {
            list.add(i, ((int) (Math.random() * 10) ));
        }
    }

    public static void randomStringListFill(List<String> list){
        list.clear();
        int wordSize = 3;
        for (int i = 0; i < list.size(); i++) {
            char[] chars = new char[wordSize];
            for (int j = 0; j < chars.length; j++){
                chars[j] = (char) ((int) ((Math.random() * 5) +97));
            }
            String addString = String.copyValueOf(chars);
            list.add(i, addString);
        }
    }
    public static void printAnimalsToFile(List<Animal> animals, String fileName) {

        Iterator<Animal> animalIterator = animals.iterator();

        try (PrintWriter outPut = new PrintWriter(
                new BufferedWriter(
                        new FileWriter(
                                new File(fileName)
                        )
                )
        )){
            while (animalIterator.hasNext()){
                outPut.println(animalIterator.next().getName());
            }

        } catch (IOException e){
            e.printStackTrace();
        }

    }

    public static void errorCheck(int num){
        System.out.println("step 1");
        try {
            int div =  2/num ;
        } catch (ArithmeticException e){
            System.out.println("error");
        }
        System.out.println("step 2");
    }

    public static int countAdoptableAnimals(List<Animal> animals) {
        int count = 0;

        for (Animal animal: animals
             ) {
            if (animal.getStatus().getAdoptable()){
                count++;
            }

        }

        return count;
    }

    public static void adoptionUpdates(Map<String, Animal> animalMap, List<String> animalNameList) {

        //This copy constructor runs in O(n) and makes sure that .get will run in constant time
        HashMap<String, Animal> coppyMap = new HashMap<>(animalMap);

        Iterator<String> nameIterator = animalNameList.iterator();

        while (nameIterator.hasNext()){
            Animal animal =  animalMap.get(nameIterator.next());
            if (animal != null){
               animal.setStatus(Animal.AnimalStatus.NO_LONGER_RESIDING);
            }
        }

    }
}//TestArea
