public class CheckedOut {			//object that holds an account number and the DVD's associated with that account #
	

	//checked out list
	//rent thats going to search through DVD list and reduce its number of copies by one
	//and find the customer in the customer list and adds a DVD to their list
	//and in the checkout positional list - grab the DVD that was checked and the account # that holds it
	//before adding object to a list, search through list, find ID number, and add that DVD to that ID
	//if they don't have anything checked out, create a new checked out object and add that to that array
	//need a 3rd search method to search through CheckedOut positional list
	
	
	private double accountNumber;				//holding account number of a person
	private DvdType[] DVDs = {null, null, null, null, null};	//holding DVDs person checked out (rented)
	

	//this object will hold an account number and the DVD that was rented
	public CheckedOut(double accountNumber, DvdType[] dVDs) {
		super();
		this.accountNumber = accountNumber;
		//CustomerType rentingCustomer = new CustomerType("", accountNumber, "newEmail");
		DVDs = dVDs;
	}

	//checkout - add a DVD to the customer's list and decrement the DVDs copies by 1
	//in order to implement, create a customer, and a DVD
	/**
	 * 
	 * @param CustomerType person who is checking out DVD
	 * @param outDVD the DVD the person is checking out
	 */
	public void addDVD(DvdType DVD)
	{
		for(int lcv = 0; lcv < this.DVDs.length; lcv++)
		{   
            if(this.DVDs[lcv] == null)
            {
                
            }       
        } 
	}
	
	/**
	 * These methods will be used within the class
	 * @param person
	 * @param inDVD
	 */
	public void removeDVD(CustomerType person, DvdType inDVD)
	{
		person.returnDVD(inDVD);				//person basically returns DVD
		inDVD.setCopies(inDVD.getCopies()+1);	//increment the number of copies by 1
	}
}
