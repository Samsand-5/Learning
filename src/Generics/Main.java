package Generics;

import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Box<Integer> box = new Box<>();
        box.setValue(1);
        int i = box.getValue();
        System.out.print(i);

        Pair<String,Integer> pair=new Pair<>("Age",30);
        System.out.println(pair.getKey());
        System.out.println(pair.getValue());

        Main main=new Main();
        Integer[] intArr={1,2,3,4,5};
        String[] str={"hi","Soumyodip"};
        main.printArray(intArr);
        main.printArray(str);

        System.out.println(sum(Arrays.asList(1,2.2,3)));
        List<? super Integer> numbers = Arrays.asList(1,2,3);
        printNumbers(numbers);
    }

    public <T> void printArray(T[] array){
        for(T element: array){
            System.out.print(element+" ");
        }
        System.out.println();
    }

    //Upper Boundation
    public static double sum(List<? extends Number> numbers){
        double sum=0;
        for (Number o:numbers){
            sum+=o.doubleValue();
        }
        return sum;
    }
    //Lower Boundation
    public static void printNumbers(List<? super Integer> list){
        for (Object obj: list){
            System.out.println(obj);
        }
    }
}