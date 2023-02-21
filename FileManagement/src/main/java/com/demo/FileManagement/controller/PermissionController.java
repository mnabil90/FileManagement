package com.demo.FileManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.FileManagement.model.Permission;
import com.demo.FileManagement.model.PermissionGroup;
import com.demo.FileManagement.service.PermissionService;
import com.demo.FileManagement.util.ResponseMessage;

@RestController
@RequestMapping("permission")
public class PermissionController {

	@Autowired
	PermissionService permissionService;
	
	@PostMapping("/save")
	public ResponseEntity<ResponseMessage> save(@RequestBody Permission permission){
		ResponseMessage rw = permissionService.save(permission);
		return new ResponseEntity<ResponseMessage>(rw,HttpStatus.OK);
	}
	
	@GetMapping("/list")
	public ResponseEntity<ResponseMessage> findAll(){
		ResponseMessage rw = permissionService.findAll();
		return new ResponseEntity<ResponseMessage>(rw,HttpStatus.OK);
	}
}
