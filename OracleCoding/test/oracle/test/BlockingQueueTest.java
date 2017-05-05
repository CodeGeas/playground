package oracle.test;

import java.util.LinkedList;
import java.util.Queue;


class Producer implements Runnable {

    private BlockingQueue<Integer> queue;
    
    public Producer(BlockingQueue<Integer> q){
        this.queue=q;
    }
    @Override
    public void run() {

    	for(int i=0; i<100; i++){
           
            try {
                Thread.sleep(10);
                queue.push(i);
                System.out.println("Produced "+i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
    }

}


class Consumer implements Runnable{

private BlockingQueue<Integer> queue;
    
    public Consumer(BlockingQueue<Integer> q){
        this.queue=q;
    }

	@Override
	public void run() {
		for(int i=0;i<100;i++){
		try {

			Thread.sleep(1000);
			System.out.println("Consumed " + queue.pull());

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		}
	}
}

/**
 * Provides sufficient test coverage for oracle.test.BlockingQueue class.
 */
public class BlockingQueueTest {

	public static void main(String args[])
	{
		Queue<Integer> q=new LinkedList<Integer>();
	  BlockingQueue<Integer> queue = new BlockingQueue<Integer>(q, 10);
      Producer producer = new Producer(queue);
      Consumer consumer = new Consumer(queue);
      new Thread(producer).start();
      new Thread(consumer).start();
	}
}
