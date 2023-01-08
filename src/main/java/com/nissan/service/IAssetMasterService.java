package com.nissan.service;

import java.util.List;
import java.util.Optional;

import com.nissan.model.AssetMaster;

public interface IAssetMasterService {

	//List All AssetMaster
	List<AssetMaster> viewAllAssetMasters();

	//Find AssetMaster By assetMasterID
	Optional<AssetMaster> viewAssetMasterByID(int assetMasterID);

	//Insert AssertMaster
	AssetMaster insertAssetMaster(AssetMaster assetMaster);

	//Update AssetMaster
	AssetMaster updateAssetMaster(AssetMaster assetMaster);

	//Delete AssetMaster By assetMasterID
	void deleteAssetMaster(int assetMasterID);

}
