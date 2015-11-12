/**
 * 
 */
package com.likkhoServices.dao;

/**
 * @author mohkhan
 *
 */
public class Predicate {

	private String name;
	private String value;
	
	public Predicate(){
		
	}
	
	/**
	 * @param name
	 * @param value
	 */
	public Predicate(String name, String value) {
		super();
		this.name = name;
		this.value = value;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
}
