package oracle.test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Provides waiting thread-safe access to a java.util.Queue instance.
 *
 * Requirements:
 * - Usage of API from java.util.concurrent packageis prohibited.
 * - Limit the amount of additional consumed memory to O(1).
 * - The implementation is supposed to be acceptable for usage in a highly
 * multi-thread environment.
 *
 * Useful tips a.k.a. common pitfalls:
 * - Please note that you do not need to implement java.util.Queue.
 * - Readiness to accept or provide elements is solely dependent on the
 * underlying queue. Any additional queue capacity limitations break contract
 * defined in the javadoc.
 */
public class BlockingQueue<E> {
    
	Queue<E> Q;
	int MAX_SIZE;
	
    /**
     * @param queue The underlying "wrapped" queue.
     */
    public BlockingQueue(Queue<E> queue,int maxSizes) {
    	Q=queue;
    	MAX_SIZE=maxSizes;
    	}

    /**
     * Inserts the specified element into the underlying queue, waiting if
     * necessary for the underlying queue to be ready to accept new elements.
     * @param e the element to insert.
     */
    public void push(E e) {

   
		synchronized (this) {
			while (Q.size() == MAX_SIZE) {
				try {
					System.out.println("producer waiting...");
					wait();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
			Q.add(e);
			
			notifyAll();
			 
		}

	}
   
    
    

    /**
     * Retrieves and removes the head of the underlying queue, waiting if
     * necessary until it is capable of providing an element.
     * @return the retrieved element
     */
    public E pull() {
    	E e=null;
    	synchronized (this) {
			while (Q.size() == 0) {
				try {
					System.out.println("consumer waiting...");

					wait();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
			e=Q.poll();
			
			notifyAll();
			 
		}
    return e;
    }
}
