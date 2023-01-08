package com.nissan.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.nissan.model.Vendor;

@Repository
public interface IVendorRepo extends JpaRepositoryImplementation<Vendor, Integer> {

	
	
}
