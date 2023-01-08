package com.nissan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nissan.model.PurchaseOrder;
import com.nissan.repo.IPurchaseRepo;

@Service
public class PurchaseServiceImp implements IPurchaseService {

	@Autowired
	IPurchaseRepo purchaseRepo;
	
	@Override
	public List<PurchaseOrder> viewAllPurchaseOrder() {
		return purchaseRepo.findAll();
	}

	@Override
	public PurchaseOrder viewPurchaseOrderById(int purchaseOrderId) {
		PurchaseOrder purchase_order = purchaseRepo.viewPurchaseOrderById(purchaseOrderId);
		return purchase_order;
	}

	@Override
	public PurchaseOrder insertPurchaseOrder(PurchaseOrder purchaseOrder) {
		return purchaseRepo.save(purchaseOrder);
	}

	@Override
	public PurchaseOrder updatePurchaseOrder(PurchaseOrder purchaseOrder) {
//		PurchaseOrder purchaseOrder
		return purchaseRepo.save(purchaseOrder);
	}

}
