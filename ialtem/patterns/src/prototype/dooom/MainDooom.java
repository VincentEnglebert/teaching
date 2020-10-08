package prototype.dooom;

/***
 * @author Vincent Englebert
 */

public class MainDooom {

	static public void main(String args[]) {
		Room room01=new Room().setNumber(1);
		Wall left=new Wall().setHeight(200).setLength(400).setTag("Love Lisp");
		Wall right=((Wall)left.clone()).setTag("Hate Cobol");
		Wall front=((Wall)left.clone()).setLength(500).setTag("Welcome");
		Wall back=((Wall)left.clone()).setLength(500).setTag("Back");
		room01.addWall(left).addWall(right).addWall(front).addWall(back);
		Room room02=((Room)room01.clone()).setNumber(02);
		
		System.out.println(room01);
		System.out.println(room02);
	}
	
}
