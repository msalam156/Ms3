package com.nissan.model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "AssetMaster")
public class AssetMaster
{
	
	//Fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int assetMasterID;
	
	@Column(nullable = false, unique = true)
	private String model;
	
	@Column(nullable = false, unique = true)
	private String serialNumber;
	
	private String manufacturingYear;
	private LocalDateTime purchaseDate;
	private boolean hasWarranty;
	private LocalDateTime assetFrom;
	private LocalDateTime assetTo;
	
	//Join Column			AssetMaster.assetID = Asset.assetID
	@JoinColumn(name = "assetID")
	@ManyToOne
	private Asset asset;
	
	//Join Column			AssetMaster.vendorID = Vendor.vendorID
	@JoinColumn(name = "vendorID")
	@ManyToOne
	private Vendor vendor;

	//Default Constructor
	public AssetMaster()
	{
		super();
	}

	
	//Parameterized Constructor
	public AssetMaster(int assetMasterID, String model, String serialNumber, String manufacturingYear,
			LocalDateTime purchaseDate, boolean hasWarranty, LocalDateTime assetFrom, LocalDateTime assetTo,
			Asset asset, Vendor vendor)
	{
		super();
		this.assetMasterID = assetMasterID;
		this.model = model;
		this.serialNumber = serialNumber;
		this.manufacturingYear = manufacturingYear;
		this.purchaseDate = purchaseDate;
		this.hasWarranty = hasWarranty;
		this.assetFrom = assetFrom;
		this.assetTo = assetTo;
		this.asset = asset;
		this.vendor = vendor;
	}

	
	//Getters & Setters
	public int getAssetMasterID() {
		return assetMasterID;
	}

	public void setAssetMasterID(int assetMasterID) {
		this.assetMasterID = assetMasterID;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getManufacturingYear() {
		return manufacturingYear;
	}

	public void setManufacturingYear(String manufacturingYear) {
		this.manufacturingYear = manufacturingYear;
	}

	public LocalDateTime getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(LocalDateTime purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public boolean isHasWarranty() {
		return hasWarranty;
	}

	public void setHasWarranty(boolean hasWarranty) {
		this.hasWarranty = hasWarranty;
	}

	public LocalDateTime getAssetFrom() {
		return assetFrom;
	}

	public void setAssetFrom(LocalDateTime assetFrom) {
		this.assetFrom = assetFrom;
	}

	public LocalDateTime getAssetTo() {
		return assetTo;
	}

	public void setAssetTo(LocalDateTime assetTo) {
		this.assetTo = assetTo;
	}

	public Asset getAsset() {
		return asset;
	}

	public void setAsset(Asset asset) {
		this.asset = asset;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	
	//Override toString()
	@Override
	public String toString() {
		return String.format(
				"AssetMaster [assetMasterID=%s, model=%s, serialNumber=%s, manufacturingYear=%s, purchaseDate=%s, hasWarranty=%s, assetFrom=%s, assetTo=%s, asset=%s, vendor=%s]",
				assetMasterID, model, serialNumber, manufacturingYear, purchaseDate, hasWarranty, assetFrom, assetTo,
				asset, vendor);
	}
	
	
}
