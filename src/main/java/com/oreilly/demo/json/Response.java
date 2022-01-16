package com.oreilly.demo.json;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class 	Response{

	@JsonProperty("results")
	private List<Result> results;

	@JsonProperty("status")
	private String status;

	public void setResults(List<Result> results){
		this.results = results;
	}

	public List<Result> getResults(){
		return results;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"results = '" + results + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}