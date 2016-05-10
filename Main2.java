/**
 * Created by VannessTan on 10/05/2016.
 */
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main2 {

    public static void main(String[] args){

        ArrayBlockingQueue queue = new ArrayBlockingQueue<>(5);

        SetThread set = new SetThread(queue);
        GetThread get = new GetThread(queue);

        Thread t1 = new Thread(set);
        Thread t2 = new Thread(get);

        t1.start(); t2.start();

        try {
            t1.join();
            t2.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}