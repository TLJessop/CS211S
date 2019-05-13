package Homework;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface Documentation {

    public static enum Status {FULLLY_DOCUMENTED, IN_PROCESS, NEEDS_REVISION};

    String nameOfDocFile();
    String locationOfDocFile();
    Status documentationStatus() default Status.IN_PROCESS;

}//Documentation
