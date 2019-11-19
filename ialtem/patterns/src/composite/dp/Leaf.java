package composite.dp;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public abstract class Leaf extends Component {

	/**
	 * 
	 * @param p!=null, the owner of this
	 */
	protected Leaf(Composite p) {
		super(p);
	}
	
	protected Leaf() {
		super();
	}

	@Override
	public List<Component> getChildren() {
		return Collections.unmodifiableList(new LinkedList<Component>());
	}
	
	

}
