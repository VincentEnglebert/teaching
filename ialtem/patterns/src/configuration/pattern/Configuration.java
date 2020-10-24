package configuration.pattern;

import java.util.HashMap;
import java.util.Map;

/**
 * This class is the main construct of the pattern. It acts as a template class
 * (
 * 
 * @author V. Englebert
 *
 */
public abstract class Configuration {
	protected final Map<String, ConfigElement> components = new HashMap<>();

	/**
	 * Add a component to the configuration.
	 * 
	 * @param key       the unique name given to the configuration.
	 * @param component the component.
	 * @throws BadPreCondition
	 */
	public final void addComponent(String key, ConfigElement component) throws BadPreCondition {
		if (key == null) {
			throw new BadPreCondition("key is null");
		}
		if (key.equals("")) {
			throw new BadPreCondition("Key is empty");
		}
		if (component == null) {
			throw new BadPreCondition("Component is null");
		}
		if (components.containsKey(key)) {
			throw new BadPreCondition("Key is already defined");
		}
		if (components.containsValue(component)) {
			throw new BadPreCondition("Component used twice");
		}
		components.put(key, component);
	}

	public final void replaceComponent(String key, ConfigElement component) throws BadPreCondition {
		if (key == null) {
			throw new BadPreCondition("key is null");
		}
		if (key.equals("")) {
			throw new BadPreCondition("Key is empty");
		}
		if (component == null) {
			throw new BadPreCondition("Component is null");
		}
		if (!components.containsKey(key)) {
			throw new BadPreCondition("Key must be defined");
		}
		if (components.containsValue(component) && components.get(key) != component) {
			throw new BadPreCondition("Component defined twice");
		}
		components.remove(key);
		components.put(key, component);
	}

	/**
	 * This method calls the 'configure' method of all component specified in the
	 * route. Usually, all the added components should match the route but this is
	 * not checked.
	 * 
	 * @param route provides the order to configure the architecture. Example: [ l1,
	 *              l2, l3] will configure l1, next l2, et finally l3.
	 * @throws BadPreCondition if the configure method of a component throws itself
	 *                         this exception or if the precondition of this method
	 *                         is not respected (incorrect route for instance).
	 * 
	 */
	public final void configure(String[] route) throws BadPreCondition {
		if (route == null) {
			throw new BadPreCondition("Route is null");
		}
		for (String key : route) {
			if (!components.containsKey(key)) {
				throw new BadPreCondition("Component " + key + " is not registered");
			}
		}
		
		// ok, preconditions are OK.
		
		boolean passed = true;
		
		// assemble all components together
		
		assembly();
		
		try {
			for (String key : route) {
				assert components.get(key)!=null;				
				components.get(key).setup();
			}
		} catch (BadPreCondition e) {
			passed = false;
			for (String key : route) {
				assert components.get(key)!=null;				
				components.get(key).reset();
			}
			throw new BadPreCondition("A problem occured during the configuration. All components have been reset");
		}

		assert passed;
		
		// components can be turned On

		for (String key : route) {
			assert components.get(key)!=null;				
			components.get(key).turnOn();
		}

		// components are ready		
	}

	/**
	 * This method calls the 'configure' method of all component.
	 * 
	 * @throws BadPreCondition if the configure method of a component throws itself
	 *                         this exception or if the precondition of this method
	 *                         is not respected.
	 * 
	 */
	
	public final void configure() throws BadPreCondition {		
		// assemble all components together
		
		assembly();
		
		boolean passed = true;
		try {
			for (ConfigElement component: components.values()) {
				component.setup();
			}
		} catch (BadPreCondition e) {
			passed = false;
			for (ConfigElement component: components.values()) {
				component.reset();
			}
			throw new BadPreCondition("A problem occured during the configuration. All components have been reset");
		}

		assert passed;
		
		// components can be turned On

		for (ConfigElement component: components.values()) {
			component.turnOn();
		}

		// components are ready		
	}


	
	/**
	 * Assemble all components into a consistent structure.
	 */
	abstract protected void assembly();

}
