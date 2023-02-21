package com.demo.FileManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.FileManagement.model.PermissionGroup;
import com.demo.FileManagement.service.PermissionGroupService;
import com.demo.FileManagement.util.ResponseMessage;

@RestController
@RequestMapping("permissiongroup")
public class PermissionGroupController {
	
	@Autowired
	PermissionGroupService permissionGroupService;
	
	@PostMapping("/save")
	public ResponseEntity<ResponseMessage> save(@RequestBody PermissionGroup group){
		ResponseMessage rw = permissionGroupService.save(group);
		return new ResponseEntity<ResponseMessage>(rw,HttpStatus.OK);
	}
	
	@GetMapping("/list")
	public ResponseEntity<ResponseMessage> findAll(){
		ResponseMessage rw = permissionGroupService.findAll();
		return new ResponseEntity<ResponseMessage>(rw,HttpStatus.OK);
	}
}
