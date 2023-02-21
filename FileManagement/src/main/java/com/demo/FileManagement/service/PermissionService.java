package com.demo.FileManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.FileManagement.model.Permission;
import com.demo.FileManagement.repository.PermissionRepository;
import com.demo.FileManagement.util.ResponseMessage;

@Service
public class PermissionService {

	@Autowired
	PermissionRepository permissionRepository;

	public ResponseMessage save(Permission permission) {
		ResponseMessage response = new ResponseMessage();
		permission = permissionRepository.save(permission);
		response.setSuccess(true);
		response.setData(permission);
		return response;
	}

	public ResponseMessage findAll() {
		ResponseMessage response = new ResponseMessage();
		List<Permission> list = permissionRepository.findAll();
		response.setSuccess(true);
		response.setData(list);
		return response;
	}

	public List<Permission> findPermissionByUserEmail(String userEmail) {
		return permissionRepository.findByUserEmail(userEmail);
	}
	
}
