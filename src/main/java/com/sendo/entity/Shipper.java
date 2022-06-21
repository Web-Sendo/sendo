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
@Table(name = "Shipper", uniqueConstraints = { @UniqueConstraint(name = "Shipper_PK", columnNames = { "Shipper_ID" }) })
public class Shipper {

	@Id
	@GeneratedValue
	@Column(name = "Shipper_ID", nullable = false, length = 6)
	private String shipperID;

	@Column(name = "Company", nullable = true, length = 30)
	private String company;

	@OneToMany(mappedBy = "shipperID", cascade = CascadeType.ALL)
	private Set<Order> Order;

	public String getShipperID() {
		return shipperID;
	}

	public void setShipperID(String shipperID) {
		this.shipperID = shipperID;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Set<Order> getOrder() {
		return Order;
	}

	public void setOrder(Set<Order> Order) {
		this.Order = Order;
	}

}
