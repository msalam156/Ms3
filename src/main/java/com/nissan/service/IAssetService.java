package com.nissan.service;

import java.util.List;

import com.nissan.model.Asset;
import com.nissan.model.AssetType;


public interface IAssetService {
	
	    //find all assests
		List<Asset> viewAllAssets();
		
		//find by assetId
		public Asset viewAsset(int assetID);

		//insert Assetdef
		Asset insertAsset(Asset asset);
		
		//update Assetdef
		Asset updateAsset(Asset asset);
		
		//delete Assetdef
		void  deleteAsset(int assetID);

	    //list all AssetTypes
		List<AssetType> viewAllAssetTypes();
		
		//find by assetTypeId
		public AssetType viewAssetType(int assetTypeId);


}
