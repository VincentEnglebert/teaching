package composite.dp;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public abstract class Leaf extends Component {

	protected Leaf(Composite p) {
		super(p);
	}

	@Override
	public List<Component> getChildren() {
		return Collections.unmodifiableList(new LinkedList<Component>());
	}
	
	

}
