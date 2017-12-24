package prodcons;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author UNamur
 * Delivers items randomly
 *
 */
public class SharedQueue<E>  {
	
	private List<E> queue=new LinkedList<>();
	
	public synchronized void add(E item){
		assert item!=null;
		
		queue.add(item);		
		notify();
	}
	
	public synchronized E getItem(){
		while (queue.isEmpty()){
			try {
				wait();
			} catch (InterruptedException e) {
				assert false;
				throw new UnknownError();
			}
		}
		notifyAll();
		return queue.remove(0);
	}

	/**
	 * 
	 * @return the size of the queue
	 */
	public synchronized int size() {
		return queue.size();
	}



}
