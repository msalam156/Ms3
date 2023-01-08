package com.nissan.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.nissan.model.AssetType;

@Repository
public interface IAssetTypeRepo extends JpaRepositoryImplementation<AssetType, Integer> {
	
	@Query("from AssetType where assetTypeId=?1")
	public AssetType viewAssetType(int assetTypeId);


}
