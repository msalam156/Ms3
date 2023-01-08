package com.nissan.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="VendorType")
public class VendorType {

	//Fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int vendortypeId;
	
	private String vendortypeName;
	
	@JsonIgnore
	@OneToMany(mappedBy="vendorType")
	private List<Vendor> vendors;

	//default constructor
	public VendorType() {
		super();
		// TODO Auto-generated constructor stub
	}

	//parameterized constructor
	public VendorType(int vendortypeId, String vendortypeName) {
		super();
		this.vendortypeId = vendortypeId;
		this.vendortypeName = vendortypeName;
	}

	//getters and setters
	public int getVendortypeId() {
		return vendortypeId;
	}

	public void setVendortypeId(int vendortypeId) {
		this.vendortypeId = vendortypeId;
	}

	public String getVendortypeName() {
		return vendortypeName;
	}

	public void setVendortypeName(String vendortypeName) {
		this.vendortypeName = vendortypeName;
	}

	public List<Vendor> getVendors() {
		return vendors;
	}

	public void setVendors(List<Vendor> vendors) {
		this.vendors = vendors;
	}

	//override toString
	@Override
	public String toString() {
		return "VendorType [vendortypeId=" + vendortypeId + ", vendortypeName=" + vendortypeName + ", vendors="
				+ vendors + "]";
  }
}
