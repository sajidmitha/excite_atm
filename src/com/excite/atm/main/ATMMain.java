package com.excite.atm.main;

import java.util.Scanner;

import com.excite.atm.bo.ATMTransactionBO;
import com.excite.atm.exception.ATMException;
import com.excite.atm.transactions.ATMTransaction;

/**
 * @author sajid
 * 
 */
public class ATMMain {

	// init()
	// checkATMBalance()
	// checkClientBalance()
	// withrawFunds()
	static Scanner input = new Scanner(System.in);

	public static void main(String args[]) {
		long funds = 0;
		int press = 0;
		int choice = 0;
		// Initialize & Ready the ATM system
		do {
			try {
				ATMTransaction objTran = ATMTransaction.getInstance();

				System.out
						.println("****************************************************");
				System.out.println("\tWelcome to this Excite ATM ");
				System.out.println("\tPlease select ATM Transactions");
				System.out.println("\tPress [1] Deposit Funds");
				System.out.println("\tPress [2] Check ATM Balance ");
				System.out.println("\tPress [3] Withdraw Funds");
				System.out.println("\tPress [4] Exit ATM");
				System.out
						.println("****************************************************");
				System.out.print("\tEnter Your Selection : ");

				do {
					press = input.nextInt();
					if (press > 4) {
						System.out.println("\n\tPlease check you input .");
					} else {
						// System.out.print("Output : ");
						switch (press) {
						case 1:
							System.out.println("\t Deposit in the ATM system.");
							break;
						case 2:
							System.out.println("\t Balance in ATM system is $"
									+ objTran.balance());
							break;
						case 3:
							System.out
									.println("\tEnter Amount you wish to Wihrdraw from ATM system :$");
							funds = input.nextInt();
							objTran.withdraw(funds);
							break;
						case 4:
							// System.out.println("\tThankyou for using ATM system.");
							break;
						}
					}

				} while (press > 4);// loop till user enters proper input
				choice = redo(choice);
				// System.out.println("Choice : "+choice);

				System.out.println("\tThankyou for using ATM system.");

			} catch (ATMException ae) {
				System.out.println("\n\tATM EXception." + ae.getErrMsg());
				redo(choice);
			} catch (Exception ae) {
				System.out.println("\n\t EXception." + ae.getMessage());
				redo(choice);
			}

		} while (choice <= 1);

	}

	private static int redo(int choice) {
		do {
			try {
				System.out
						.println("\n\tWould you like to try another transaction?");
				System.out.println("\tPress [1] Yes \tPress [2] No");
				System.out.print("\tEnter choice: ");
				choice = input.nextInt();

				if (choice > 2) {
					System.out.print("\n\tPlease select correct choice.");
				}
			}

			catch (Exception e) {
				System.out
						.println("\tError Input! Please enter a number only.");
				input = new Scanner(System.in);
				System.out.println("\tEnter yout choice:");
				choice = input.nextInt();
			}
		} while (choice > 2);
		return choice;
	}

	private static String message = "TestJunit";

	public static String printTestMessage() {
		System.out.println(message);
		return message;
	}

}
