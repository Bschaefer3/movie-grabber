package com.omdb;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Generated;

/**
 * The type Ratings item.
 */
@Generated("com.robohorse.robopojogenerator")
public class RatingsItem{

	@JsonProperty("Value")
	private String value;

	@JsonProperty("Source")
	private String source;

	/**
	 * Set value.
	 *
	 * @param value the value
	 */
	public void setValue(String value){
		this.value = value;
	}

	/**
	 * Get value string.
	 *
	 * @return the string
	 */
	public String getValue(){
		return value;
	}

	/**
	 * Set source.
	 *
	 * @param source the source
	 */
	public void setSource(String source){
		this.source = source;
	}

	/**
	 * Get source string.
	 *
	 * @return the string
	 */
	public String getSource(){
		return source;
	}

	@Override
 	public String toString(){
		return 
			"RatingsItem{" + 
			"value = '" + value + '\'' + 
			",source = '" + source + '\'' + 
			"}";
		}
}