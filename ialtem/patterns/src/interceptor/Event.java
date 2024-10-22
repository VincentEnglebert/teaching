package interceptor;

/**
 * @author Vincent Englebert
 */


//import java.nio.charset.StandardCharsets;

public class Event {
	private String info;

	public Event(String sentence) {
		info=sentence;
	}

	public String getInfo(){
		return info;
	}

	public void setInfo(String info){
		assert info!=null;
		
		this.info=info;
	}

	@Override
	public String toString() {
		return "Event [info=" + info + "]";
	}
	
	
}
