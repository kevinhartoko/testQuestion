package com.kevin.codingtest.controller;

import java.util.Date;

import com.kevin.codingtest.model.CartModel;
import com.kevin.codingtest.model.UserModel;

public class CalculatePriceController {
	public double calculateTotal(UserModel user, CartModel cart) {
		double total;
		double discount;
		//untuk discount %
		if(user.isEmployee()) {
			discount = 30;
		}else if(user.isAffiliate()) {
			discount = 10;
		}else if(isMoreThan2Years(user.getJoinDate())) {
			discount = 5;
		}else {
			discount = 0;
		}
		total = cart.getGroceries() + cart.getNonGroceries() - (discount/100)*cart.getNonGroceries();
		//untuk discount 5$
		int discount5 = (int) total / 100;
		total = total - (discount5*5);
		
		return total;
	}
	
	public boolean isMoreThan2Years(Date date) {
		Date now = new Date();
		//dihitung 1 tahun 365 hari
		long time2Years = 2*365*24*60*60;
		if((now.getTime()-date.getTime())/1000>time2Years) {
			return true;
		}else {
			return false;
		}
	}
}
