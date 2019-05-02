package com.kevin.codingtest.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.kevin.codingtest.controller.CalculatePriceController;
import com.kevin.codingtest.model.CartModel;
import com.kevin.codingtest.model.UserModel;

public class CalculatePriceControllerTest {
	CalculatePriceController controller = new CalculatePriceController();
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Date lessThan2Years;
	private Date moreThan2Years;
	
	@Before
    public void initiateValue() {
		String lessThan2YearsString = "20/12/2018";
		String moreThan2YearsString = "20/12/2016";
		try {
			lessThan2Years = sdf.parse(lessThan2YearsString);
			moreThan2Years = sdf.parse(moreThan2YearsString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
    }
	
	@Test
	public void testIsMoreThan2YearsExpectedTrue() {
		assertEquals(true, controller.isMoreThan2Years(moreThan2Years));
	}
	
	@Test
	public void testIsMoreThan2YearsExpectedFalse() {
		assertEquals(false, controller.isMoreThan2Years(lessThan2Years));
	}
	
	@Test
	public void testCalculateExpectedUse30() {
		UserModel user = new UserModel();
		CartModel cart = new CartModel();
		user.setEmployee(true);
		user.setAffiliate(true);
		user.setJoinDate(moreThan2Years);
		cart.setGroceries(500);
		cart.setNonGroceries(1000);
		assertEquals((double)1140, controller.calculateTotal(user, cart));
	}
	
	@Test
	public void testCalculateExpectedEse10() {
		UserModel user = new UserModel();
		CartModel cart = new CartModel();
		user.setEmployee(false);
		user.setAffiliate(true);
		user.setJoinDate(moreThan2Years);
		cart.setGroceries(500);
		cart.setNonGroceries(1000);
		assertEquals((double)1330, controller.calculateTotal(user, cart));
	}
	
	@Test
	public void testCalculateExpectedUse5() {
		UserModel user = new UserModel();
		CartModel cart = new CartModel();
		user.setEmployee(false);
		user.setAffiliate(false);
		user.setJoinDate(moreThan2Years);
		cart.setGroceries(500);
		cart.setNonGroceries(1000);
		assertEquals((double)1380, controller.calculateTotal(user, cart));
	}
	
	@Test
	public void testCalculateExpectedUse0() {
		UserModel user = new UserModel();
		CartModel cart = new CartModel();
		user.setEmployee(false);
		user.setAffiliate(false);
		user.setJoinDate(lessThan2Years);
		cart.setGroceries(500);
		cart.setNonGroceries(1000);
		assertEquals((double)1425, controller.calculateTotal(user, cart));
	}
}
