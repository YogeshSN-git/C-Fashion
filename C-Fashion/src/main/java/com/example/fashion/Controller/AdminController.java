package com.example.fashion.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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

	@GetMapping("")
	public List<FashionItem> getAdimnItems() {
		return fashionService.getAdimnItems();
	}

	@PostMapping("/additem")
	public ResponseEntity<?> addItem(@RequestBody FashionItem fashionItem) {
		fashionService.addItem(fashionItem);
		log.info("Item added");
		return ResponseEntity.ok().body("Item added");
	}

	@DeleteMapping("/deleteitem/{fashionItemId}")
	public ResponseEntity<?> deleteItem(@PathVariable(value = "fashionItemId") Integer fashionItemId) {
		fashionService.deleteItem(fashionItemId);
		log.info("Item deleted");
		return ResponseEntity.ok().body("Item deleted");
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<?> handleEmptyResultDataAccessExceptions(EmptyResultDataAccessException ex) {

		log.error("Item does not exist");
		return ResponseEntity.badRequest().body("Item does not exist");
	}

}
