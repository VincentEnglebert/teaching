package prototype.version2;

import java.util.HashMap;

/**
 * @author Vincent Englebert
 */
public class Prototype {	
	private HashMap<String, Object> attributes=new HashMap<String, Object>();
	
	public Prototype(){
		
	}
	
	@SuppressWarnings("unchecked")
	private Prototype(HashMap<String, Object> gene){
		attributes=(HashMap<String, Object>)gene.clone();
	}
	
	/**
	 * Set attributed named 'name' to 'value'
	 * @param name not null
	 * @param value any value not null
	 * @return this
	 */
	public Prototype set(String name,Object value){
		assert name!=null;
		assert "".equals(name)==false;
		assert value!=null;
		
		attributes.put(name, value);
		return this;
	}
	

	/**
	 * 
	 * @param name
	 * @return the value of attribute 'name' and null is it doesn't exist
	 */
	public Object get(String name){
		assert name!=null;
		assert "".equals(name)==false;

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

	
	/**
	 * Call a method named 'method' 
	 * @param method (not null)
	 */
	public Object call(String method)  {
		assert method!=null;

		Prototype type = (Prototype)(this.get(MainApp2.TYPE));
		Method xmethod=(Method)type.get(method);
		if (xmethod==null){
			System.err.printf("No method named: %s\nfor object (%s)\nof class (%s) \n",method,this.toString(),type.get(MainApp2.TYPE_NAME));
			return null;
		} else {
			return xmethod.call(this);

		}
	}

}
