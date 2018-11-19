import java.util.Scanner;

public class ATM {	
	private Scanner in = new Scanner(System.in);
	private bankAcc acc;
	private boolean active = true;
	private boolean verified = false;
	
	public static void main(String[] args) {		
			ATM atm = new ATM (
				new bankAcc (	// creates new Bank Account
					1000,	// balance
					new User (	// creates new User
						2001,	// PIN
						"Dev Patel",	// name
						"February 11, 2001",	// DOB
						"126 Baltusrol Way, Springfield, NJ 07081"	// address
					)
				)
			);
		}
	
	public ATM (bankAcc account) {
		this.acc = account;
	}
	
	public bankAcc getAcc() {
		return acc;
	}
	public void setAcc(bankAcc account) {
		this.acc = account;
	}
	
	public boolean getActive() {
		return active;
	}
	
	public void accVerify () {
	while (!verified) {	
		System.out.println("Please enter your account number: ");
		int inputaccNum = in.nextInt(); 
		if (inputaccNum == acc.getAccNum()) {
			System.out.println("Please enter your PIN: ");
				int inputPIN = in.nextInt();
				if (inputPIN == acc.getPIN()) {
					System.out.println("Please select an option by typing the appropriate number for which action you would like to perform:");
					System.out.println("1. Withdraw");
					System.out.println("2. Balance");
					System.out.println("3. View Balance");
					System.out.println("4. Exit");
					
					int inputOption = in.nextInt();
					switch (inputOption) {
						case 1:
							boolean depoStatus;
								do {
									System.out.println("Enter the value of how much you are depositing:");
									double depositAmount = in.nextDouble();
									in.nextLine();
									depoStatus = acc.deposit(depositAmount);
									if(depoStatus == false) {
										System.out.println("ERROR: You have to deposit an amount greater than $0.00");
									} else {
										System.out.println("Deposit successful! Your current balance is now: "+ acc.getBalance());
									}
							}
							while (depoStatus != true);
							break;
						case 2:
							if (acc.getBalance() == 0) {
								System.out.println("ERROR: You don't have any funds to withdraw! Try depositing money first.");
								break;
							}
							int wdStatus;
							do {
								System.out.println("Enter the value of how much you are withdrawing:");
								double withdrawAmount = in.nextDouble();
								in.nextLine();
								wdStatus = acc.withdraw(withdrawAmount);
								if (wdStatus == 0) {
									System.out.println("ERROR: You do not have the amount of funds which you are requesting to withdraw. Try withdrawing an amount smaller or equal to your current balance.");
								}
								else if (wdStatus == 1) {
									System.out.println("ERROR: The amount you are withdrawing must be greater than $0.00. Please enter a value greater than $0.00.");	
								}
								else {
									System.out.println("Withdrawal successful! Your current balance is now: " + acc.getBalance());
								}
							} while (wdStatus != 2);
							break;
						case 3:
							System.out.println("You current balance is: " + acc.getBalance());
						case 4:
							System.out.println("Ending session. Thank you for using this simple ATM machine :D");
							in.close();
					}
				} else System.out.println("PIN entered does not link to a valid account. Please enter a valid PIN");
		} else System.out.println("Account number does not link to a valid account. Please enter a valid account number");
	}
	}
}