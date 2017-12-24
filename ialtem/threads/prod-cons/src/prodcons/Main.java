/**
 * 
 */
package prodcons;

import java.util.HashSet;
import java.util.Set;

/**
 * @author UNamur
 *
 */
public class Main {
	/**
	 * @param args 
	 * args[0]== nbr producers 
	 * 
	 */
	public static void main(String[] args) {
		if (args==null || args.length!=2){
			System.out.println("usage: java -jar prodcons.jar <nbrproducers> <duration>");
			System.out.println("Default values used");
			args=new String[]{"3","30"};
		}
		
		int nbrProducers=0;
		int duration=0;
		Set<Producer> producers=new HashSet<>();
		
		try {
			nbrProducers=Integer.parseUnsignedInt(args[0]);
			duration=Integer.parseUnsignedInt(args[1]);
		} catch (NumberFormatException e) {
			helpMessage();
			System.exit(1);
		}
		System.out.printf("%d producers\n", nbrProducers);
		System.out.printf("duration= %d seconds\n", duration);
		System.out.flush();
		SharedQueue<String> queue=new SharedQueue<>();
		for (int i=0;i<nbrProducers;i++){
			Producer prod = new Producer(String.format("Prod[%d]", i+1), queue);
			producers.add(prod);
		}
		Consumer consumer = new Consumer(queue);
		System.out.printf("Main sleeping for %d seconds\n",duration);
		Util.dodo(duration);
		System.out.printf("Main stops the producers.\n",duration);
		for (Producer prod: producers){
			prod.stopIt();
		}
		System.out.printf("Main sleeping for %d seconds\n",duration);
		Util.dodo(duration);
		System.out.printf("Main stops the consumer\n",duration);
		consumer.stopIt();
		System.out.printf("Program should halt now.\n");
		System.out.printf("Items pending in queue=%d items.\n",queue.size());

	}

	private static void helpMessage() {
		System.out.println("Syntax: Main nbrProducers duration\n"+
						   "	nbrPducers: unsigned integer\n"+
					       "    duration: unsigned integer / nbr seconds");
		
	}

}
