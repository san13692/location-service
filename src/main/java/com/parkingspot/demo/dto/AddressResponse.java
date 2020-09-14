package com.parkingspot.demo.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddressResponse {
	
	public AddressResponse() {}
	@JsonProperty("items")
	private List<Locations> items;

	public List<Locations> getItems() {
		return items;
	}

	public void setItems(List<Locations> items) {
		this.items = items;
	}
}
