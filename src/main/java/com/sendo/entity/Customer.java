package com.sendo.entity;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Customer", uniqueConstraints = {
		@UniqueConstraint(name = "Customer_PK", columnNames = { "Customer_ID" }) })
public class Customer {

	@Id
	@GeneratedValue
	@Column(name = "Customer_ID", length = 6, nullable = false)
	private String customerID;

	@Column(name = "Customer_Name", length = 30, nullable = true)
	private String customerName;

	@Column(name = "Email", length = 30, nullable = true)
	private String email;

	@Column(name = "Gender", nullable = true)
	private boolean gender;

	@Column(name = "Birthday", nullable = true)
	private Timestamp birthDay;

	@OneToOne
	@JoinColumn(name = "Phone_Number")
	private Account phoneNumber;

	@OneToMany(mappedBy = "customerID", cascade = CascadeType.ALL)
	private Set<Order> Order;

	public Set<Order> getOrder() {
		return Order;
	}

	public void setOrder(Set<Order> Order) {
		this.Order = Order;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public Timestamp getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Timestamp birthDay) {
		this.birthDay = birthDay;
	}

	public Account getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Account phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
