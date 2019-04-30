package com.kevin.testQuestion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.temporal.JulianFields;
import java.util.Date;
import java.util.Scanner;

import com.kevin.controller.TestQuestion3Controller;
import com.kevin.model.CartModel;
import com.kevin.model.UserModel;

public class TestQuestion3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		UserModel user = new UserModel();
		CartModel cart = new CartModel();
		TestQuestion3Controller controller = new TestQuestion3Controller();
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Employee (Y/N)?");
		String employeeString = scanner.nextLine();
		if(employeeString.equalsIgnoreCase("y")) {
			user.setEmployee(true);
		}else {
			user.setEmployee(false);
		}
		System.out.print("Affiliate of the store (Y/N)?");
		String affString = scanner.nextLine();
		if(affString.equalsIgnoreCase("y")) {
			user.setAffiliate(true);
		}else {
			user.setAffiliate(false);
		}
		
		Date date = null;
		do {
			try {
				System.out.print("Join Date (dd/MM/yyyy)?");
				String dateString = scanner.nextLine();
				date = simpleDateFormat.parse(dateString);
				user.setJoinDate(date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} while (date==null);
		
		Double groceries = null;
		do {
			try {
				System.out.print("Groceries price?");
				String groceriesString = scanner.nextLine();
				groceries = Double.parseDouble(groceriesString);
				cart.setGroceries(groceries);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} while (groceries==null);
		
		Double nonGroceries = null;
		do {
			try {
				System.out.print("Non Groceries price?");
				String nonGroceriesString = scanner.nextLine();
				nonGroceries = Double.parseDouble(nonGroceriesString);
				cart.setNonGroceries(nonGroceries);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} while (nonGroceries==null);
		
		Double totalPrice = controller.calculateTotal(user, cart);
		System.out.print("Total price : "+totalPrice);
	}

}
