package com.oreilly.demo.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Result {


	private String formattedAddress;

	@JsonProperty("geometry")
	private Geometry geometry;

	public void setFormattedAddress(String formattedAddress){
		this.formattedAddress = formattedAddress;
	}

	public String getFormattedAddress(){
		return formattedAddress;
	}

	public void setGeometry(Geometry geometry){
		this.geometry = geometry;
	}

	public Geometry getGeometry(){
		return geometry;
	}

	@Override
 	public String toString(){
		return 
			"Result{" +
			"formatted_address = '" + formattedAddress + '\'' + 
			",geometry = '" + geometry + '\'' + 
			"}";
		}
}