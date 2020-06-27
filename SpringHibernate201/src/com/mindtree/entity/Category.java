package com.mindtree.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Category")
public class Category 
{
	@Id
	@Column(name="Category_Id")
	private int categoryId;
	
	@Column(name="Category_Description")
	private String catgoryDescription;
	
	public Category()
	{
		
	}

	public int getCategoryId() 
	{
		return categoryId;
	}

	public void setCategoryId(int categoryId) 
	{
		this.categoryId = categoryId;
	}

	public String getCatgoryDescription() 
	{
		return catgoryDescription;
	}

	public void setCatgoryDescription(String catgoryDescription) 
	{
		this.catgoryDescription = catgoryDescription;
	}
}
