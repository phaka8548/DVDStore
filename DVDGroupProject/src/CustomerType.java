import java.util.Arrays;

//Customer Type is a subclass of Person Class
public class CustomerType extends Person{

	private String fullName;
	private double accountNumber;
	private String email;
	private DvdType[] rentedDVDs = {null, null, null, null, null};	//Customers can only rent 5 DVD's at a time
	private static int numCustomers = 1;
	
	public CustomerType(String fullName, double accountNumber, String email) {
		super(fullName);	//inherited from superclass
		this.fullName = fullName;
		this.accountNumber = accountNumber;
		this.email = email;
		this.rentedDVDs = rentedDVDs;
		numCustomers++;
	}
	
	
	public static int getNumCustomers() {
		return numCustomers;
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
		String rentedDVDTitles = "";
		for (int i = 0; i < this.rentedDVDs.length ; i++)
		{
			if (rentedDVDs[i] != null)		//check for nulls to avoid the null pointer error
			{
				rentedDVDTitles += "\n" + rentedDVDs[i].getTitle();
			}
			else
				continue;
		}
		return rentedDVDTitles;
		
	}
	
	
	//methods to rent and return (similar to DVDType methods)
	public void rentDVD(DvdType rentedDVD)
    { 
    //exception
        for(int lcv = 0; lcv < this.rentedDVDs.length+1; lcv++)
        {
            if (lcv == this.rentedDVDs.length) 
            {
                System.out.println(this.fullName + " cannot rent any more DVDs");
                break;
            }          
            if(this.rentedDVDs[lcv] == null)
            {
                System.out.println("Renting DVD: "+ rentedDVD.getTitle());
                this.rentedDVDs[lcv] = rentedDVD;
                break;
            }       
        } 
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
		for(int lcv = 0; lcv < rentedDVDs.length; lcv++){ 		//go through loop
	
			if (rentedDVDs[lcv] != null)
			{
				if(rentedDVDs[lcv].equals(dvdTitle))				//find if the objects are the same
				{
				 System.out.println("Returning DVD: "+  dvdTitle.getTitle());
				 rentedDVDs[lcv] = null;						//if they are, set that DVD to null
				}
			}
			else
				continue;
		}
		//this.sortNulls();
	}
	
	
	@Override
	public String toString() {
		 
		String rentedDVDList = printRentedDVDs();
		return "Customer fullName=" + fullName + ", accountNumber=" + accountNumber + ", email=" + email + rentedDVDList + "]";
	}
		

}
