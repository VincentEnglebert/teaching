package composite;

import composite.dp.Leaf;

public class File extends Leaf implements Common {
	
	private String filename=null;

	public File(Folder folder, String fn) {
		super(folder);
		
		assert folder!=null : "A file must always be created inside a folder."; 
		
		filename=fn;
		folder.addChild(this);
		assert fn!=null && !fn.equals("");
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String fn) {
		assert fn!=null;
		assert !fn.equals("");
		
		this.filename = fn;
		assert fn!=null && !fn.equals("");
	}

	@Override
	public String getName() {
		return getFilename();
	}

	@Override
	public String toString() {
		return String.format("%s/%s", getParent()== null ? "" : getParent().toString(),getFilename());
	}

	@Override
	public void printAll() {
		System.out.println(this.toString());
	}

	
}

