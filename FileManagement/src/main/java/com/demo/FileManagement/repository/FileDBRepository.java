package com.demo.FileManagement.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.FileManagement.model.FileDB;


@Repository
@Transactional
public interface FileDBRepository extends JpaRepository<FileDB, String> {

	
	@Query("SELECT f FROM FileDB f WHERE f.id=:id")
	Optional<FileDB> getFileInfo(@Param(value = "id") String id);

}
