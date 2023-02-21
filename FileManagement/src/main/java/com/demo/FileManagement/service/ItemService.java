package com.demo.FileManagement.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.FileManagement.model.Item;
import com.demo.FileManagement.repository.ItemRepository;
import com.demo.FileManagement.util.ResponseMessage;

@Service
public class ItemService {

	@Autowired
	ItemRepository itemRepository;

	public ResponseMessage save(Item item) {
		ResponseMessage rw = new ResponseMessage();
		item = itemRepository.save(item);
		rw.setSuccess(true);
		rw.setData(item);
		return rw;
	}

	public ResponseMessage createSpace(Item item) {
		ResponseMessage rw = new ResponseMessage();
		if(item.getParentItem() != null) {
			rw.setSuccess(false);
			rw.setMessage("Item of Type Space shouldn't have Parent Folder");
			return rw;
		}
		item.setType("SPACE");
		return save(item);
	}
	
	public ResponseMessage createFolder(Item item) {
		ResponseMessage rw = new ResponseMessage();
		if(item.getParentItem() == null) {
			rw.setSuccess(false);
			rw.setMessage("Item of type Folder must have parent specified");
			return rw;
		}
		item.setType("FOLDER");
		return save(item);
	}

	public Item findById(String itemId) {
		Optional<Item> i =  itemRepository.findById(itemId);
		return i.isPresent() ? i.get() : null;
	}
}
