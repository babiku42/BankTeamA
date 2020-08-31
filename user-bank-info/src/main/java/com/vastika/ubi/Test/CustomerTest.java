package com.vastika.ubi.Test;

import java.util.Scanner;

import com.vastika.ubi.controller.CustomerController;

public class CustomerTest {

	public static void main(String[] args) {
		CustomerController controller = new CustomerController();
		Scanner input = new Scanner(System.in);
		String decision = "";

		do {

			System.out.println("which db operation do you want to perform? ");
			System.out.println("Press");
			System.out.println(
					"1 for opening account\n2 for Deposit \n3 for withdraw \n4 to showAll detail \n5 to show balance");
			System.out.println();
			System.out.println("Enter your choice");
			int choice = input.nextInt();
			switch (choice) {
			case 1:
				controller.openAccount(input);
				break;
			case 2:
				controller.deposit(input);
				break;
			case 3:
				controller.withdraw(input);;
				break;
			case 4:
				controller.showAll(input);
				break;
		
			default:
				System.out.println("wrong choice!!!");
				break;
			}

			System.out.println("do you want to continue?");
			decision = input.next();
		} while (decision.equalsIgnoreCase("yes"));

		System.out.println("bye, bye, bye!!!Thank you for using our service. See you next time.");

	}
}