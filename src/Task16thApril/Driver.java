package Task16thApril;

import java.util.*;

public class Driver {
    public static void main(String args[]){
        ArrayList<Employee> arr = new ArrayList<>();
        arr.add(new Employee(1, "Soumyodip", 50000));
        arr.add(new Employee(2, "Shuvam", 50000));
        arr.add(new Employee(3, "Tathagata", 50000));

        ArrayList<Employee> newArr = new ArrayList<>();

        newArr.add(new Employee(4, "Samriddhi", 50000));
        newArr.add(new Employee(5, "Supriyo", 50000));
        newArr.add(new Employee(6, "Shreyashi", 50000));
        arr.addAll(newArr);

        Iterator<Employee> itr = arr.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        String searchName = "Shuvam";
        boolean found = false;
        for (Employee emp : arr) {
            if (emp.name.equalsIgnoreCase(searchName)) {
                System.out.println("Found");
                found = true;
                break;
            }
        }
        if (found == false) {
            System.out.println("Not found");
        }

        arr.remove(0);

        arr.remove(new Employee(3,"Tathagata",50000));

        System.out.println();
        for (Employee emp : arr) {
            System.out.println(emp);
        }

        System.out.println();
        arr.sort(Comparator.comparing(emp -> emp.name));
        for (Employee emp : arr) {
            System.out.println(emp);
        }

        System.out.println();
        arr.sort(Comparator.comparingInt(emp -> emp.id));
        for (Employee emp : arr) {
            System.out.println(emp);
        }
    }
}
