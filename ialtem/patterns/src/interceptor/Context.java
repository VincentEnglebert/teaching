package interceptor;

/**
 * @author Vincent Englebert
 */

import java.util.Date;

public class Context {
	private Date timestamp;
	private Event event;

	Context(Date timestamp,Event event){
		this.timestamp=timestamp;
		this.event=event;
	}

	public Event getEvent() {
		return event;
	}
	
	public Date getTimestamp(){
		return timestamp;
	}

	@Override
	public String toString() {
		return "Context [timestamp=" + timestamp + ", event=" + event + "]";
	}
	
	
}
