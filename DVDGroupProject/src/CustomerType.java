//Customer Type is a subclass of Person Class
public class CustomerType extends Person{

	private String fullName;
	private double accountNumber;
	private String email;
	private DvdType[] rentedDVDs = new DvdType[5];	//Customers can only rent 5 DVD's at a time

	public CustomerType(String fullName, double accountNumber, String email, DvdType[] rentedDVDs) {
		super(fullName);	//inherited from superclass
		this.fullName = fullName;
		this.accountNumber = accountNumber;
		this.email = email;
		//how do we want to keep track of rented DVDs?
		this.rentedDVDs = rentedDVDs;
	}
	
	
	
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public double getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(double accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public DvdType[] getRentedDVDs() {
		return rentedDVDs;
	}
	public void setRentedDVDs(DvdType[] rentedDVDs) {
		this.rentedDVDs = rentedDVDs;
	}


	//Print a list of their rented DVDs
	public String printRentedDVDs()
	{
		
		DvdType[] DVDs = this.getRentedDVDs();
		String borrowList = "";
		for (int i = 0; i < DVDs.length; i++)
		{
			if (DVDs[i] != null)
			borrowList = borrowList + DVDs[i].getTitle() + " \n";
		}
		return ("\n" + this.fullName + ": Rented DVDs \n") + borrowList;
	}
	
	
	//methods to rent and return (similar to DVDType methods)

	@Override
	public String toString() {
		 
		String rentedDVDList = printRentedDVDs();
		return "CustomerType [fullName=" + fullName + ", accountNumber=" + accountNumber + ", email=" + email + rentedDVDList + "]";
	}
		

}