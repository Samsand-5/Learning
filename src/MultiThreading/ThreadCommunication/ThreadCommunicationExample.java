package MultiThreading.ThreadCommunication;

class  SharedResource{
    private int data;

    private boolean hasData;

    public void produce(int value){

    }

    public void consume(){

    }
}

class Producer implements Runnable{
    private SharedResource resource;

    public Producer(SharedResource resource){
        this.resource=resource;
    }


    @Override
    public void run() {
        for(int i=0;i<10;i++){
            resource.produce(i);
            System.out.println("Produced: "+i);
        }
    }
}
public class ThreadCommunicationExample {

}
