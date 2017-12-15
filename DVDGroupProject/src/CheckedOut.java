public class CheckedOut {			//object that holds an account number and the DVD's associated with that account #
	
	//essentially a checkedOut object is a piece of paper that holds the account # and DVD associated with that account
	//and in the checkout positional list - grab the DVD that was checked and the account # that holds it
	//before adding object to a list, search through list, find ID number, and add that DVD to that ID

	private double accountNumber;				//holding account number of a person
	private DvdType[] DVDs = {null, null, null, null, null};	//holding DVDs person checked out (rented)

	//this object will hold an account number and the DVD that was rented
	public CheckedOut(double accountNumber) {
		super();
		this.accountNumber = accountNumber;
		//CustomerType rentingCustomer = new CustomerType("", accountNumber, "newEmail");
		this.DVDs = DVDs;
	}

	public CheckedOut() {}

	public double getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(double accountNumber) {
		this.accountNumber = accountNumber;
	}


	/**
	 * adds a DVD into a checkedOutObject
	 * @param outDVD the DVD the person is checking out
	 */
	public void addDVD(DvdType DVD)			//This object will essentially hold a list of DVDs
	{
		for(int lcv = 0; lcv < this.DVDs.length; lcv++)
		{   
            if (this.DVDs[lcv] == null)		//find an empty spot
            {
            	this.DVDs[lcv] = DVD;		//add DVD to the list
            	break;
            }       
        } 
	}
	
	/**
	 * removes a DVD from the list
	 * @param inDVD
	 */
	public void removeDVD(DvdType DVD)
	{
		int nullElement = 0;
		for (int lcv = 0; lcv < DVDs.length; lcv++)
		{
			if(DVDs[lcv].equals(DVD))			
				{
				 DVDs[lcv] = null;
				 nullElement = lcv;
				 break;
				}
		}
		for(int lcv = nullElement; lcv < DVDs.length - 1; lcv++)
		{
			if (DVDs[lcv+1].equals(null)) 
			{
				break;
			} else {
				DVDs[lcv] = DVDs[lcv];
			}
		}
	}
}
