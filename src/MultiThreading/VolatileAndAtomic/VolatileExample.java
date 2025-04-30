package MultiThreading.VolatileAndAtomic;


class SharedObj{

    private boolean flag=false;

    public void setFlagTrue(){
        flag=true;
    }

    public void printIfFlagTrue(){
        while(!flag){

        }
        System.out.println("Flag is true");
    }
}
public class VolatileExample {
    public static void main(String[] args) {

    }
}
