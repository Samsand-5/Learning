package Task28thMarch1stOne;

public class BasicCalci extends Calculator{

    @Override
    int add(int a, int b) {
        return a+b;
    }

    @Override
    int sub(int a, int b) {
        return Math.abs(a-b);
    }

}
