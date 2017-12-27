package command;



/**
 * 
 * @author UNamur
 * 
 * Delete a char at position pos
 *
 */
public class CommandDelChar extends Command {
	int pos;
	char c;
	
	public CommandDelChar(Document document, int pos){
		super(document);
		
		assert document !=null;
		assert pos>=0 ;
		assert pos<document.toString().length();
		
		this.pos=pos;

	}

	@Override
	public void doIt() {
		super.doIt();
		document.delChar(pos);		
	}


}
