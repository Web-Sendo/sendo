package com.sendo.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Category", uniqueConstraints = {
		@UniqueConstraint(name = "Category_PK", columnNames = { "Category_ID" }) })
public class Category {

	@Id
	@GeneratedValue
	@Column(name = "Category_ID", nullable = false, length = 6)
	private String categoryID;

	@Column(name = "Category_Name", nullable = false, length = 25)
	private String categoryName;

	@Column(name = "Description", nullable = true, length = 70)
	private String description;

	@OneToMany(mappedBy = "categoryID", cascade = CascadeType.ALL)
	private Set<Product> product;

	public String getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(String categoryID) {
		this.categoryID = categoryID;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Product> getProduct() {
		return product;
	}

	public void setProduct(Set<Product> product) {
		this.product = product;
	}
}
