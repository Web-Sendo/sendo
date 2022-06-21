package com.sendo.entity;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "tblOrder", uniqueConstraints = { @UniqueConstraint(name = "Order_PK", columnNames = { "Order_ID" }) })
public class Order {

	@Id
	@GeneratedValue
	@Column(name = "Order_ID", length = 6, nullable = false)
	private String orderID;

	@Column(name = "Order_Date", nullable = true)
	private Timestamp orderDate;

	@Column(name = "Required_Date", nullable = true)
	private Timestamp requiredDate;

	@Column(name = "Ship_Name", length = 30, nullable = true)
	private String shipName;

	@Column(name = "Shipped_Date", nullable = true)
	private Timestamp shippedDate;

	@Column(name = "Ship_Address", length = 60, nullable = true)
	private String shipAddress;

	@Column(name = "Ship_City", length = 15, nullable = true)
	private String shipCity;

	@ManyToOne
	@JoinColumn(name = "Customer_ID")
	private Customer customerID;

	@ManyToOne
	@JoinColumn(name = "Payment_ID")
	private Payment paymentID;

	@ManyToOne
	@JoinColumn(name = "Shipper_ID")
	private Shipper shipperID;

	@OneToMany(mappedBy = "orderID", cascade = CascadeType.ALL)
	private Set<Cart> cart;

	public Set<Cart> getCart() {
		return cart;
	}

	public void setCart(Set<Cart> cart) {
		this.cart = cart;
	}

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public Timestamp getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}

	public Timestamp getRequiredDate() {
		return requiredDate;
	}

	public void setRequiredDate(Timestamp requiredDate) {
		this.requiredDate = requiredDate;
	}

	public String getShipName() {
		return shipName;
	}

	public void setShipName(String shipName) {
		this.shipName = shipName;
	}

	public Timestamp getShippedDate() {
		return shippedDate;
	}

	public void setShippedDate(Timestamp shippedDate) {
		this.shippedDate = shippedDate;
	}

	public String getShipAddress() {
		return shipAddress;
	}

	public void setShipAddress(String shipAddress) {
		this.shipAddress = shipAddress;
	}

	public String getShipCity() {
		return shipCity;
	}

	public void setShipCity(String shipCity) {
		this.shipCity = shipCity;
	}

	public Customer getCustomerID() {
		return customerID;
	}

	public void setCustomerID(Customer customerID) {
		this.customerID = customerID;
	}

	public Payment getPaymentID() {
		return paymentID;
	}

	public void setPaymentID(Payment paymentID) {
		this.paymentID = paymentID;
	}

	public Shipper getShipperID() {
		return shipperID;
	}

	public void setShipperID(Shipper shipperID) {
		this.shipperID = shipperID;
	}

}
