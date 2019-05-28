package Workspace;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class TestArea {

    public static void main(String[] args) {


        List<BirthRecord> recordList = new ArrayList<>();
        recordList.add(new BirthRecord("jessica", LocalDateTime.now(), 10, 10.3,true, BirthRecord.Gender.FEMALE));
        recordList.add(new BirthRecord("james", LocalDateTime.now(), 9, 12.3,true, BirthRecord.Gender.MALE));
        recordList.add(new BirthRecord("jill", LocalDateTime.now(), 7, 8.3,false, BirthRecord.Gender.FEMALE));
        recordList.add(new BirthRecord("john", LocalDateTime.now(), 10, 10.3, false, BirthRecord.Gender.MALE));
        recordList.add(new BirthRecord("jessica", LocalDateTime.now(), 10, 10.3,true, BirthRecord.Gender.FEMALE));

        recordList.stream().map(BirthRecord::getName).distinct().forEach(System.out::println);

        System.out.println(recordList);
        recordList.sort(Comparator.comparingDouble(BirthRecord::getWeight).thenComparingDouble(BirthRecord::getHeight));
        System.out.println(recordList);

        double averageWeightFemales = recordList.stream().filter(birthRecord ->
            birthRecord.getGender().equals(BirthRecord.Gender.FEMALE)).mapToDouble(BirthRecord::getWeight).average().getAsDouble();
        System.out.println(averageWeightFemales);
        List<String> maleNameList = recordList.stream().filter( birthRecord -> birthRecord.getGender().equals(BirthRecord.Gender.MALE)).map(BirthRecord::getName).collect(Collectors.toList());

        long numberOfMultipleBirths = recordList.stream().filter(BirthRecord::isMultiple).count();
        System.out.println(numberOfMultipleBirths);
       Map<LocalDateTime, List<BirthRecord>> recordMapByDate = recordList.stream().collect(Collectors.groupingBy(BirthRecord::getBirthday));
       System.out.println(recordMapByDate);


        BirthRecord tallestBaby = recordList.stream().max(Comparator.comparingDouble(BirthRecord::getHeight) ).get();
        System.out.println(tallestBaby);

        boolean femaleJessicaMultiple = recordList.stream().filter(BirthRecord::isMultiple).anyMatch(birthRecord -> birthRecord.getName().equalsIgnoreCase("jessica"));
        System.out.println(femaleJessicaMultiple);

        ConcurrentHashMap<String, String> idNameMap = new ConcurrentHashMap<>();

        idNameMap.computeIfAbsent("123.Anna",
                word -> word.substring(word.indexOf(".") + 1)
        );
        System.out.println(idNameMap);




        idNameMap.putIfAbsent("456.Carla", "Carla");
        System.out.println(idNameMap);
    }

}//TestArea
