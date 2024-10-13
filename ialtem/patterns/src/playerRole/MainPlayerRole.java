package playerRole;

/**
 * @author Vincent Englebert
 */

import playerRole.roles.Bachelor;
import playerRole.roles.Master;
import playerRole.roles.Worker;

public class MainPlayerRole {

	public static void main(String[] args) {

		Player player = new Player();

		player.addRole(Master.class, new Object[] { "Security", "Software engineering" });
		player.addRole(Bachelor.class, new Object[] { "Programming", "Operating Systems", "Database" });
		player.addRole(Worker.class, new Object[] { "456-585454745-11", 21, "Namur" });

		Worker worker;

		worker = (Worker) player.getRole(Worker.class);

		System.out.printf("IDcard of John is %s\n", worker.getIDCard());
		System.out.printf("Age of John is %s\n", worker.getAge());
		System.out.printf("City of John is %s\n", worker.getCity());

		player.removeRole(Worker.class);

		worker = (Worker) player.getRole(Worker.class);

		assert worker == null;

		System.out.printf("City of John is %s\n", worker.getCity()); // should  throw  an exception !

	}

}
