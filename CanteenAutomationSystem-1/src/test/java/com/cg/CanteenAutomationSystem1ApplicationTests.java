package com.cg;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.dao.OrderJPARepository;
import com.cg.dao.ProductsJPARepository;
import com.cg.dao.ProductsOrderJPARepository;
import com.cg.model.Order;
import com.cg.model.Products;
import com.cg.model.ProductsOrder;

/*
 * it is referring for spring boot application
 */
@SpringBootTest
class CanteenAutomationSystem1ApplicationTests { 
	/*
	 * Spring @Autowired annotation is used for automatic injection of beans and Setter methods.
	 */

	@Autowired
	public OrderJPARepository repository;
	@Autowired
	public ProductsOrderJPARepository repository1;
	@Autowired
	public ProductsJPARepository repository2;
	@Test
	void contextLoads() {
	}
	@Test
	public void testUpdateProducts()
	{
		Products products=repository2.findById(9016).get();
		products.setProductsCost(20.00);
		repository2.save(products);
		assertEquals(20.00,repository2.findById(9016).get().getProductsCost());
	}
	@Test
	public void testViewOrder()
	{
		List<Order> list=repository.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
	@Test
	public void testUpdateOrder()
	{
		Order cust=repository.findById(41).get();
		cust.setOrderType("Veg");
		repository.save(cust);
		assertEquals("Veg",repository.findById(41).get().getOrderType());
	}
	
	
	@Test
	public void testViewProductsOrder()
	{
		List<ProductsOrder> list=repository1.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
	@Test
	public void testUpdateProductsOrder()
	{
		ProductsOrder productsOrder=repository1.findById(42).get();
		productsOrder.setQuantity(6);
		repository1.save(productsOrder);
		assertEquals(9,repository1.findById(42).get().getQuantity());
	}
	@Test
	public void testViewProducts()
	{
		List<Products> list=repository2.findAll();
		assertThat(list).size().isGreaterThan(0);
	}

	
}