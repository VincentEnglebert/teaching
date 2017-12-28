package configuration.pattern;

import java.util.HashMap;
import java.util.Map;

/**
 * This class is the main construct of the pattern. It acts as a template class
 * (
 * 
 * @author UNamur
 *
 */
public abstract class Configuration {
	protected final Map<String, ConfigElement> components = new HashMap<>();

	/**
	 * Add a component to the configuration.
	 * 
	 * @param key
	 *            the unique name given to the configuration.
	 * @param component
	 *            the component.
	 * @throws BadPreCondition
	 */
	public final void addComponent(String key, ConfigElement component) throws BadPreCondition {
		if (key == null || key.equals("") || component == null || components.containsKey(key)) {
			throw new BadPreCondition();
		}
		if (components.containsValue(component)) {
			throw new BadPreCondition();
		}
		components.put(key, component);
	}

	public final void replaceComponent(String key, ConfigElement component) throws BadPreCondition {
		if (key == null || key.equals("") || component == null || !components.containsKey(key)) {
			throw new BadPreCondition();
		}
		if (components.containsValue(component) && components.get(key) != component) {
			throw new BadPreCondition();
		}

		components.remove(key);
		components.put(key, component);
	}

	/**
	 * This method calls the 'configure' method of all component specified in
	 * the route. Usually, all the added components should match the route but
	 * this is not checked.
	 * 
	 * @param route
	 *            provides the order to configure the architecture. Example: [
	 *            l1, l2, l3] will configure l1, next l2, et finally l3.
	 * @throws BadPreCondition
	 *             if the configure method of a component throws itself this
	 *             exception or if the precondition of this method is not
	 *             respected (incorrect route for instance).
	 * 
	 */
	public final void configure(String[] route) throws BadPreCondition {
		if (route == null) {
			throw new BadPreCondition();
		}
		boolean ok = true;
		assembly();
		try {
			for (String key : route) {
				if (components.containsKey(key)) {
					components.get(key).configure();
				} else {
					ok = false;
					throw new BadPreCondition();
				}
			}
		} catch (BadPreCondition e) {
			ok = false;
			for (String key : components.keySet()) {
				components.get(key).reset();
			}
		}
		if (!ok) {
			throw new BadPreCondition();
		}
	}

	/**
	 * Assemble all components into a consistent structure.
	 */
	abstract protected void assembly();

}
