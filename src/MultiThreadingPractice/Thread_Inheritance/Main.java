package MultiThreadingPractice.Thread_Inheritance;

public class Main {

    public static void main(String[] args) {

        AtheleteThread firstAthlete=new AtheleteThread("MArcus",Thread.MAX_PRIORITY,84112);
        AtheleteThread secondAthlete=new AtheleteThread("kunal Supekar",Thread.MIN_PRIORITY,43114);

        System.out.println(firstAthlete.getName());
        System.out.println(secondAthlete.getName());

        firstAthlete.start();
        secondAthlete.start();
    }

}
