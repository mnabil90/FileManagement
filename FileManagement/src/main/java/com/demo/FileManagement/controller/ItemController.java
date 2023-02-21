package com.demo.FileManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.FileManagement.model.Item;
import com.demo.FileManagement.model.Permission;
import com.demo.FileManagement.service.ItemService;
import com.demo.FileManagement.util.ResponseMessage;

@RestController
@RequestMapping("item")
public class ItemController {

	@Autowired
	ItemService itemService;
	
	@PostMapping("/createSpace")
	public ResponseEntity<ResponseMessage> createSpace(@RequestBody Item item){
		ResponseMessage rw = itemService.createSpace(item);
		return new ResponseEntity<ResponseMessage>(rw,HttpStatus.OK);
	}
	
	@PostMapping("/createFolder")
	public ResponseEntity<ResponseMessage> createFolder(@RequestBody Item item){
		ResponseMessage rw = itemService.createFolder(item);
		return new ResponseEntity<ResponseMessage>(rw,HttpStatus.OK);
	}
}
