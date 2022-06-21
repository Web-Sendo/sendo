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
@Table(name = "Payment", uniqueConstraints = { @UniqueConstraint(name = "Payment_PK", columnNames = { "Payment_ID" }) })
public class Payment {

	@Id
	@GeneratedValue
	@Column(name = "Payment_ID", length = 6, nullable = false)
	private String paymentID;

	@Column(name = "Amount", nullable = true)
	private int amount;

	@Column(name = "Method", nullable = true)
	private boolean method;

	@OneToMany(mappedBy = "paymentID", cascade = CascadeType.ALL)
	private Set<Order> Order;

	public String getPaymentID() {
		return paymentID;
	}

	public void setPaymentID(String paymentID) {
		this.paymentID = paymentID;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public boolean isMethod() {
		return method;
	}

	public void setMethod(boolean method) {
		this.method = method;
	}

	public Set<Order> getOrder() {
		return Order;
	}

	public void setOrder(Set<Order> Order) {
		this.Order = Order;
	}

}
