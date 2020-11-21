package com.fashion.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fashion.Model.FashionItem;
import com.fashion.Model.MessageResponse;
import com.fashion.Service.FashionService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	FashionService fashionService;

	@GetMapping("/all")
	public List<FashionItem> getAdimnItems() {
		return fashionService.getAdimnItems();
	}

	@PostMapping("/additem")
	public ResponseEntity<?> addItem(@RequestBody FashionItem fashionItem) {
		fashionService.addItem(fashionItem);
		return ResponseEntity.ok().body(new MessageResponse("Item added"));
	}

	@DeleteMapping("/deleteitem/{fashionItemId}")
	public ResponseEntity<?> deleteItem(@PathVariable(value = "fashionItemId") Integer fashionItemId) {
		fashionService.deleteItem(fashionItemId);
		return ResponseEntity.ok().body(new MessageResponse("Item deleted"));
	}

}
