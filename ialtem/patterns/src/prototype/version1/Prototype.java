package prototype.version1;

import java.util.HashMap;



public class Prototype {
	
	private final HashMap<String, Object> attributes;
	
	public Prototype(){
		attributes=new HashMap<String, Object>();		
	}
	
	@SuppressWarnings("unchecked")
	private Prototype(HashMap<String, Object> gene){
		assert gene!=null;
		
		attributes=(HashMap<String, Object>)gene.clone();
	}
	
	/**
	 * Set attributed named 'name' to 'value'
	 * @param name not null
	 * @param value any value
	 * @return this
	 */
	public Prototype set(String name,Object value){
		assert name!=null;
		
		attributes.put(name, value);
		return this;
	}
	
	/**
	 * 
	 * @param name
	 * @return the value of attribute 'name' and null is it doesn't exist
	 */
	public Object get(String name){
		return attributes.get(name);
	}
	
	/**
	 * 
	 * @return a fresh copy of this
	 */
	public Prototype clone(){
		Prototype result=new Prototype(attributes);
		return result;
	}
	
	@Override
	public String toString() {
		StringBuffer buf=new StringBuffer();
		buf.append(String.format("#%-11d:== ", this.hashCode()));
		for (String n: attributes.keySet()){
			Object value = attributes.get(n);
			if (value instanceof Prototype){
				buf.append(String.format("%s:#%d / ", n,  value.hashCode()));
			} else {
				buf.append(String.format("%s:%s / ", n,  value.toString()));				
			}
		}
		return buf.toString();
	}



}
