package memento;

/**
 * @author Vincent Englebert
 */


public class MainMemento {

	public static void main(String[] args) {
		StatefullClass jean=new StatefullClass("Jean","Fichefet",18);
		
		IDataState backup = jean.getMemento();
		
		jean.birthday();
		jean.birthday();
		
		// oops, too much Houpe !!!
		
		jean.setMemento(backup);
		
		jean.birthday();
		
		System.out.printf("Jean is %d old\n", jean.getAge());
		assert jean.getAge()==19;
	}

}
