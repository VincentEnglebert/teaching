package composite.dp;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public abstract class Composite extends Component {
	private final List<Component> children=new LinkedList<>();

	protected Composite(Composite p) {
		super(p);
	}

	@Override
	public List<Component> getChildren() {
		return Collections.unmodifiableList(children);
	}

	public void addChild(Component c) {
		assert c!=null;
		children.add(c);
	}
	
}
