package com.demo.FileManagement.graphql;
import java.util.Optional;

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
		Optional<FileDB> f = fileDBRepository.getFileInfo(id);
		return f.isPresent() ? f.get() : null;
	} 
}