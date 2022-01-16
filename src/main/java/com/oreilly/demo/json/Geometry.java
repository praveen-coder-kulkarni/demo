package com.oreilly.demo.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Geometry{

	@JsonProperty("location")
	private Location location;

	public void setLocation(Location location){
		this.location = location;
	}

	public Location getLocation(){
		return location;
	}

	@Override
 	public String toString(){
		return 
			"Geometry{" + 
			"location = '" + location + '\'' + 
			"}";
		}
}