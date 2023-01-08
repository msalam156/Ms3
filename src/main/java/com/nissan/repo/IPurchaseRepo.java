package com.nissan.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.nissan.model.PurchaseOrder;

@Repository
public interface IPurchaseRepo extends JpaRepositoryImplementation<PurchaseOrder, Integer> {
	@Query("from PurchaseOrder where purchaseOrderId=?1")
	public PurchaseOrder viewPurchaseOrderById(int purchaseOrderId);
}
