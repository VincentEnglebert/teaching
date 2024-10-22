package composite.dp;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public abstract class Composite extends Component {
	private final List<Component> children=new LinkedList<>();

	protected Composite(Composite p) {
		super(p);
	}
	
	protected Composite() {
		super();
	}

	@Override
	public List<Component> getChildren() {
		return Collections.unmodifiableList(children);
	}

	public void addChild(Component c) {
		assert c!=null;
		children.add(c);
	}
	
	/**
	 * @pre c!=null && c is a child of this.
	 * @post c is disconnected from this
	 * @param c the child to remove
	 */
	public void remove(Component c) {
		assert c!=null  && children.contains(c);
		children.remove(c);
		c.parent=null;
	}
	
}
