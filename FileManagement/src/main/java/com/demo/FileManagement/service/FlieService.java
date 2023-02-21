package com.demo.FileManagement.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.demo.FileManagement.model.FileDB;
import com.demo.FileManagement.model.Item;
import com.demo.FileManagement.model.Permission;
import com.demo.FileManagement.repository.FileDBRepository;
import com.demo.FileManagement.util.ResponseMessage;

@Service
public class FlieService {

	@Autowired
	FileDBRepository fileDBRepository;

	@Autowired
	PermissionService permissionService;

	@Autowired
	ItemService itemService;

	public ResponseMessage uploadFile(MultipartFile file, String itemId, String userEmail) {
		ResponseMessage rm = new ResponseMessage();
		Item item = itemService.findById(itemId);
		List<Permission> list =permissionService.findPermissionByUserEmail(userEmail);
		if(list.size() == 0) {
			rm.setSuccess(false);
			rm.setMessage("No Privilage");
		}
		boolean isAllowed  = checkUserActionOnFile(item,userEmail,"UPLOAD");
		if(isAllowed) {
			FileDB uploadfile = new FileDB();
			uploadfile.setItem(item);
			try {
				uploadfile.setData(file.getBytes());
				uploadfile.setFileName(file.getOriginalFilename());
				uploadfile.setFileSize(file.getSize());
			} catch (IOException e) {
				rm.setSuccess(false);
				rm.setMessage("Couldn't upload File due to error => " + e.getMessage());
			}
			fileDBRepository.save(uploadfile);
			rm.setSuccess(true);	
			rm.setMessage("File was Added to " + item.getName());
		}else {
			rm.setSuccess(isAllowed);
			rm.setMessage("Not Authorized Action");
		}
		return rm;
	}

	public FileDB getFile(String id,String userEmail) {
		Optional<FileDB> f = fileDBRepository.findById(id);
		FileDB file  = f.isPresent() ? f.get() : null;
		boolean isAllowed  = checkUserActionOnFile(file.getItem(),userEmail,"DOWNLOAD");
		if(file != null && isAllowed) {
			return file;
		}else {
			return null;
		}
	}

	public ResponseMessage getFileInfo(String id,String userEmail) {
		ResponseMessage rm = new ResponseMessage();
		FileDB file  =fileDBRepository.getFileInfo(id);
		boolean isAllowed  = checkUserActionOnFile(file.getItem(),userEmail,"FILE_INFO");
		if(isAllowed) {
			rm.setSuccess(true);
			rm.setMessage("File Info Found");
			rm.setData(file);
		}else {
			rm.setSuccess(false);
			rm.setMessage("Not Authorized to view Item Info");
		}
		return rm;
	}

	private boolean checkUserActionOnFile(Item item, String userEmail,String actionType) {
		boolean isAllowed = false;
		List<Permission>  itemPermissionsList = item.getPermissionGroup().getPermissions();
		List<Permission> list =permissionService.findPermissionByUserEmail(userEmail);
		for(Permission permission : list) {
			for(Permission itemPermission : itemPermissionsList) {
				if(permission.getId().equals(itemPermission.getId())) {
					if((actionType.equals("DOWNLOAD") || actionType.equals("UPLOAD")) && permission.getPermissionLevel().equals("EDIT")) {
						isAllowed = true;
						break;
					}
					else if(actionType.equals("FILE_INFO") && permission.getPermissionLevel().equals("VIEW")) {
						isAllowed = true;
						break;
					}
				}
			}
		}
		return isAllowed;
	}
}