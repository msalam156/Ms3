package com.nissan.service;

import java.util.List;
import java.util.Optional;

import com.nissan.model.AssetType;
import com.nissan.model.Vendor;
import com.nissan.model.VendorType;

public interface IVendorService {

	
	public List<Vendor> viewAllVendors();
	
	public List<VendorType> viewAllVendorTypes();
	
	public List<AssetType> viewAllAssetTypes();
	
	public Optional<Vendor> viewVendorById(int vendorId);
	
	public Vendor insertVendor(Vendor vendor);
	
	public Vendor updateVendor(Vendor vendor);
	
	public void deleteVendor(int vendorId);
}
