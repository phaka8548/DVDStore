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
		DvdType[] rentedDVDs1 = {c, d};
		CustomerType joey = new CustomerType("Joey Jo", 1, "JoeyJo@email.com", rentedDVDs1);
		
		DvdType[] rentedDVDs2 = {a, b};
		CustomerType josh = new CustomerType("Josh Smith", 2, "JoshSmith@email.com", rentedDVDs2);
		
		DvdType[] rentedDVDs3 = {a, c};
		CustomerType jess = new CustomerType("Jess Cooper", 3, "JessCooper@email.com", rentedDVDs3);
		
		DvdType[] rentedDVDs4 = {c, b};
		CustomerType jill = new CustomerType("Jill Banks", 4, "JillBanks@email.com", rentedDVDs4);
		
		//The way you implemented the arrays above make me quite skeptical of my code but here it is, it worked in what I downloaded before.
		//I did not know someone else would be testing my section...? Just let me know if I need to change anything and I will be happy to do so.
		
		
		String[] carlRentedDVDs = {"","","","",""};
		CustomerType carl = new CustomerType("Carl Clam",5678,"ClamMan@email.com",carlRentedDVDs);
		System.out.println(carl.toString());
		carl.rentDVD("The Avengers",carlRentedDVDs);
		carl.rentDVD("The Big Sick",carlRentedDVDs);
		carl.rentDVD("The Terminator", carlRentedDVDs);
		carl.returnDVD("The Big Sick",carlRentedDVDs);
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
		
		LinkedPositionalList<CheckedOut> tempCheck = new LinkedPositionalList<>();
		
		CheckedOut e = new CheckedOut();			//Checked out is basically an object that holds which DVDs are checked
													//out and who has the DVD
		
		e.setTitles(joey.getRentedDVDs());
		e.setAccountNumber(joey.getAccountNumber());
		
		tempCheck.addFirst(e);
		
		CheckedOut f = new CheckedOut();
		
		f.setTitles(josh.getRentedDVDs());
		f.setAccountNumber(josh.getAccountNumber());
		
		tempCheck.addFirst(f);
		
		CheckedOut g = new CheckedOut();
		
		g.setTitles(jess.getRentedDVDs());
		g.setAccountNumber(jess.getAccountNumber());
		
		tempCheck.addFirst(g);
		
		CheckedOut h = new CheckedOut();
		
		h.setTitles(jill.getRentedDVDs());
		h.setAccountNumber(jill.getAccountNumber());
		
		tempCheck.addFirst(h);
		
		
		
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
	
	
}

