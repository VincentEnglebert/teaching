package playerRole.roles;

public class Worker extends Extra {

	public Worker() {
		// TODO Auto-generated constructor stub
	}

	public String getIDCard() {
		return (String)attributes[0];
	}
	
	public long getAge(){
		return (Integer)attributes[1];
	}

	public String getCity(){
		return (String)attributes[2];
	}
}
