package prototype.dooom;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/***
 * @author Vincent Englebert
 */
public class Room implements Prototype {
	private List<Wall> walls = new LinkedList<>();
	private int number = 0;

	@Override
	public Prototype clone() {
		Room copy = new Room();
		copy.number = number;
		for (Wall w : walls) {
			copy.walls.add((Wall) w.clone());
		}
		return copy;
	}

	public int getNumber() {
		return number;
	}

	public Room setNumber(int number) {
		this.number = number;
		return this;
	}

	public Room addWall(Wall wall) {
		assert wall != null;
		walls.add((Wall) wall.clone());
		return this;
	}

	public List<Wall> getWalls() {
		return Collections.unmodifiableList(walls);
	}

	@Override
	public String toString() {
		return String.format("Room[%s,%s]",number,walls);
	}
}
