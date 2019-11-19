package composite;

import composite.dp.Leaf;


/**
 * This class denotes a file. By convention, a file must always belong to a folder.
 * @author V. Englebert
 *
 */
public class File extends Leaf implements Common {
	
	private String filename=null;

	/**
	 * 
	 * @param folderParent the parent
	 * @param fn the name of the resource (not null and !="")
	 */
	public File(Folder folderParent, String fn) {
		super(folderParent);
		
		assert folderParent!=null : "A file must always be created inside a folder."; 
		
		filename=fn;
		folderParent.addChild(this);
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

