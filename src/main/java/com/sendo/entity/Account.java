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
@Table(name = "Account", uniqueConstraints = {
		@UniqueConstraint(name = "Account_PK", columnNames = { "Phone_Number" }) })
public class Account {

	@Id
	@GeneratedValue
	@Column(name = "Phone_Number", nullable = false, length = 20)
	private String phoneNumber;

	@Column(name = "Password", nullable = false, length = 20)
	private String password;

	@Column(name = "Last_Name", nullable = true, length = 15)
	private String lastName;

	@Column(name = "Account_type", nullable = true)
	private boolean accountType;

	@OneToMany(mappedBy = "phoneNumber", cascade = CascadeType.ALL)
	private Set<Customer> customer;

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean isAccountType() {
		return accountType;
	}

	public void setAccountType(boolean accountType) {
		this.accountType = accountType;
	}

	public Set<Customer> getCustomer() {
		return customer;
	}

	public void setCustomer(Set<Customer> customer) {
		this.customer = customer;
	}

}
