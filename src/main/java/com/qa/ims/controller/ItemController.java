package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.Utils;

/**
 * Takes in item details for CRUD functionality
 *
 */
public class ItemController implements CrudController<Item> {

	public static final Logger LOGGER = LogManager.getLogger();

	private ItemDAO itemDAO;
	private Utils utils;

	public ItemController(ItemDAO itemDAO, Utils utils) {
		super();
		this.itemDAO = itemDAO;
		this.utils = utils;
	}

	/**
	 * Reads all items to the logger
	 */
	@Override
	public List<Item> readAll() {
		List<Item> items = itemDAO.readAll();
		for (Item item : items) {
			LOGGER.info(item.toString());
			LOGGER.info("");
		}
		return items;
	}

	/**
	 * Creates an item by taking in user input
	 */
	@Override
	public Item create() {
		LOGGER.info("Please enter title");
		String title = utils.getString();
		LOGGER.info("Please enter price");
		double price = utils.getDouble();
		LOGGER.info("Please enter stock");
		int stock = utils.getInteger();
		Item item = itemDAO.create(new Item(title, price, stock));
		LOGGER.info("Item created");
		return item;
	}

	/**
	 * Updates an existing item by taking in user input
	 */
	@Override
	public Item update() {
		LOGGER.info("Please enter the id of the item you would like to update");
		Long item_id = utils.getLong();
		LOGGER.info("Please enter a title");
		String title = utils.getString();
		LOGGER.info("Please enter a price");
		double price = utils.getDouble();
		LOGGER.info("Please enter stock");
		int stock = utils.getInteger();
		Item item = itemDAO.update(new Item(item_id, title, price, stock));
		LOGGER.info("Item Updated");
		return item;
	}

	/**
	 * Deletes an existing item by the id of the item
	 * 
	 * @return
	 */
	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the item you would like to delete");
		Long item_id = utils.getLong();
		LOGGER.info("item Deleted");
		return itemDAO.delete(item_id);
	}
}