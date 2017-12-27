package command;

public class Document  {
	private StringBuffer stringbuffer ;

	public Document(){
		stringbuffer= new StringBuffer();		
	}
	
	public Document(String string){
		stringbuffer=new StringBuffer(string);
	}
	
	public void set(String s) {
		assert s!=null;
		stringbuffer=new StringBuffer(s);
	}
	
	public String toString(){
		return stringbuffer.toString();
	}

	public void setChar(int pos, char c) {
		stringbuffer.setCharAt(pos, c);		
	}

	public void delChar(int pos) {
		stringbuffer.deleteCharAt(pos);
	}

	
}
