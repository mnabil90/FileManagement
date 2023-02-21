package com.demo.FileManagement.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.FileManagement.model.Permission;


@Repository
@Transactional
public interface PermissionRepository extends JpaRepository<Permission, String> {

	public List<Permission> findByUserEmail(String userEmail);
}
