package command;

public abstract class Command {
	protected final Document document;
	protected String backup=null;
	
	protected Command(Document document){
		this.document=document;
	}
	
	public void doIt(){
		// ok, this implementation is very lazy but so simple... ;-)
		// How could you improve this implementation ?
		backup=document.toString();
	}
	public void UndoIt(){
		document.set(backup);
	}
	public boolean canBeUndone(){
		return backup!=null;		
	}
}
