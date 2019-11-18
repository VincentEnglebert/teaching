package composite;

import composite.dp.Composite;
import composite.dp.Component;

public class Folder extends Composite implements Common{
	private String foldername=null;

	protected Folder(Folder folderParent, String fn) {	
		super(folderParent);
		assert folderParent!=null;
		assert fn!=null && !fn.equals("");
		foldername=fn;
		folderParent.addChild(this);
	}
	
	protected Folder(String fn) {	
		super(null);
		assert fn!=null && !fn.equals("");
		foldername=fn;
	}

	public String getFoldername() {
		return foldername;
	}

	public void setFoldername(String fn) {
		assert fn!=null && !fn.equals("");
		this.foldername = fn;
	}

	@Override
	public void addChild(Component candidate) {
		assert candidate!=null;
		checkPrecondition(candidate);
		super.addChild(candidate);
	}

	private void checkPrecondition(Component candidate) {
		assert candidate.getClass()==Folder.class || candidate.getClass()==File.class;
		
		for (Component child : getChildren()) {
			Common childcommon=(Common)child;
			String childName = ((Common)childcommon).getName();
			String candidateName = ((Common)candidate).getName();
			if (candidateName.equals(childName)) {
				throw new RuntimeException(String.format("File already exists with the same name (%s) in this folder (%s)",candidateName,getFoldername())); 
			}
		}
	}

	@Override
	public String getName() {
		return getFoldername();
	}
	
	@Override
	public String toString() {
		if (getParent()==null) {
			return getFoldername();
		} else {
			return String.format("%s/%s",getParent().toString(),getFoldername());
		}
	}
	
	@Override
	public void printAll() {
		System.out.println(this.toString());
		for (Component comp: getChildren()) {
			((Common)comp).printAll();
		}
	}


}
