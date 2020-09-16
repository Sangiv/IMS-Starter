package com.qa.ims.persistence.domain;

import java.util.List;

public class Order {

	private Long order_id;
	private Long customer_id;
	private String date_placed;
	private List<Item> items;
	private List<Double> total;

	public Order(Long order_id, Long customer_id, String date_placed, List<Item> items, List<Double> total) {
		super();
		this.order_id = order_id;
		this.customer_id = customer_id;
		this.date_placed = date_placed;
		this.items = items;
		this.total = total;
	}

	public Order(Long order_id, Long customer_id, String date_placed, List<Item> items) {
		super();
		this.order_id = order_id;
		this.customer_id = customer_id;
		this.date_placed = date_placed;
		this.items = items;
	}

	public Order(Long customer_id, String date_placed) {
		this.customer_id = customer_id;
		this.date_placed = date_placed;
	}

	public Order(Long order_id, Long customer_id, String date_placed) {
		this.order_id = order_id;
		this.customer_id = customer_id;
		this.date_placed = date_placed;
	}

	public Long getId() {
		return order_id;
	}

	public void setId(Long order_id) {
		this.order_id = order_id;
	}

	public Long getCustomerId() {
		return customer_id;
	}

	public void setCustomerId(Long customer_id) {
		this.customer_id = customer_id;
	}

	public String getDatePlaced() {
		return date_placed;
	}

	public void setDatePlaced(String date_placed) {
		this.date_placed = date_placed;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public List<Double> getTotal() {
		return total;
	}

	public void setTotal(List<Double> total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Order: [order_id=" + order_id + ", customer_id=" + customer_id + ", date_placed=" + date_placed + ","
				+ "\n" + "items: " + items + "," + "\n" + "total: " + total + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (customer_id == null) {
			if (other.customer_id != null)
				return false;
		} else if (!customer_id.equals(other.customer_id))
			return false;
		if (order_id == null) {
			if (other.order_id != null)
				return false;
		} else if (!order_id.equals(other.order_id))
			return false;
		return true;
	}

}
