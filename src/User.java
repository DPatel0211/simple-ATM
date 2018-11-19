public class User {
	private int pin;
	private String name;
	private String dob;
	private String address;
	
	public User (int pin, String name, String dateofbirth, String address) {
		this.pin = pin;
		this.name = name;
		this.dob = dateofbirth;
		this.address = address;
	}
	
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDOB() {
		return dob;
	}
	public void setDOB(String dateofbirth) {
		this.dob = dateofbirth;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}