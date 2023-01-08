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

import com.nissan.model.AssetMaster;
import com.nissan.model.AssetType;
import com.nissan.model.Vendor;
import com.nissan.model.VendorType;
import com.nissan.service.IAssetMasterService;
import com.nissan.service.IVendorService;

@CrossOrigin		//helps to avoid CORS error
@RestController
@RequestMapping("api/")
public class AssetMasterController {

	//field DI Injection
	@Autowired
	IAssetMasterService assetMasterService;
	
	//List all AssetMaster
	@GetMapping("assetMasters")
	public List<AssetMaster> findAllAssetMaster(){
			return assetMasterService.viewAllAssetMasters();
	}
	
	
	//View AssetMaster By assetMasterID
	@GetMapping("assetMaster/{assetMasterID}")
	public Optional<AssetMaster> findAssetMasterByID(@PathVariable int assetMasterID){
		return assetMasterService.viewAssetMasterByID(assetMasterID);
	}
	
	//Inserting AssetMaster
	@PostMapping("assetMaster")
	public ResponseEntity<AssetMaster> insertAssetMaster(@RequestBody AssetMaster assetMaster){
		System.out.println("Inserting a record");
		return new ResponseEntity<AssetMaster> (assetMasterService.insertAssetMaster(assetMaster),HttpStatus.OK);
	}
	
	//Updating AssetMaster
	@PutMapping("assetMaster")
	public AssetMaster updateAssetMaster(@RequestBody AssetMaster assetMaster) {
		System.out.println("Updating a record");
		return assetMasterService.updateAssetMaster(assetMaster);
		}
	
	//Removing AssetMaster
	@DeleteMapping("assetMaster/{assetMasterID}")
	public void deleteAssetMaster(@PathVariable int assetMasterID) {
		assetMasterService.deleteAssetMaster(assetMasterID);
	}	
	
}
