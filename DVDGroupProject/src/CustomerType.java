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
                System.out.println(this.fullName + " cannot rent any more DVDs" + "\n");
                break;
            }          
            if(this.rentedDVDs[lcv] == null)
            {
                System.out.println(this.fullName + " is renting DVD: "+ rentedDVD.getTitle() + "\n");
                this.rentedDVDs[lcv] = rentedDVD;
                break;
            }       
        } 
    }

	/*public void sortNulls()
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
		 
	}*/
	public void returnDVD(DvdType rentedDVD)
	{
		int nullElement = 0;
		for (int lcv = 0; lcv < rentedDVDs.length; lcv++)
		{
			if(rentedDVDs[lcv].equals(rentedDVD))			
				{
				 System.out.println(this.fullName + " is returning DVD: "+  rentedDVD.getTitle() + "\n");
				 rentedDVDs[lcv] = null;
				 nullElement = lcv;
				 break;
				}
		}
		for(int lcv = nullElement; lcv < rentedDVDs.length - 1; lcv++)
		{
			if (rentedDVDs[lcv+1].equals(null)) 
			{
				break;
			} else {
				rentedDVDs[lcv] = rentedDVDs[lcv];
			}
		}
	}
	
	
	@Override
	public String toString() {
		 
		String rentedDVDList = printRentedDVDs();
		return "Name: " + fullName + "\naccountNumber: " + accountNumber + "\nemail: " + email + rentedDVDList + "\n";
	}
		

}
