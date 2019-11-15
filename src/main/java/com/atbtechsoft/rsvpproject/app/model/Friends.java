package com.atbtechsoft.rsvpproject.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Friends {
	@Column(name="name")
	   private String name;
		@Id
		@Column(name="phoneNumber")
	   private String phoneNumber;
		
		@Column(name=("decision"))
	   private String decision;
		
	 public void setName(String name) {
			this.name = name;
	}
	   
	 public String getName() {
		return name;
	   }

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setDecision(String decision) {
		this.decision = decision;
	}

	public String getDecision() {
		return decision;
	}
}
