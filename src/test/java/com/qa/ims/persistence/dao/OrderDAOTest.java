package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;

public class OrderDAOTest {

	private final OrderDAO DAO = new OrderDAO(new ItemDAO());
	private Order testOrder;

	@BeforeClass
	public static void init() {
		DBUtils.connect("root", "bible");
	}

	@Before
	public void setup() {
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
		List<Item> items = new ArrayList<>();
		List<Double> total = new ArrayList<>();
		items.add(new Item(4L, "guitar", 305.90, 5));
		total.add(305.90);
		testOrder = new Order(5L, 5L, "2020-09-16", items, total);
	}

	@Test
	public void testCreate() {
		final Order created = new Order(5L, 5L, "2020-09-16");
		assertEquals(created, DAO.create(created));
	}

	@Test
	public void testReadAll() {
		List<Order> expected = new ArrayList<>();
		expected.add(testOrder);
		assertEquals(expected, DAO.readAll());
	}

	@Test
	public void testReadLatest() {
		assertEquals(testOrder, DAO.readLatest());
	}

	@Test
	public void testReadOrder() {
		final long ID = 1L;
		assertEquals(new Order(ID, 5L, "2020-09-14"), DAO.readOrder(ID));
	}

	@Test
	public void testUpdateAdd() {
		final long ORDERID = 6L;
		final long ITEMID = 7L;
		final Order updated = new Order(6L, 2L, "2020-09-16");
		assertEquals(updated, DAO.updateAdd(ORDERID, ITEMID));

	}

	@Test
	public void testDelete() {
		assertEquals(1, DAO.delete(4));
	}
}
