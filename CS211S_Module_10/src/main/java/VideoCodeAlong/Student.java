package VideoCodeAlong;

public class Student implements Comparable<Student> {

    private String nane;
    private int id;

    public Student(String nane, int id) {
        this.nane = nane;
        this.id = id;
    }

    public String getNane() {
        return nane;
    }

    public void setNane(String nane) {
        this.nane = nane;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString(){
        return "Name : " + this.nane + " ID : " + this.id;
    }
    @Override
    public int compareTo(Student other){
        return this.nane.compareTo(other.nane);
    }
}//Student
