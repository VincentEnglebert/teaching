package abstractFactory.factory;

import java.util.HashSet;
import java.util.Set;

public abstract class Window  extends Widget {
	private Set<Widget> set=new HashSet<>();

	public Window add(Widget widget) {
		assert widget!=null;
		
		set.add(widget);
		return this;
	}

	public void display(){
		for (Widget w: set){
			System.out.println(String.format("Object of type %s is displayed ", w.getClass().getSimpleName()));
		}
	}

}
