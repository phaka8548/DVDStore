import java.util.Arrays;

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
		return Arrays.toString(this.getRentedDVDs());
	}
	
	
	//methods to rent and return (similar to DVDType methods)
	public void rentDVD(DvdType rentedDVD)
	{ 
	//exception
		boolean notFull = true;
		for(int lcv = 0; lcv < this.rentedDVDs.length; lcv++)
		{
			if(this.rentedDVDs[lcv] == null)
			{
				System.out.println("Renting DVD: "+ rentedDVD.getTitle());
				this.rentedDVDs[lcv] = rentedDVD;
				if (lcv == 4)
					notFull = false;
				break;
			}
			
		}
		if (!notFull)
			System.out.print(this.fullName + " cannot rent any more DVDs");
	}

	public void sortNulls()
	{
	
		//rearrange...???
		 for (int lcv=0; lcv < this.rentedDVDs.length; lcv++)
		 {
	            if (this.rentedDVDs[lcv].equals(null))
	            {
	                for (int lcv2=lcv+1; lcv2<this.rentedDVDs.length; lcv2++){
	                		rentedDVDs[lcv2-1] = rentedDVDs[lcv2];
	                }
	                rentedDVDs[rentedDVDs.length-1].equals(null);
	                	break;
	            }
	        }
		 
	}
	public void returnDVD(DvdType dvdTitle)
	{
		for(int lcv = 0; lcv<rentedDVDs.length; lcv++){
			if(rentedDVDs[lcv].equals(dvdTitle))
			{
				 rentedDVDs[lcv] = null;
				 System.out.println("Returning DVD: "+dvdTitle);
			}
		}
		this.sortNulls();
	}
	
	
	/*public boolean maxDVDsReached(){
		for(int lcv=0; lcv<rentedDVDs.length; lcv++)
		{
			if(rentedDVDs[lcv] == null){	//if there is an empty spot
				return false;			
			}
		}
		return true;		
	}*/
	@Override
	public String toString() {
		 
		String rentedDVDList = printRentedDVDs();
		return "CustomerType [fullName=" + fullName + ", accountNumber=" + accountNumber + ", email=" + email + rentedDVDList + "]";
	}
		

}
