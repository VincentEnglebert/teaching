package playerRole;

/**
 * @author Vincent Englebert
 */

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

public class Player {
	Set<AbstractRole> roles = new HashSet<>();

	public Player() {
	}

	public AbstractRole addRole(Class<?> role, Object... objects) {
		AbstractRole result = null;
		try {
			result = (AbstractRole) Class.forName(role.getName()).getDeclaredConstructor().newInstance();
		} catch (SecurityException | InstantiationException | IllegalAccessException | ClassNotFoundException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}
		result.configure(objects);
		roles.add(result);
		return result;
	}

	public void removeRole(Class<?> role) {
		assert role != null;

		roles.removeIf(new Predicate<AbstractRole>() {

			@Override
			public boolean test(AbstractRole t) {
				return t.getClass().equals(role);
			}

		});

	}

	public AbstractRole getRole(Class<?> role) {
		assert role != null;

		for (AbstractRole r : roles) {
			if (r.getClass().equals(role)) {
				return r;
			}
		}
		return null;
	}
}
