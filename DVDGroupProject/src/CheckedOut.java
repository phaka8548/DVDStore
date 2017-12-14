public class CheckedOut {
	
	private double accountNumber;
	private DvdType[] DVDs = new DvdType[5];
	String[] titles = new String[5];
	
	public CheckedOut(double accountNumber, DvdType[] DVDs) {
		super();
		this.accountNumber = accountNumber;
		this.DVDs = DVDs;
	}
	
	
	public CheckedOut() {}


	public double getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(double accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String[] getTitles() {
		for (int i = 0; i < DVDs.length ; i++)	//can only fill titles based on the number of DVDs 
		{
			
			titles[i] =  DVDs[i].getTitle();		//fill array with titles of DVD's in list
			
		}
		return titles;
	}
	public void setTitles(DvdType[] DVDs)
	{
		for (int i = 0; i < DVDs.length ; i++)	//can only fill titles based on the number of DVDs 
		{
			if (DVDs[i] != null)				//to handle null pointer exceptions
			titles[i] = DVDs[i].getTitle();		//fill array with titles of DVD's in list
			else
				continue;						//keep going through for loop
		}
		
	}


	@Override
	public String toString() {
		return "CheckedOut [accountNumber=" + accountNumber + ", title=" + titles + "]";
	}
	


	
	
}