package com.oreilly.demo.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Assignment {

	@JsonProperty("craft")
	private String craft;

	@JsonProperty("name")
	private String name;

	public void setCraft(String craft){
		this.craft = craft;
	}

	public String getCraft(){
		return craft;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	@Override
 	public String toString(){
		return 
			"Assignment{" +
			"craft = '" + craft + '\'' + 
			",name = '" + name + '\'' + 
			"}";
		}
}