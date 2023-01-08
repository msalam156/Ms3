package com.nissan.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nissan.model.AssetMaster;
import com.nissan.repo.IAssetMasterRepo;

@Service
public class AssetMasterServiceImpl implements IAssetMasterService {
	
	@Autowired
	IAssetMasterRepo assetMasterRepo;

	//View All AssetMaster
	@Override
	public List<AssetMaster> viewAllAssetMasters()
	{
		return assetMasterRepo.findAll();
	}

	//View AssetMaster By assetMasterID
	@Override
	public Optional<AssetMaster> viewAssetMasterByID(int assetMasterID)
	{
		return assetMasterRepo.findById(assetMasterID);
	}

	//Insert AssetMaster
	@Override
	public AssetMaster insertAssetMaster(AssetMaster assetMaster)
	{
		return assetMasterRepo.save(assetMaster);
	}

	//Update AssetMaster
	@Override
	public AssetMaster updateAssetMaster(AssetMaster assetMaster)
	{
		return assetMasterRepo.save(assetMaster);
	}

	//Delete AssetMaster By assetMasterID
	@Override
	public void deleteAssetMaster(int assetMasterID)
	{
		assetMasterRepo.deleteById(assetMasterID);
	}

	

}
