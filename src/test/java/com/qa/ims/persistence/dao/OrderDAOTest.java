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
		items.add(new Item(3L, "obamaboe", 305.90, 5));
		total.add(305.90);
		testOrder = new Order(3L, 1L, "2020-09-14", items, total);
	}

	@Test
	public void testCreate() {
		final Order created = new Order(4L, 1L, "2020-09-16", new ArrayList<Item>(), new ArrayList<Double>());
		assertEquals(created, DAO.create(created));
	}

	@Test
	public void testReadAll() {
		List<Order> expected = new ArrayList<>();
		List<Item> items1 = new ArrayList<>();
		items1.add(new Item(1L, "guitar", 305.90, 5));
		items1.add(new Item(2L, "saxomophone", 305.90, 5));
		List<Double> total1 = new ArrayList<>();
		total1.add(611.80);
		expected.add(new Order(1L, 3L, "2020-09-14", items1, total1));

		List<Item> items2 = new ArrayList<>();
		items2.add(new Item(3L, "obamaboe", 305.90, 5));
		items2.add(new Item(1L, "guitar", 305.90, 5));
		List<Double> total2 = new ArrayList<>();
		total2.add(611.80);
		expected.add(new Order(2L, 2L, "2020-09-14", items2, total2));
		expected.add(testOrder);
		assertEquals(expected, DAO.readAll());
	}

	@Test
	public void testReadLatest() {
		assertEquals(testOrder, DAO.readLatest());
	}

	@Test
	public void testReadOrder() {
		final long ID = 3L;
		assertEquals(testOrder, DAO.readOrder(ID));
	}

	@Test
	public void testReadTotal() {
		List<Double> total = new ArrayList<>();
		total.add(305.90D);
		assertEquals(total, DAO.readTotal(3L));
	}

	@Test
	public void testReadItems() {
		assertEquals(testOrder.getItems(), DAO.readItems(3L));
	}

	@Test
	public void testUpdateAdd() {
		final long ORDERID = 1L;
		final long ITEMID = 1L;
		List<Item> items = new ArrayList<>();
		items.add(new Item(1L, "guitar", 305.90, 5));
		items.add(new Item(2L, "saxomophone", 305.90, 5));
		items.add(new Item(1L, "guitar", 305.90, 5));
		List<Double> total = new ArrayList<>();
		total.add(917.70);
		final Order updated = new Order(1L, 3L, "2020-09-16", items, total);
		assertEquals(updated, DAO.updateAdd(ORDERID, ITEMID));

	}

	@Test
	public void testUpdateRemove() {
		final long ORDERID = 1L;
		final long ITEMID = 1L;
		List<Item> items = new ArrayList<>();
		items.add(new Item(2L, "saxomophone", 305.90, 5));
		List<Double> total = new ArrayList<>();
		total.add(305.90);
		final Order updated = new Order(1L, 3L, "2020-09-16", items, total);
		assertEquals(updated, DAO.updateRemove(ORDERID, ITEMID));

	}

	@Test
	public void testDelete() {
		assertEquals(1, DAO.delete(1));
	}
}
