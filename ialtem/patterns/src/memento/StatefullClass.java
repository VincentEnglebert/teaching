package memento;

public class StatefullClass {
	private DataState state=new DataState();
	
	public StatefullClass(String name,String firstname, int age) {
		state.name=name;
		state.firstname=firstname;
		state.age=age;		
	}

	/**
	 * Increase the age
	 */
	public void birthday(){
		state.age++;
	}
	
	public IDataState getMemento(){
		try {
			return (IDataState)state.clone();
		} catch (CloneNotSupportedException e) {			
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}
	
	public void setMemento(IDataState state){
		this.state=(DataState)state;
	}


	public int getAge() {
		return state.age;
	}
}
