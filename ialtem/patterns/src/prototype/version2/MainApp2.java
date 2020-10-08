package prototype.version2;

/**
 * @author Vincent Englebert
 */
public class MainApp2 {

	public static final String TYPE_NAME = "__name__";
	public static final String TYPE = "__type__";

	static public void main(String args[]) {
		// 3 objects: jean, hector and toyota

		Prototype jean = new Prototype();
		jean.set(TYPE_NAME, "jean").set("age", 10);
		Prototype hector = jean.clone().set(TYPE_NAME, "hector");
		Prototype toyota = new Prototype().set("marque", "toyota").set("plaque", "XXX999");

		// 2 class objects : Person, Car

		Prototype tPerson = new Prototype().set(TYPE_NAME, "Person");
		Prototype tCar = new Prototype().set(TYPE_NAME, "Car");

		// fix the type of objects

		jean.set(TYPE, tPerson);
		hector.set(TYPE, tPerson);
		toyota.set(TYPE, tCar);

		// 1 metaclass object : tClass

		Prototype tClass = new Prototype();

		// fix the type of classes

		tPerson.set(TYPE, tClass);
		tCar.set(TYPE, tClass);

		// fix the type of metaclass

		tClass.set(TYPE, tClass);

		tPerson.set("print()", new Method() {
			@Override
			public Object call(Prototype self) {
				System.out.println(String.format("age of %s is %s", self.get(TYPE_NAME), self.get("age")));
				return null;
			}
		});

		hector.call("print()");
		jean.call("print()");
		toyota.call("print()");

	}

}
