package prodcons;

/**
 * 
 * @author V. Englebert
 * Stores an infinite series of messages until <pre>stopIt</pre> is called. 
 *
 */
public class Producer implements Runnable {
	private final SharedQueue<String> queue;
	private final String name;
	private boolean stop=false;
	
	/**
	 * 
	 * @param name name of the producer (not null)
	 * @param queue 
	 * The constructor exercutes the thread.
	 */
	public Producer(String name,SharedQueue<String> queue){
		assert queue!=null;
		assert name!=null;
		
		this.queue=queue;
		this.name=name;
		new Thread(this).start();
	}
	
	/**
	 *  stops the Thread
	 */
	public void stopIt(){
		stop=true;
	}
	
	@Override
	public void run() {
		int i=0;
		while (!stop){
			Util.dodo();
			String msg=String.format("msg(%d)",i);
			i=i+1;
			queue.add(msg);
			System.out.printf("%s -> %s\n",name,msg);
		}
	}
}
