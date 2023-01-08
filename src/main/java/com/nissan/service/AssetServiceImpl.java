package com.nissan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nissan.model.Asset;
import com.nissan.model.AssetType;
import com.nissan.repo.IAssetRepo;
import com.nissan.repo.IAssetTypeRepo;

@Service
public class AssetServiceImpl implements IAssetService {
	
	//field injection
	@Autowired
	IAssetRepo assetRepo;
	
	@Autowired
	IAssetTypeRepo assetTypeRepo;


	//list all assets
	@Override
	public List<Asset> viewAllAssets() {
		 return (List<Asset>) assetRepo.findAll();

	}

	//list all assets by assetID
	@Override
	public Asset viewAsset(int assetID) {
		
		Asset _asset=assetRepo.viewAsset(assetID);
		if(assetID == _asset.getAssetID())
		{ 
			return _asset;
		}
		else
		{
			return null;
		}
	}

	//insert asset
	@Override
	public Asset insertAsset(Asset asset) {
		return assetRepo.save(asset);

	}

	//update asset
	@Override
	public Asset updateAsset(Asset asset) {
		return assetRepo.save(asset);

	}

	//delete asset
	@Override
	public void deleteAsset(int assetID) {
		assetRepo.deleteById(assetID);
	}

	//list all asset types
	@Override
	public List<AssetType> viewAllAssetTypes() {
		 return (List<AssetType>) assetTypeRepo.findAll();
	}

	//list all assettypes by assetTypeId
	@Override
	public AssetType viewAssetType(int assetTypeId) {
		
		AssetType _assetType=assetTypeRepo.viewAssetType(assetTypeId);
		if(assetTypeId == _assetType.getAssetTypeId())
		{ 
			return _assetType;
		}
		else
		{
			return null;
		}
	
	}

}
