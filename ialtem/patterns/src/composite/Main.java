package composite;

public class Main {
	
	@SuppressWarnings("unused")
	static public void main(String args[]) {	
		
		Folder root = new Folder(".");
		File readme = new File(root,"readme");
		Folder src = new Folder(root,"src");
		File thesis = new File(src,"thesis.tex");
		File bib = new File(src,"thesis.bib");
		Folder img = new Folder(src,"images");
		File logo = new File(img,"logo.jpg");
		Folder todelete=new Folder(img,"todelete");
		File bangbang=new File(todelete,"bangbang.mp3");
		img.remove(todelete);
		
		System.out.printf("%s\n\n",logo.toString());
		
		root.printAll();
		
	}

}
