package composite;

/**
 * 
 * @author V. Englebert
 * 
 * Common operations in File and Folder
 *
 */
public interface Common {
	/**
	 * 
	 * @return the name of the resource
	 */
	public String getName();
	
	/**
	 * Print recursively on System.out the resource (one line per resource) 
	 */
	public void printAll();
}
