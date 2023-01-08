package com.nissan.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nissan.model.PurchaseOrder;
import com.nissan.service.IPurchaseService;

@CrossOrigin
@RestController
@RequestMapping("api/")
public class PurchaseController {

	@Autowired
	IPurchaseService purchaseService;

	// List of all Purchase orders
	@GetMapping("purchase")
	public List<PurchaseOrder> viewAllPurchase() {
		return purchaseService.viewAllPurchaseOrder();
	}

	// Get purchase order by id
	@GetMapping("purchase/{purchaseOrderId}")
	PurchaseOrder viewPurchaseById(@PathVariable int purchaseOrderId) {
		return purchaseService.viewPurchaseOrderById(purchaseOrderId);
	}

	@PostMapping("purchase")
	ResponseEntity<PurchaseOrder> insertPurchaseOrder(@RequestBody PurchaseOrder purchase) {
		return new ResponseEntity<PurchaseOrder>(purchaseService.insertPurchaseOrder(purchase), HttpStatus.OK);
	}
	
	@PutMapping("purchase")
	ResponseEntity<PurchaseOrder> updatePurchaseOrder(@RequestBody PurchaseOrder purchase) {
		return new ResponseEntity<PurchaseOrder>(purchaseService.updatePurchaseOrder(purchase), HttpStatus.OK);
	}
}
