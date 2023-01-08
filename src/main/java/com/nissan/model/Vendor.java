package com.nissan.model;

import java.util.Date;

import java.util.List;

import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Vendor")
public class Vendor {

	//Fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int vendorId;
	
	@Column(nullable=false)
	private String vendorName;
	private Date validFrom;
	private Date validTo;
	private String address;

	@JoinColumn(name ="vendortypeId" ,insertable=false,updatable=false)
	@ManyToOne
	private VendorType vendorType;
	
	@JoinColumn(name ="assetTypeId" ,insertable=false,updatable=false)
	@ManyToOne
	private AssetType assetType;
	
	//For One Vendor Many AssetMaster
	@JsonIgnore
	@OneToMany(mappedBy = "asset", cascade = CascadeType.ALL)
	private List<AssetMaster> assetMaster;

	//Default Constructor
	public Vendor()
	{
		super();
	}

	//Parameterized Constructor
	public Vendor(int vendorId, String vendorName, Date validFrom, Date validTo, String address, VendorType vendorType, AssetType assetType, List<AssetMaster> assetMaster) {

		super();
		this.vendorId = vendorId;
		this.vendorName = vendorName;
		this.validFrom = validFrom;
		this.validTo = validTo;
		this.address = address;
		this.vendorType = vendorType;
		this.assetType = assetType;
		this.assetMaster = assetMaster;
	}


	//Getters & Setters
	public List<AssetMaster> getAssetMaster() {
		return assetMaster;
	}

	public void setAssetMaster(List<AssetMaster> assetMaster) {
		this.assetMaster = assetMaster;

	}

	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public Date getValidFrom() {
		return validFrom;
	}

	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	public Date getValidTo() {
		return validTo;
	}

	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	public VendorType getVendorType() {
		return vendorType;
	}

	public void setVendorType(VendorType vendorType) {
		this.vendorType = vendorType;
	}

	public AssetType getAssetType() {
		return assetType;
	}

	public void setAssetType(AssetType assetType) {
		this.assetType = assetType;
	}

	@Override
	public String toString() {
		return String.format(
				"Vendor [vendorId=%s, vendorName=%s, validFrom=%s, validTo=%s, address=%s, vendorType=%s, assetType=%s, assetMaster=%s]",
				vendorId, vendorName, validFrom, validTo, address, vendorType, assetType,
				assetMaster);

	}

}
