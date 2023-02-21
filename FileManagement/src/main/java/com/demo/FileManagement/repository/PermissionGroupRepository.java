package com.demo.FileManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.FileManagement.model.FileDB;
import com.demo.FileManagement.model.Item;
import com.demo.FileManagement.model.PermissionGroup;


@Repository
public interface PermissionGroupRepository extends JpaRepository<PermissionGroup, String> {

}
