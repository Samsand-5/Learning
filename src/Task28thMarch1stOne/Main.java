package Task28thMarch1stOne;

public class Main {
    public static void main(String[] args) {
        CalciVer1 c1 = new CalciVer1();
        System.out.println("Add " + c1.add(1, 2));
        System.out.println("Sub "+ c1.sub(1,2));
        System.out.println("Power " + c1.power(2, 3));

        System.out.println();

        CalciVer2 c2 = new CalciVer2();
        System.out.println("Add " + c2.add(1, 2));
        System.out.println("Sub " + c2.sub(1, 2));
        System.out.println("Square " + c2.square(2));
        System.out.println("Cube " + c2.cube(2));

        System.out.println();

        BasicCalci bc=new BasicCalci();
        System.out.println("Add " + bc.add(1,2));
        System.out.println("Sub " + bc.sub(1,2));
    }
}

