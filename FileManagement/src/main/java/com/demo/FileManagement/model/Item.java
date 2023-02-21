package com.demo.FileManagement.model;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Table(name = "items")
@Data
public class Item {
  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  private String id;

  private String type;
  
  private String name;
  
  @OneToOne
  @JoinColumn(name = "permission_group_id", referencedColumnName = "id")
  private PermissionGroup permissionGroup;
  
  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "parent_id", referencedColumnName = "id")
  private Item parentItem;

  
}
