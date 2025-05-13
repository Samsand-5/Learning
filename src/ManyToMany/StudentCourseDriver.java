package ManyToMany;

import java.util.Arrays;

public class StudentCourseDriver {
    public static void main(String[] args) {
        Student s1=new Student("Soumyodip",13);
        Student s2=new Student("Shuvam",14);

        Course c1 = new Course("java",5);
        Course c2 = new Course("Python",8);
        Course c3 = new Course("C++",2);

        s1.addCourse(c1);
        s2.addCourse(c2);
        s1.addCourse(c3);
        s1.addCourse(c2);
        s2.addCourse(c3);

        System.out.println(Arrays.toString(s1.arr)+"\t"+Arrays.toString(s2.arr));
    }
}
