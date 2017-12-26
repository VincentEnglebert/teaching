package memento;

public class DataState implements IDataState, Cloneable  {

	public String name=null;
	public String firstname=null;
	public int age=-1;

	public DataState() {
		
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {		
		return super.clone();
	}
	
	
}
