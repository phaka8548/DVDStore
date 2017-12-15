import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class DriverDvdStore {

	public static void main(String[] args) {

		//Some DvdTypes
		
		String[] starsA = new String[] {"Ryan Gosling", "Rachel McAdams"};				
		DvdType a = new DvdType("The Notebook", starsA, "Mark Johnson", "Nick Cassavetes", "New Line Cinema", 10);

		String[] starsB = new String[] {"Kumail Nanjiani", "Zoe Kazan"};
		DvdType b = new DvdType("The Big Sick", starsB, "Judd Apatow", "Michael Showalter", "Apatow Production", 10);
		
		String[] starsC = new String[] {"Adam Sandler", "Drew Barrymore"};	
		DvdType c = new DvdType("The Wedding Singer", starsC, "Jack Giarraputow", "Frank Croaci", "New Line Cinema", 10);
		
		String[] starsD = new String[] {"Arnold Schwarzenegger", "Linda Hamilton", "Michael Biehn"};	
		DvdType d = new DvdType("The Terminator", starsD, "Gale Ann Hurd", "James Cameron", "Hemdale Film Corporation", 10);
		
		
		//here is the linked list. This creates a head and a tail
		LinkedPositionalList<DvdType> temp = new LinkedPositionalList<>();
		
		//adding the elements to the linked list
		temp.addFirst(a);
		temp.addFirst(b);
		temp.addFirst(c);
		temp.addFirst(d);
		
		System.out.println(removeDVD("The Rat Terminator", temp));
		
		//an uninitialized dvdType
		//DvdType e = new DvdType();
			
		//here i was just testing what the iterator would do. This copied the first element into a uninitialized dvdType
		//e = marker.getElement().toString();
		
		
		//Here I'm testing the iterator to see what happens when i use the getelement method on it. It does what I was 
		//hoping it would. That is reference the first element in the list.
		//System.out.println(marker.getElement().toString());
		
		
		//This would print the whole list on one line
		//System.out.println(temp.toString());
	
		
		//examples of the search for method
		searchFor("The Notebook", temp);
		//searchFor("High School Musical", temp); //will throw an exception if a DVD doesn't exist
		//Testing checkDVD method
		System.out.println(checkDVD("The Notebook", temp));
		printAllDVDs(temp);
		
		//Creating some customer to fill a list
		CustomerType joey = new CustomerType("Joey Jo", 1, "JoeyJo@email.com");
		joey.rentDVD(a);
		int newID = CustomerType.getNumCustomers();
		
		CustomerType josh = new CustomerType("Josh Smith", newID, "JoshSmith@email.com");
		josh.rentDVD(b);
		
		System.out.println(josh.toString());
		
		CustomerType jess = new CustomerType("Jess Cooper", 3, "JessCooper@email.com");
		jess.rentDVD(c);
		
		CustomerType jill = new CustomerType("Jill Banks", 4, "JillBanks@email.com");
		//jill.rentDVD(d);

		
		CustomerType carl = new CustomerType("Carl Clam",5678,"ClamMan@email.com");
		carl.toString();
		carl.rentDVD(a);
		carl.rentDVD(b);
		carl.rentDVD(c);
		System.out.println(carl.toString());
		carl.rentDVD(d);
		carl.rentDVD(a);
		carl.rentDVD(b);
		carl.rentDVD(c);
		carl.rentDVD(d);
		carl.returnDVD(c);
		System.out.println(carl.toString());
		
		
		//updating out dvdtypes to match whats checked out
		
		a.checkOut();
		a.checkOut();
		
		b.checkOut();
		b.checkOut();
		
		c.checkOut();
		c.checkOut();
		
		d.checkOut();
		d.checkOut();
		
		//CustomerType Linked List
		LinkedPositionalList<CustomerType> tempCust = new LinkedPositionalList<>();
				
		//adding the elements to the linked list
		tempCust.addFirst(joey);
		tempCust.addFirst(josh);
		tempCust.addFirst(jess);
		tempCust.addFirst(jill);
		
		//CustomerType toString example
		System.out.println(joey.toString());
		
		
		//checked out list
		//rent thats going to search through DVD list and reduce its number of copies by one
		//and find the customer in the customer list and adds a DVD to their list
		//and in the checkout positional list - grab the DVD that was checked and the account # that holds it
		//before adding object to a list, search through list, find ID number, and add that DVD to that ID
		//if they don't have anything checked out, create a new checked out object and add that to that array
		//need a 3rd search method to search through CheckedOut positional list
		
		LinkedPositionalList<CheckedOut> tempCheck = new LinkedPositionalList<>();
	
		//Implementation of how the checkedOut positional list (list of all checkedOut DVDs and their associated account
		LinkedPositionalList<CheckedOut> tempCheck = new LinkedPositionalList<>();
		
		//create a new checkedOut object when a customer checks something out
		CheckedOut e = new CheckedOut(2);			//Checked out is basically an object that holds which DVDs are checked
													//out and what account # has the DVD
		//get the right account number
		e.setAccountNumber(joey.getAccountNumber());
		//put the DVD in the checked out object
		e.addDVD(d);
		
		//add the object to the list
		tempCheck.addLast(e);
		
		
		
		
	}
	
	/**
	 * 
	 * @param title of DVD to search for
	 * @param DVDlibrary within a certain store or library (our project will really only have one library, currently called "temp")
	 * @return Position<DvdType> the position of the DVD
	 * @throws NoSuchElementException if DVD doesn't exist in library
	 */
	public static Position<DvdType> searchFor(String title, LinkedPositionalList<DvdType> DVDlibrary)
	throws NoSuchElementException
	{
		Position<DvdType> DVDiterator = DVDlibrary.first();			//Set initial position to point to first position (node) in array
		while (DVDiterator != null) 
		{ 
			 //compare the titles
			if (title.compareTo(DVDiterator.getElement().getTitle()) == 0)	//get title of element in that position
			{
				System.out.println("Found DVD: " + title);
				return DVDiterator;
			}
			//else, go to next element
			DVDiterator = DVDlibrary.after(DVDiterator);			//make iterator the next position 
		 }
		
		throw new NoSuchElementException("Cannot locate DVD: " + title); //if iterates and doesn't discover DVD
	}
	
	/**
	 * 
	 * @param title
	 * @param DVDlibrary
	 * @return the details of the DVD
	 */
	public String showDVD(String title, LinkedPositionalList<DvdType> DVDlibrary)
	{
		Position<DvdType> DVDPosition = searchFor(title, DVDlibrary);
		return DVDPosition.getElement().toString();
	}
	
	/**
	 * 
	 * @param full name name of customer to search for
	 * @param Linked Positional List that holds CustomerType Objects CusDatabase
	 * @return the position of the Customer
	 * @throws NoSuchElementException if customer doesn't exist in database
	 */
	public static Position<CustomerType> searchCustomer(String name, LinkedPositionalList<CustomerType> CusDatabase)
			throws NoSuchElementException
	{
				Position<CustomerType> Customeriterator = CusDatabase.first();			//Set initial position to point to first position (node) in array
				while (Customeriterator != null) 
				{ 
					 //compare the titles
					if (name.compareTo(Customeriterator.getElement().getFullName()) == 0)	//get title of element in that position
					{
						System.out.println("Found Customer: " + name);
						return Customeriterator;
					}
					//else, go to next element
					Customeriterator = CusDatabase.after(Customeriterator);			//make iterator the next position 
				 }
				
				throw new NoSuchElementException("Cannot locate Customer: " + name); //if iterates and doesn't discover DVD
	}
	
	/**
	 * This method prints out all the DVDs's titles given a positional list
	 * @param DVDlibrary
	 */
	public static void printAllDVDs(LinkedPositionalList<DvdType> DVDlibrary)
	{
		System.out.println("All DVD's in store:");
		//this is an iterator. Set its position to the beginning of the list.
		Position<DvdType> marker = DVDlibrary.first();
		//loop through the whole list and reference each element to obtain methods to get Titles
		while (marker != null) 
		{ 
			 System.out.println(marker.getElement().getTitle());		//print title of DVD
			 marker = DVDlibrary.after(marker); 						//re-initialize marker to next
		 }
	}
	
	/**
	 * Method returns a boolean to see if a DVD exists within a certain library
	 * @param title
	 * @param DVDlibrary
	 * @return
	 */
	public static boolean checkDVD(String title, LinkedPositionalList<DvdType> DVDlibrary)
	{
		if(searchFor(title, DVDlibrary) != null)		//if this method returns a position (not null), evaluates to true
			return true;
		return false;
	}
	
	
	/**
	 * 
	 * @param title
	 * @param DVDlibrary
	 * @return 
	 */
	public static String removeDVD(String title, LinkedPositionalList<DvdType> DVDlibrary)
	{
		try
		{
			Position<DvdType> DVDPosition = searchFor(title, DVDlibrary);	//searching for the title					
			DVDlibrary.remove(DVDPosition);			//remove the Position from that positional list
			return title + " has been removed";
		}
		catch (Exception e)
		{
			return "This DVD doesn't exist";
		}
	}
	
	
}
