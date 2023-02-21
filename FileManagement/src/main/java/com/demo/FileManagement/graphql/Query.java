package com.demo.FileManagement.graphql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.demo.FileManagement.model.FileDB;
import com.demo.FileManagement.repository.FileDBRepository;

import lombok.AllArgsConstructor;



@Component
@AllArgsConstructor
public class Query implements GraphQLQueryResolver {

	@Autowired
	FileDBRepository fileDBRepository;
	

	public FileDB findFileInfoGraphQL(String id) {
		return fileDBRepository.getFileInfo(id);
	} 
}