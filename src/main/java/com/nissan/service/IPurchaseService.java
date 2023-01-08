package com.nissan.service;

import java.util.List;

import com.nissan.model.PurchaseOrder;

public interface IPurchaseService {
	//View all purchase order
	List<PurchaseOrder> viewAllPurchaseOrder();
	
	//View purchase order by id
	PurchaseOrder viewPurchaseOrderById(int purchaseOrderId);
	
	//Insert purchase order
	PurchaseOrder insertPurchaseOrder(PurchaseOrder purchaseOrder);
	
	//Update purchase order
	PurchaseOrder updatePurchaseOrder(PurchaseOrder purchaseOrder);
}
