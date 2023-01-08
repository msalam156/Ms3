package com.nissan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Asset")
public class Asset {
	
	//fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int assetID;
	
	@Column(nullable=false)
	private String assetName;
	
	private boolean ishardware;
	
	private int assetTypeId;
	
	@JoinColumn(name="assetTypeId",insertable=false,updatable=false)   
	@ManyToOne
	private AssetType assetType;
	
    //default constructor
	public Asset() {
		
	}
	
	//parametrized constructor
	public Asset(int assetID, String assetName, boolean ishardware, int assetTypeId, AssetType assetType) {
		super();
		this.assetID = assetID;
		this.assetName = assetName;
		this.ishardware = ishardware;
		this.assetTypeId = assetTypeId;
		this.assetType = assetType;
	}

	//getters and setters
	public int getAssetID() {
		return assetID;
	}

	public void setAssetID(int assetID) {
		this.assetID = assetID;
	}

	public String getAssetName() {
		return assetName;
	}

	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}

	public boolean isIshardware() {
		return ishardware;
	}

	public void setIshardware(boolean ishardware) {
		this.ishardware = ishardware;
	}

	public int getAssetTypeId() {
		return assetTypeId;
	}

	public void setAssetTypeId(int assetTypeId) {
		this.assetTypeId = assetTypeId;
	}

	public AssetType getAssetType() {
		return assetType;
	}

	public void setAssetType(AssetType assetType) {
		this.assetType = assetType;
	}

	//overide tostring
	@Override
	public String toString() {
		return "Asset [assetID=" + assetID + ", assetName=" + assetName + ", ishardware=" + ishardware
				+ ", assetTypeId=" + assetTypeId + ", assetType=" + assetType + "]";
	}
	
	
	
}
