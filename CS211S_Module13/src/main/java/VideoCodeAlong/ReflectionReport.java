package VideoCodeAlong;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.Scanner;

public class ReflectionReport {

    public static void main(String[] args) {
       boolean keepGoing = true;

        Scanner userInput = new Scanner(System.in);

       while (keepGoing){
           System.out.println("Give action to take");
           String action = userInput.nextLine();

           switch (action){
               case "fullReflection":
                   System.out.println("Please give  class to reflect");
                   String classR = userInput.nextLine();
                   fullReflect(classR);
                   break;

               case "quit":
                   keepGoing = false;
                   break;
           }
       }
    }

    private static void fullReflect(String classR){
        try {
        Class class1 = Class.forName(classR);
            Class     superClass = class1.getSuperclass();
        System.out.println(class1.getName());

        Class[] classes = {class1, superClass, superClass.getSuperclass()};

        for (Class cl: classes
             ) {

            if (cl == null ) return;

            System.out.println("****************");
            System.out.println("Class = " + cl.getName());
            System.out.println("Parent class = " + superClass.getName());

            Field[] fields = cl.getDeclaredFields();
            for (Field fl: fields
                 ) {
                System.out.println("******** Field ********");
                System.out.println(fl.getName() + "  type" + fl.getType().getName());

                System.out.println("Modifiers");

                int modifers = fl.getModifiers();
                boolean mod;
                mod = Modifier.isStatic(modifers);
                if (mod) System.out.println("Static");
                mod = Modifier.isPrivate(modifers);
                if (mod) System.out.println("Private");
                mod = Modifier.isPublic(modifers);
                if (mod) System.out.println("Public");
                mod = Modifier.isProtected(modifers);
                if (mod) System.out.println("Protected");
            }

            Constructor[] constructors = cl.getConstructors();
            for (Constructor constructor: constructors
                 ) {
                System.out.println("******** Constructor  ********");
                Parameter[] parameters = constructor.getParameters();
                for (Parameter parameter: parameters
                     ) {
                    System.out.println("Parameter name : " + parameter.getName() + "parameter type : " + parameter.getType().getName());
                }
            }

            Method[] methods = cl.getDeclaredMethods();
            for (Method method: methods
                 ) {
                System.out.println("******** Method  ********");
                System.out.println("Method name " + method.getName());
                System.out.println("Method parameters");
                Parameter[] parameters = method.getParameters();
                for (Parameter parameter: parameters
                     ) {
                    System.out.println("Parameter name : " + parameter.getName() + "parameter type : " + parameter.getType().getName());
                }
                System.out.println("ReturnType :" + method.getReturnType().getName());

                System.out.println("Method modifiers");

                int modifers = method.getModifiers();
                boolean mod;
                mod = Modifier.isStatic(modifers);
                if (mod) System.out.println("Method is Static");
                mod = Modifier.isPrivate(modifers);
                if (mod) System.out.println("Method is Private");
                mod = Modifier.isPublic(modifers);
                if (mod) System.out.println("Method is Public");
                mod = Modifier.isProtected(modifers);
                if (mod) System.out.println("Method is Protected");
            }

            Annotation[] annotations = cl.getAnnotations();
            for (Annotation annotation: annotations
                 ) {
                System.out.println("****** Annotation ******");
                System.out.println( annotation);
            }

            Class[] interfaces = cl.getInterfaces();
            for (Class interfac: interfaces
                 ) {
                System.out.println("******** Interface ********");
                System.out.println("Interface name : " + interfac.getName());
                Method[] interfaceMethods = interfac.getMethods();
                for (Method interfMethod: interfaceMethods
                ){
                    System.out.println("Interface method name" + interfMethod.getName());
                    Parameter[] parameters = interfMethod.getParameters();
                    for (Parameter parameter: parameters
                         ) {
                        System.out.println("Interface method parameter name :" + parameter.getName());
                    }
                }

            }

            System.out.println("\n");
        }

        } catch (ClassNotFoundException e){
            e.printStackTrace();
            System.out.println("That was not a valid class");
            return;
        }

    }

}//ReflectionReport
