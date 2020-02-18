package dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Employee {
	@JsonProperty
	String firstName;
	@JsonProperty
	String lastName;
	@JsonProperty
	String website;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}
}
