package com.demo.FileManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.FileManagement.model.FileDB;
import com.demo.FileManagement.model.Item;


@Repository
public interface ItemRepository extends JpaRepository<Item, String> {

}
