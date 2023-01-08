package com.nissan.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.nissan.model.VendorType;

@Repository
public interface IVendorTypeRepo extends JpaRepositoryImplementation<VendorType, Integer> {

}
