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
@Table(name = "Cart", uniqueConstraints = { @UniqueConstraint(name = "Cart_PK", columnNames = { "Cart_ID" }) })
public class Cart {

	@Id
	@GeneratedValue
	@Column(name = "Cart_ID", length = 6, nullable = false)
	private String cartID;

	@ManyToOne
	@JoinColumn(name = "Order_ID")
	private Order orderID;

	@ManyToOne
	@JoinColumn(name = "Product_ID")
	private Product productID;

	@Column(name = "Total_Price", nullable = true)
	private int totalPrice;

	@Column(name = "Quantity", nullable = true)
	private short quantity;

	public String getCartID() {
		return cartID;
	}

	public void setCartID(String cartID) {
		this.cartID = cartID;
	}

	public Order getOrderID() {
		return orderID;
	}

	public void setOrderID(Order orderID) {
		this.orderID = orderID;
	}

	public Product getProductID() {
		return productID;
	}

	public void setProductID(Product productID) {
		this.productID = productID;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public short getQuantity() {
		return quantity;
	}

	public void setQuantity(short quantity) {
		this.quantity = quantity;
	}
}
