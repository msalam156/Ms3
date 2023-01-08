package com.nissan.rest;

import java.util.List;

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

import com.nissan.model.Asset;
import com.nissan.model.AssetType;
import com.nissan.service.IAssetService;

@CrossOrigin                   //helps to avoid (cors) error
@RestController
@RequestMapping("api/")
public class AssetController {
	
	//field DI Injection
	@Autowired
	IAssetService assetService;
	
	  //List all assets
		@GetMapping("assets")
		public List<Asset> viewAllAssets() {
			return assetService.viewAllAssets();
		}
		
	  //List all assetTypes
		@GetMapping("assetTypes")
		public List<AssetType> viewAllAssetTypes() {
			return assetService.viewAllAssetTypes();
		}
		
		
	  	//get by assetID
		@GetMapping("assets/{assetID}")
		public Asset viewAsset(@PathVariable int assetID) 
        {
			return assetService.viewAsset(assetID);
		}
		
		//get by assetTypeId
		@GetMapping("assetType/{assetTypeId}")
		public AssetType viewAssetType(@PathVariable int assetTypeId) 
        {
			return assetService.viewAssetType(assetTypeId);
		}
		
			
		//add aaset
		@PostMapping("assets")
		public ResponseEntity<Asset> insertAsset(@RequestBody Asset asset){
			System.out.println("Inserting a record");
			return new ResponseEntity<Asset> (assetService.insertAsset(asset),HttpStatus.OK);
		}
		
		//update asset
		@PutMapping("assets")
		public Asset updateAsset(@RequestBody Asset asset){
			System.out.println("Updating a record");
			assetService.updateAsset(asset);
			return asset;
		}
			
		//delete asset
		@DeleteMapping("assets/{assetID}")
		public void deleteAsset(@PathVariable int assetID) {
			assetService.deleteAsset(assetID);;
			}
			
			
			

	
	
}
