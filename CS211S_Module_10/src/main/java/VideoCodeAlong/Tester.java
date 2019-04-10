package VideoCodeAlong;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Tester {

    public static void main(String[] args) {

        LocalDate today = LocalDate.now();

        LocalDate nextWeek = today.plusWeeks(1);

        Period tt = Period.between(today,nextWeek);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM/dd/yy");
        System.out.println(today);
        System.out.println(formatter.format(today));

        List<Student> students = new ArrayList<>();

        students.add(new Student("joe", 1));
        students.add(new Student("james", 27));
        students.add(new Student("mat", 33));
        students.add(new Student("mike", 4));
        students.add(new Student("dave", 12));
        students.add(new Student("tim", 18));

        System.out.println(students+"\n");
        Collections.sort(students);
        System.out.println(students+"\n");

        //Anonymous innerclass
        Collections.sort(students,
                new Comparator<Student>() {
                    @Override
                    public int compare(Student o1, Student o2) {
                        return Integer.compare(o1.getId(),o2.getId());
                    }
                });
        System.out.println(students);

    }//main


}//Tester
