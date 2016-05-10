/**
 * Created by VannessTan on 10/05/2016.
 */
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

public class SetThread implements Runnable {

    ArrayBlockingQueue queue;
    Random rand = new Random();

    public SetThread(ArrayBlockingQueue queue) {

        this.queue = queue;
    }

    public void run() {

        while (true){

            int generatedNumber;

            for(int count = 0; count < 5; count++){

                try{
                    Thread.sleep(1000);
                } catch(InterruptedException e){
                    e.printStackTrace();
                }

                generatedNumber = rand.nextInt(100) + 1;

                try{
                    queue.put(generatedNumber);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }

                System.out.println(generatedNumber + " is added!");
            }

            try{
                System.out.println("----- Thread1 is sleeping for 5 seconds -----\n");
                Thread.sleep(5000);
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
