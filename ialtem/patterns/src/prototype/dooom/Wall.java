package prototype.dooom;

/***
 * @author Vincent Englebert
 */

public class Wall implements Prototype {
	private int height=0;
	private int width=0;
	private String tag="";

	@Override
	public Prototype clone() {
		Wall copy = new Wall();
		copy.setHeight(height);
		copy.setLength(width);
		copy.setTag(tag);
		return copy;
	}

	public int getHeight() {
		return height;
	}

	public Wall setHeight(int height) {
		assert height>=0;
		
		this.height = height;
		return this;
	}

	public int getWidth() {
		return width;
	}

	public Wall setLength(int width) {
		assert width>=0;
		
		this.width = width;
		return this;
	}

	public String getTag() {
		return tag;
	}

	public Wall setTag(String tag) {
		assert tag!=null;
		
		this.tag = tag;
		return this;
	}

	@Override
	public String toString() {
		return String.format("Wall[%s,%d,%d]",tag,height,width);
	}

}
