package composite.dp;

import java.util.List;

public abstract class Component {
	
	final protected Composite parent;
	
	protected Component(Composite p) {
		parent=p;
	}
		
	abstract public List<Component> getChildren();
	
	public Composite getParent() {
		return parent;
	}

}
