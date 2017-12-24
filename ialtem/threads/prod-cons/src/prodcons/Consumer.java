package prodcons;

/**
 * 
 * @author UNamur
 * Consumes messages from a queue until <pre>stopIt</pre> is called.
 *
 */
public class Consumer implements Runnable {
	private final SharedQueue<String> queue;
	private boolean stop=false;
	
	/**
	 * 
	 * @param queue
	 * The constructor starts the thread.
	 */
	public Consumer(SharedQueue<String> queue){
		assert queue!=null;
				
		this.queue=queue;
		new Thread(this).start();
	}
	
	/**
	 * Stop the thread.
	 */
	public void stopIt(){
		stop=true;
	}
	
	
	@Override
	public void run() {
		while (!stop){
			String msg=queue.getItem();
			Util.dodo();
			System.out.printf("%s ->\n", (msg==null) ? "null" : msg );
		}
	}

	

}
