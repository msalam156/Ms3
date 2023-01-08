package com.nissan.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nissan.model.AssetType;
import com.nissan.model.Vendor;
import com.nissan.model.VendorType;
import com.nissan.service.IVendorService;

@CrossOrigin		//helps to avoid CORS error
@RestController
@RequestMapping("api/")
public class VendorController {

	//field DI Injection
	@Autowired
	IVendorService vendorService;
	
	//List all vendors
	@GetMapping("vendors")
	public List<Vendor> findAllVendors(){
			return vendorService.viewAllVendors();
	}
	
	//List all vendor types
	@GetMapping("vendortypes")
	public List<VendorType> findAllVendorTypes(){
		return vendorService.viewAllVendorTypes();
	}
	
	//List all asset types
	@GetMapping("assettypes")
	public List<AssetType> findAllAssetTypes(){
		return vendorService.viewAllAssetTypes();
	}
	
	//View Vendor by vendorID
	@GetMapping("vendors/{vendorId}")
	public Optional<Vendor> findVendorById(@PathVariable int vendorId){
		return vendorService.viewVendorById(vendorId);
	}
	
	//Inserting Vendor
	@PostMapping("vendors")
	public ResponseEntity<Vendor> insertVendor(@RequestBody Vendor vendor){
		System.out.println("Inserting a record");
		//return new ResponseEntity<Vendor> (userDetailsService.save(user),HttpStatus.OK);
		return new ResponseEntity<Vendor> (vendorService.insertVendor(vendor),HttpStatus.OK);
	}
	
	//Updating Vendor
	@PutMapping("vendors")
	public Vendor updateVendor(@RequestBody Vendor vendor) {
		System.out.println("Updating a record");
		vendorService.updateVendor(vendor);
		return vendor;
		}
	
	//Removing vendor
	@DeleteMapping("vendors/{vendorId}")
	public void deleteVendor(@PathVariable int vendorId) {
		vendorService.deleteVendor(vendorId);
	}	
	
}
