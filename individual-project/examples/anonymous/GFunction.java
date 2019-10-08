package anonymous;

/**
 * 
 * Allow to use objects as functions.
 * 
 * @author Vincent
 * 
 */
interface GFunction<T> {
	T call(T arg);
}