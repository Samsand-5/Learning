package Task28thMarch1stOne;

public class CalciVer1 extends AbstractCalciVer1{

    int add(int a,int b){
        return a+b;
    }

    int sub(int a,int b){
        return Math.abs(a-b);
    }

    @Override
    double power(double a, double b) {
        return Math.pow(a,b);
    }
}
