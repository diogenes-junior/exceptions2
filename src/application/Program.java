package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter account data");
		System.out.print("Number: ");
		int number = input.nextInt();
		input.nextLine();
		System.out.print("Holder: ");
		String name = input.nextLine();
		System.out.print("Initial balance: ");
		double initialBalance = input.nextDouble();
		System.out.print("Withdraw limit: ");
		double withdrawLimit = input.nextDouble();
		
		Account acc = new Account(number, name, initialBalance, withdrawLimit);
		
		System.out.println();
		System.out.print("Enter amount for withdraw: ");
		double withdrawAmount = input.nextDouble();
			
		try {
			acc.withdraw(withdrawAmount);
			System.out.print("New balance: " + String.format("%.2f", acc.getBalance()));
		}
		catch(DomainException e) {
			System.out.println(e.getMessage());
		}
		
		input.close();
	}

}
