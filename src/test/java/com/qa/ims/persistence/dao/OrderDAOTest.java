package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;

public class OrderDAOTest {

	private ItemDAO itemDAO;
	private final OrderDAO DAO = new OrderDAO(itemDAO);

	@BeforeClass
	public static void init() {
		DBUtils.connect("root", "bible");
	}

	@Before
	public void setup() {
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}

	@Test
	public void testCreate() {
		final Order created = new Order(7L, "Piano", 899.99, 3);
		assertEquals(created, DAO.create(created));
	}

	@Test
	public void testReadAll() {
		List<Order> expected = new ArrayList<>();
		expected.add(new Order(4L, "guitar", 305.90, 5));
		assertEquals(expected, DAO.readAll());
	}

	@Test
	public void testReadLatest() {
		assertEquals(new Order(4L, "guitar", 305.90, 5), DAO.readLatest());
	}

	@Test
	public void testRead() {
		final long ID = 4L;
		assertEquals(new Order(ID, "guitar", 305.90, 5), DAO.readItem(ID));
	}

	@Test
	public void testUpdate() {
		final Order updated = new Order(4L, "Piano", 899.99, 3);
		assertEquals(updated, DAO.update(updated));

	}

	@Test
	public void testDelete() {
		assertEquals(1, DAO.delete(4));
	}
}
