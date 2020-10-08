package prototype.version1;


public class MainApp1 {
	
	static public void main(String args[]){
		
		// 3 objects: jean, hector and toyota
		
		Prototype jean=new Prototype();
		jean.set("name", "jean").set("age", 10);
		Prototype hector=jean.clone().set("name", "hector");
		Prototype toyota=new Prototype().set("marque", "toyota").set("plaque", "XXX999");
		
		
		// 2 class objects : Person, Car
		
		Prototype tPerson=new Prototype().set("name", "Person");
		Prototype tCar=new Prototype().set("name", "Car");
		
		// fix the type of objects
		
		jean.set("type", tPerson);
		hector.set("type",tPerson);
		toyota.set("type", tCar);
		
		// 1 metaclass object : tClass
		
		Prototype tClass=new Prototype();
		
		// fix the type of classes 
		
		tPerson.set("type",tClass);
		tCar.set("type",tClass);
		
		// fix the type of metaclass
		
		tClass.set("type", tClass);
		
		// print some objects 
		
		System.out.println(hector.toString());
		System.out.println(jean.toString());
		System.out.println(toyota.toString());
		System.out.println(tPerson.toString());
		System.out.println(tCar.toString());
		System.out.println(tClass.toString());
		
	}

}
