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
@Table(name = "PurchaseOrder")
public class PurchaseOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int purchaseOrderId;
	
	@Column(nullable = false, unique = true)
	private int orderNumber;

//	@JoinColumn(name = "assetTypeId", insertable=false, updatable=false)
//	@ManyToOne
//	private AssetType assetType;

	@JoinColumn(name = "assetId")
	@ManyToOne
	private Asset asset;

	@Column(nullable = false)
	private int quantity;

	@JoinColumn(name = "vendorId")
	@ManyToOne
	private Vendor vendor;

	private LocalDateTime orderDate;
	private LocalDateTime deliveryDate;

	@JoinColumn(name = "statusId")
	@ManyToOne
	private Status status;

	// Default constructor
	public PurchaseOrder() {
		super();
		// TODO Auto-generated constructor stub
	}

	// Parameterized constructor
	public PurchaseOrder(int purchaseOrderId, int orderNumber, Asset asset, int quantity,
			Vendor vendor, LocalDateTime orderDate, LocalDateTime deliveryDate, Status status) {
		super();
		this.purchaseOrderId = purchaseOrderId;
		this.orderNumber = orderNumber;
//		this.assetType = assetType;
		this.asset = asset;
		this.quantity = quantity;
		this.vendor = vendor;
		this.orderDate = orderDate;
		this.deliveryDate = deliveryDate;
		this.status = status;
	}

	// Getters and setters
	public int getPurchaseOrderId() {
		return purchaseOrderId;
	}

	public void setPurchaseOrderId(int purchaseOrderId) {
		this.purchaseOrderId = purchaseOrderId;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

//	public AssetType getAssetType() {
//		return assetType;
//	}
//
//	public void setAssetType(AssetType assetType) {
//		this.assetType = assetType;
//	}

	public Asset getAsset() {
		return asset;
	}

	public void setAsset(Asset asset) {
		this.asset = asset;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public LocalDateTime getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDateTime deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return String.format(
				"PurchaseOrder [purchaseOrderId=%s, orderNumber=%s, assetType=%s, asset=%s, quantity=%s, vendor=%s, orderDate=%s, deliveryDate=%s, status=%s]",
				purchaseOrderId, orderNumber, asset, quantity, vendor, orderDate, deliveryDate, status);
	}

}
