package com.qa.ims.persistence.domain;

public class Order {

	private Long order_id;
	private Long customer_id;
	private String date_placed;

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

	@Override
	public String toString() {
		return "order_id:" + order_id + " customer:" + customer_id + " date placed:" + date_placed;
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
