public class bankAcc {
	
	private static long testaccnum = 100000000001L;
	private long accnum;
	private double bal;
	private User user;
	private int pin;
	
	public bankAcc (double balance, User user) {
		this.accnum = bankAcc.testaccnum++;
	}
	
	public long getAccNum () {
		return accnum;
	}
	public void setAccNum (long accnumber) {
		this.accnum = accnumber;
	}
	
	
	public double getBalance() {
		return bal;
	}
	public void setBalance (double balance) {
		this.bal = balance;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser (User username) {
		this.user = username;
	}
	
	public int getPIN() {
		return pin;
	}
	public void setPIN(int pin) {
		this.pin = pin;
	}
	
	public boolean deposit(double amount) {
		if (amount <= 0) {
			return false;
		}
		bal += amount;
		return true;
	}
	
	public int withdraw (double amount) {
		if (amount > bal) {
			return 0;
		} else if (amount <= 0) {
			return 1;
		} else {
			bal = bal - amount;
			return 2;
		}
	}
}
