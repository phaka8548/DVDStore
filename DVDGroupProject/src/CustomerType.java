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
public void rentDVD(String dvdTitle, String[] rentedDVDs2)
	{ 
		if(maxDVDsReached()){
			System.out.println("You have rented the maximum amount of DVDs [5] ");
		}
		for(int lcv =0;lcv<rentedDVDs2.length;lcv++){
			if(rentedDVDs2[lcv].equals(""))
			{
				System.out.println("Renting DVD: "+dvdTitle);
				 rentedDVDs2[lcv] = dvdTitle;
				 break;
			}
		}
		//rearrange...???
		 for (int lcv=0; lcv<rentedDVDs2.length; lcv++){
	            if (rentedDVDs2[lcv].equals("")){
	                for (int lcv2=lcv+1; lcv2<rentedDVDs2.length; lcv2++){
	                   rentedDVDs2[lcv2-1] = rentedDVDs2[lcv2];
	                }
	                rentedDVDs2[rentedDVDs2.length-1].equals("");
	                break;
	            }
	        }
		
	}
	public void returnDVD(String dvdTitle, String[] rentedDVDs2){
		for(int lcv =0;lcv<rentedDVDs.length;lcv++){
			if(rentedDVDs[lcv].equals(dvdTitle))
			{
				 rentedDVDs[lcv]="";
				 System.out.println("Returning DVD: "+dvdTitle);
			}
		}
		 for (int lcv=0; lcv<rentedDVDs.length; lcv++){
	            if (rentedDVDs[lcv].equals("")){
	                for (int lcv2=lcv+1; lcv2<rentedDVDs.length; lcv2++){
	                   rentedDVDs[lcv2-1] = rentedDVDs[lcv2];
	                }
	                rentedDVDs[rentedDVDs.length-1].equals("");
	                break;
	            }
	        }
	}
	
	
	public boolean maxDVDsReached(){
		boolean flag = false;
		for(int lcv=0;lcv<rentedDVDs.length;lcv++)
		{
			if(rentedDVDs[lcv]==null){
				flag = true;
			}
		}
		return flag;		
	}
	@Override
	public String toString() {
		 
		String rentedDVDList = printRentedDVDs();
		return "CustomerType [fullName=" + fullName + ", accountNumber=" + accountNumber + ", email=" + email + rentedDVDList + "]";
	}
		

}
