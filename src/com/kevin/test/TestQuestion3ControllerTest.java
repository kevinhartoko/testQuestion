package com.kevin.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

import com.kevin.controller.TestQuestion3Controller;
import com.kevin.model.CartModel;
import com.kevin.model.UserModel;

public class TestQuestion3ControllerTest {
	TestQuestion3Controller controller = new TestQuestion3Controller();
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	@Test
	public void isMoreThan2Years_expected_true() {
		String stringDate = "20/12/2016"; 
		Date date = new Date();
		try {
			date = sdf.parse(stringDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(true, controller.isMoreThan2Years(date));
	}
	
	@Test
	public void isMoreThan2Years_expected_false() {
		String stringDate = "20/12/2018"; 
		Date date = new Date();
		try {
			date = sdf.parse(stringDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(false, controller.isMoreThan2Years(date));
	}
	
	@Test
	public void calculate_expected_use_30() {
		UserModel user = new UserModel();
		CartModel cart = new CartModel();
		user.setEmployee(true);
		user.setAffiliate(true);
		try {
			user.setJoinDate(sdf.parse("20/12/2012"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cart.setGroceries(500);
		cart.setNonGroceries(1000);
		assertEquals((double)1140, controller.calculateTotal(user, cart));
	}
	
	@Test
	public void calculate_expected_use_10() {
		UserModel user = new UserModel();
		CartModel cart = new CartModel();
		user.setEmployee(false);
		user.setAffiliate(true);
		try {
			user.setJoinDate(sdf.parse("20/12/2012"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cart.setGroceries(500);
		cart.setNonGroceries(1000);
		assertEquals((double)1330, controller.calculateTotal(user, cart));
	}
	
	@Test
	public void calculate_expected_use_5() {
		UserModel user = new UserModel();
		CartModel cart = new CartModel();
		user.setEmployee(false);
		user.setAffiliate(false);
		try {
			user.setJoinDate(sdf.parse("20/12/2012"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cart.setGroceries(500);
		cart.setNonGroceries(1000);
		assertEquals((double)1380, controller.calculateTotal(user, cart));
	}
	
	@Test
	public void calculate_expected_use_0() {
		UserModel user = new UserModel();
		CartModel cart = new CartModel();
		user.setEmployee(false);
		user.setAffiliate(false);
		try {
			user.setJoinDate(sdf.parse("20/12/2018"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cart.setGroceries(500);
		cart.setNonGroceries(1000);
		assertEquals((double)1425, controller.calculateTotal(user, cart));
	}
}
