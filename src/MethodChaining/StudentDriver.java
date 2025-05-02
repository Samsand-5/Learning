package MethodChaining;

import MethodChaining.Student;

public class StudentDriver {
    public static void main(String[] args) {
        Student st=new Student();
        st.setName("Soumyodip").setId(67).display();
    }
}
