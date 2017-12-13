
public class CheckedOut {
	
	private double accountNumber;
	private String[] titles = new String[5];
	
	
	public CheckedOut(double accountNumber, String[] titles) {
		super();
		this.accountNumber = accountNumber;
		this.titles = titles;
	}
	
	
	public CheckedOut() {}


	public double getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(double accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String[] getTitles() {
		return titles;
	}
	public void setTitles(DvdType[] DVDs)
	{
		for (int i = 0; i < DVDs.length ; i++)	//can only fill titles based on the number of DVDs 
		{
			
			titles[i] = DVDs[i].getTitle();		//fill array with titles of DVD's in list
		}
		
	}


	@Override
	public String toString() {
		return "CheckedOut [accountNumber=" + accountNumber + ", title=" + titles + "]";
	}
	


	
	
}
