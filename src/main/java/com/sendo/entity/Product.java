package com.sendo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Product", uniqueConstraints = { @UniqueConstraint(name = "Product_PK", columnNames = { "Product_ID" }) })
public class Product {

	@Id
	@GeneratedValue
	@Column(name = "Product_ID", nullable = false, length = 6)
	private String productID;

	@ManyToOne
	@JoinColumn(name = "Category_ID")
	private Category categoryID;

	@ManyToOne
	@JoinColumn(name = "DisCode_ID")
	private DiscountCode disCode_ID;

	@ManyToOne
	@JoinColumn(name = "Supplier_ID" )
	private Supplier supplier_ID;

	@Column(name = "Product_Name", nullable = false, length = 50)
	private String productName;

	@Column(name = "Unit_Price", nullable = true)
	private int unitPrice;

	@Column(name = "Unit_In_Stock", nullable = true)
	private int unitInStock;

	@Column(name = "Description", nullable = true, length = 70)
	private String description;

	@Column(name = "Stock", nullable = true)
	private int stock;

	@Column(name = "Condition", nullable = true)
	private boolean condition;

	@Column(name = "Product_Image", nullable = true, length = 50)
	private String productImage;

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public Category getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(Category categoryID) {
		this.categoryID = categoryID;
	}

	public DiscountCode getDisCode_ID() {
		return disCode_ID;
	}

	public void setDisCode_ID(DiscountCode disCode_ID) {
		this.disCode_ID = disCode_ID;
	}

	public Supplier getSupplier_ID() {
		return supplier_ID;
	}

	public void setSupplier_ID(Supplier supplier_ID) {
		this.supplier_ID = supplier_ID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getUnitInStock() {
		return unitInStock;
	}

	public void setUnitInStock(int unitInStock) {
		this.unitInStock = unitInStock;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public boolean isCondition() {
		return condition;
	}

	public void setCondition(boolean condition) {
		this.condition = condition;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
}
