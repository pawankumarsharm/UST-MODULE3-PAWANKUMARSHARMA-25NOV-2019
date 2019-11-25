package com.ust_global.mobileapp;

import java.util.Scanner;

public class Mobile {

	static int value;
	public static void main(String[] args) {


		Display();
	}

	public static void Display()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Press 1 to Show all contacts");
		System.out.println("Press 2 to Search for contact(using name)");
		System.out.println("Press 3 to Operate on contact");
		System.out.println("Press 4 to End");
		value = sc.nextInt();
		if(value==1)
		{
			MobileAppCRUD.getAllContact();
			Display();
		}else if(value == 2)
		{
			MobileAppCRUD.getAllContact();
			System.out.println("Press 1 to call");
			System.out.println("Press 2 to message");
			System.out.println("Press 3 to go back to main menu");
			Scanner sc1 = new Scanner(System.in);
			int value2 = sc1.nextInt();
			switch (value2) {
			case 1:
				Scanner sc11 = new Scanner(System.in);
				System.out.println("Select the name of contact you want to call");
				String name = sc11.next();
				
				MobileAppCRUD.call(name);
				
				
				break;
			case 2:
				Scanner sc12 = new Scanner(System.in);
				System.out.println("Select the name of contact you want to message");
				String name1 = sc12.next();
				
				
				MobileAppCRUD.message(name1);
				break;
			case 3:
				Display();
				break;

			default:
				System.out.println("Invalid key");
				break;
			}
			Display();
		}else if(value == 3)
		{
			System.out.println("Press 1 to add contact");
			System.out.println("Press 2 to delete contact");
			System.out.println("Press 3 to edit contact");
			Scanner sc2 = new Scanner(System.in);

			int value3 = sc2.nextInt();
			switch (value3) {
			case 1:
				Scanner sc21 = new Scanner(System.in);
				System.out.println("Enter name : ");
				String name = sc21.nextLine();
				System.out.println("Enter number : ");
				long number = sc21.nextInt();
				System.out.println("Enter group : ");
				String group = sc21.next();
				
				MobileAppCRUD.addContact(name, number, group);
				
				break;
			case 2:
				
				Scanner sc22 = new Scanner(System.in);
				System.out.println("Enter the name of contact to delete");
				String name1 = sc22.next();
				
				MobileAppCRUD.deleteContact(name1);
				
				break;
			case 3:
				
				Scanner sc23 = new Scanner(System.in);
				System.out.println("Enter Name of contact you want to update : ");
				String newName = sc.next();
				System.out.println("Enter new Number : ");
				long newNumber = sc.nextInt();
				System.out.println("Enter new Group :");
				String newGroup = sc.next();
				
				MobileAppCRUD.updateContact(newName, newNumber, newGroup);
				
				
				
				break;

			default:
				System.out.println("Invalid key");
				break;
			}
			Display();

		}else if(value==4) {
			System.out.println("Thank you !!!!");
		}else {
			System.out.println("Invalid Key");
		}

	}
}
