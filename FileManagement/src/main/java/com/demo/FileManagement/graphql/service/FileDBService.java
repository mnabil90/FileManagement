package com.demo.FileManagement.graphql.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.demo.FileManagement.model.FileDB;
import com.demo.FileManagement.repository.FileDBRepository;

@Service
public class FileDBService {

    private final FileDBRepository fileDBRepository ;

    public FileDBService(final FileDBRepository fileDBRepository) {
        this.fileDBRepository = fileDBRepository ;
    }


    @Transactional
    public Optional<FileDB> findById(final String id) {
        return this.fileDBRepository.findById(id);
    }
    
    @Transactional
    public FileDB getFileInfo(final String id) {
    	Optional<FileDB> f = this.fileDBRepository.getFileInfo(id);
        return f.isPresent() ? f.get() : null;
    }
    
}