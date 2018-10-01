package com.prs.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.prs.business.purchaserequest.PurchaseRequest;
import com.prs.business.purchaserequest.PurchaseRequestRepository;

@Controller
@RequestMapping("/PurchaseRequests")
public class PurchaseRequestController {

	@Autowired
	private PurchaseRequestRepository purchaseRequestRepository;

	@GetMapping("/List")
	public @ResponseBody Iterable<PurchaseRequest> getAllProducts() {
		Iterable<PurchaseRequest> PurchaseRequests = purchaseRequestRepository.findAll();
		return PurchaseRequests;
	}

	@GetMapping("/Get")
	public @ResponseBody Optional<PurchaseRequest> getPurchaseRequest(@RequestParam int id) {
		Optional<PurchaseRequest> PurchaseRequest = purchaseRequestRepository.findById(id);
		return PurchaseRequest;
	}

	@PostMapping("/Add")
	public @ResponseBody PurchaseRequest addPurchaseRequest(@RequestBody PurchaseRequest purchaseRequest) {
		return purchaseRequestRepository.save(purchaseRequest);
	}

	@PostMapping("/Change")
	public @ResponseBody PurchaseRequest updatePurchaseRequest(@RequestBody PurchaseRequest purchaseRequest) {
		return purchaseRequestRepository.save(purchaseRequest);
	}

	@PostMapping("/Remove")
	public @ResponseBody String removePurchaseRequest(@RequestBody PurchaseRequest purchaseRequest) {
		purchaseRequestRepository.delete(purchaseRequest);
		return "purchase request deleted";
	}

}
