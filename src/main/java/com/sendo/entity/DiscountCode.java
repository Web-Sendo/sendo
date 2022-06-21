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
@Table(name = "Discount_Code", uniqueConstraints = {
		@UniqueConstraint(name = "DisCountCode_PK", columnNames = { "DisCode_ID" }) })
public class DiscountCode {

	@Id
	@GeneratedValue
	@Column(name = "DisCode_ID", nullable = false, length = 6)
	private String disCodeID;

	@Column(name = "Value", nullable = true)
	private int value;

	@OneToMany(mappedBy = "disCode_ID", cascade = CascadeType.ALL)
	private Set<Product> product;

	public String getDisCodeID() {
		return disCodeID;
	}

	public void setDisCodeID(String disCodeID) {
		this.disCodeID = disCodeID;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Set<Product> getProduct() {
		return product;
	}

	public void setProduct(Set<Product> product) {
		this.product = product;
	}
}
