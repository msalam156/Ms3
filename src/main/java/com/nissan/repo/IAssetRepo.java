package com.nissan.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.nissan.model.Asset;

@Repository
public interface IAssetRepo extends JpaRepositoryImplementation<Asset, Integer> {
		
	@Query("from Asset where assetID=?1")
	public Asset viewAsset(int assetID);



}
