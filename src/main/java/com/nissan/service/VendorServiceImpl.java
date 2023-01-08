package com.nissan.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nissan.model.AssetType;
import com.nissan.model.Vendor;
import com.nissan.model.VendorType;
import com.nissan.repo.IAssetTypeRepo;
import com.nissan.repo.IVendorRepo;
import com.nissan.repo.IVendorTypeRepo;

@Service
public class VendorServiceImpl implements IVendorService {
	
	@Autowired
	IVendorRepo vendorRepo;
	
	@Autowired
	IVendorTypeRepo vendorTypeRepo;
	
	@Autowired
	IAssetTypeRepo assetTypeRepo;

	@Override
	public List<Vendor> viewAllVendors() {
		return (List<Vendor>) vendorRepo.findAll();
	}
	
	@Override
	public List<VendorType> viewAllVendorTypes() {
		return (List<VendorType>) vendorTypeRepo.findAll();
	}

	@Override
	public List<AssetType> viewAllAssetTypes() {
		return (List<AssetType>) assetTypeRepo.findAll();
	}

	@Override
	public Optional<Vendor> viewVendorById(int vendorId) {
		return vendorRepo.findById(vendorId);
	}

	@Transactional
	@Override
	public Vendor insertVendor(Vendor vendor) {
		return vendorRepo.save(vendor);
	}

	@Override
	public Vendor updateVendor(Vendor vendor) {
		return vendorRepo.save(vendor);
	}

	@Override
	public void deleteVendor(int vendorId) {
		vendorRepo.deleteById(vendorId);
	}

	

}
