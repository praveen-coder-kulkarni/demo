package com.oreilly.demo.json;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AstroResult{

	@JsonProperty("number")
	private int number;

	@JsonProperty("message")
	private String message;

	@JsonProperty("people")
	private List<Assignment> people;

	public void setNumber(int number){
		this.number = number;
	}

	public int getNumber(){
		return number;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setPeople(List<Assignment> people){
		this.people = people;
	}

	public List<Assignment> getPeople(){
		return people;
	}

	@Override
 	public String toString(){
		return 
			"AstroResult{" + 
			"number = '" + number + '\'' + 
			",message = '" + message + '\'' + 
			",people = '" + people + '\'' + 
			"}";
		}
}