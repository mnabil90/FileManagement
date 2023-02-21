package com.demo.FileManagement.graphql.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.demo.FileManagement.graphql.service.FileDBService;
import com.demo.FileManagement.model.FileDB;

@Component
public class FileDBQuery implements GraphQLQueryResolver {

    @Autowired
    private FileDBService fileDBService;

    public FileDB getFileInfo(final String id) {
        return this.fileDBService.getFileInfo(id);
    }
}