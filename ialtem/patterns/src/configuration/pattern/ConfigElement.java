package configuration.pattern;

public interface ConfigElement {
	/**
	 * Configure the component
	 * 
	 * @throws BadPreCondition
	 *             if a condition is not respected. In this case, the state of
	 *             the component is preserved.
	 */
	void configure() throws BadPreCondition;

	/**
	 * Re-initialize the component to its original state.
	 */
	void reset();

}
