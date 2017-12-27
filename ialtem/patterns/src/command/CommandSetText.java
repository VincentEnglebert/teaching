package command;

/**
 * 
 * @author UNamur
 * 
 * (Re)Initialize the document with a fresh text.
 *
 */


public class CommandSetText extends Command {
	private String text;
	
	public CommandSetText(Document document, String s){
		super(document);
		
		assert document !=null;
		assert s!=null;
		
		text=s;
	}

	@Override
	public void doIt() {
		super.doIt();
		document.set(text);		
	}


}
