package com.kafka.api.model;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "user_id", "browser_name" })
@Entity
public class Data {

	@JsonProperty("user_id")
	private int userId;
	@JsonProperty("browser_name")
	private String browserName;
	
	
	
	 public Data() {
		
	}

	public Data(int userId, String browserName) {
		super();
		this.userId = userId;
		this.browserName = browserName;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("user_id")
	public int getUserId() {
		return userId;
	}

	@JsonProperty("user_id")
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@JsonProperty("browser_name")
	public String getBrowserName() {
		return browserName;
	}

	@JsonProperty("browser_name")
	public void setBrowserName(String browserName) {
		this.browserName = browserName;
	}


	@Override
	public String toString() {
		return "Data [userId=" + userId + ", browserName=" + browserName + "]";
	}

	
}
