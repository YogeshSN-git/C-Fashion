package com.example.fashion.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fashion.Model.FashionItem;
import com.example.fashion.Service.FashionService;
import com.example.fashion.Service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	FashionService fashionService;

	@Autowired
	UserService userService;

	@GetMapping("/all")
	public List<FashionItem> getAdimnItems(@RequestHeader("Authorization") final String token) {
		return fashionService.getAdimnItems();
	}

	@PostMapping("/additem")
	public ResponseEntity<?> addItem(@RequestHeader("Authorization") final String token,@RequestBody FashionItem fashionItem) {
		fashionService.addItem(fashionItem);
		log.info("Item added");
		return ResponseEntity.ok().body("Item added");
	}

	@DeleteMapping("/deleteitem/{fashionItemId}")
	public ResponseEntity<?> deleteItem(@RequestHeader("Authorization") final String token,@PathVariable(value = "fashionItemId") Integer fashionItemId) {
		fashionService.deleteItem(fashionItemId);
		log.info("Item deleted");
		return ResponseEntity.ok().body("Item deleted");
	}

}
