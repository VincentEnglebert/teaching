package command;


/**
 * 
 * @author UNamur
 * 
 * Set a char at position pos
 *
 */

public class CommandSetChar extends Command {
	int pos;
	char c;
	
	public CommandSetChar(Document document, int pos, char c){
		super(document);
		
		assert document !=null;
		assert pos>=0 ;
		assert pos<document.toString().length();
		
		this.pos=pos;
		this.c=c;

	}

	@Override
	public void doIt() {
		super.doIt();
		document.setChar(pos,c);		
	}


}
