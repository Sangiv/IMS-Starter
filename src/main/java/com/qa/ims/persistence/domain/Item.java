package com.qa.ims.persistence.domain;

public class Item {

	private Long item_id;
	private String title;
	private double price;
	private int stock;

	public Item(String title, double price, int stock) {
		this.title = title;
		this.price = price;
		this.stock = stock;
	}

	public Item(Long item_id, String title, double price, int stock) {
		this.item_id = item_id;
		this.title = title;
		this.price = price;
		this.stock = stock;
	}

	public Item(Long item_id, String title, double price) {
		this.item_id = item_id;
		this.title = title;
		this.price = price;
	}

	public Item(Long item_id) {
		this.item_id = item_id;
	}

	public Long getId() {
		return item_id;
	}

	public void setId(Long item_id) {
		this.item_id = item_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "item_id:" + item_id + "  title:" + title + "  price:" + price + "  stock:" + stock;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (item_id == null) {
			if (other.item_id != null)
				return false;
		} else if (!item_id.equals(other.item_id))
			return false;
//		if (price == null) {
//			if (other.price != null)
//				return false;
//		} else if (!price.equals(other.price))
//			return false;
//		if (stock == null) {
//			if (other.stock != null)
//				return false;
//		} else if (!stock.equals(other.stock))
//			return false;
		return true;
	}

}
