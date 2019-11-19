package composite.dp;

import java.util.List;

/**
 * 
 * @author V. Englebert
 *
 */
public abstract class Component {
	
	protected Composite parent=null;
	
	protected Component(Composite p) {
		assert p!=null;
		
		parent=p;
	}
		
	protected Component() {
		parent=null;
	}
		
	public Composite getParent() {
		return parent;
	}
	
	abstract public List<Component> getChildren();


}
