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
@Table(name = "Supplier", uniqueConstraints = {
		@UniqueConstraint(name = "Supplier_PK", columnNames = { "Supplier_ID" }) })
public class Supplier {

	@Id
	@GeneratedValue
	@Column(name = "Supplier_ID", nullable = false, length = 6)
	private String supplierID;

	@Column(name = "Supplier_Name", nullable = false, length = 30)
	private String supplierName;

	@Column(name = "Address", nullable = true, length = 50)
	private String address;

	@OneToMany(mappedBy = "supplier_ID", cascade = CascadeType.ALL)
	private Set<Product> product;

	public String getSupplierID() {
		return supplierID;
	}

	public void setSupplierID(String supplierID) {
		this.supplierID = supplierID;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Set<Product> getProduct() {
		return product;
	}

	public void setProduct(Set<Product> product) {
		this.product = product;
	}
}
