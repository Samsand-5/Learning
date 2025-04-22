package Task28thMarch1stOne;

public class CalciVer2 extends AbstractCalciVer2{

    int add(int a,int b){
        return a+b;
    }

    int sub(int a,int b){
        return Math.abs(a-b);
    }

    @Override
    double square(double a) {
        return a*a;
    }

    @Override
    double cube(double a) {
        return a*a*a;
    }
}
