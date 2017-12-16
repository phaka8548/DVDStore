import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class DriverDvdStore {

	public static void main(String[] args) {

		//DVD list
		
		String[] starsA = new String[] {"Ryan Gosling", "Rachel McAdams"};				
		DvdType a = new DvdType("The Notebook", starsA, "Mark Johnson", "Nick Cassavetes", "New Line Cinema", 10);

		String[] starsB = new String[] {"Kumail Nanjiani", "Zoe Kazan"};
		DvdType b = new DvdType("The Big Sick", starsB, "Judd Apatow", "Michael Showalter", "Apatow Production", 10);
		
		String[] starsC = new String[] {"Adam Sandler", "Drew Barrymore"};	
		DvdType c = new DvdType("The Wedding Singer", starsC, "Jack Giarraputow", "Frank Croaci", "New Line Cinema", 10);
		
		String[] starsD = new String[] {"Arnold Schwarzenegger", "Linda Hamilton", "Michael Biehn"};	
		DvdType d = new DvdType("The Terminator", starsD, "Gale Ann Hurd", "James Cameron", "Hemdale Film Corporation", 10);
		
		
		LinkedPositionalList<DvdType> DVDList = new LinkedPositionalList<>();
	
		DVDList.addFirst(a);
		DVDList.addFirst(b);
		DVDList.addFirst(c);
		DVDList.addFirst(d);
		
		//customer list
		
		CustomerType joey = new CustomerType("Joey Jo", CustomerType.getNumCustomers() , "JoeyJo@email.com");
		CustomerType josh = new CustomerType("Josh Smith", CustomerType.getNumCustomers() , "JoshSmith@email.com");
		CustomerType jess = new CustomerType("Jess Cooper", CustomerType.getNumCustomers(), "JessCooper@email.com");
		CustomerType jill = new CustomerType("Jill Banks", CustomerType.getNumCustomers(), "JillBanks@email.com");
		CustomerType carl = new CustomerType("Carl Clam", CustomerType.getNumCustomers(), "ClamMan@email.com");
		
		
		LinkedPositionalList<CustomerType> CustomerList = new LinkedPositionalList<>();
				
		
		CustomerList.addFirst(joey);
		CustomerList.addFirst(josh);
		CustomerList.addFirst(jess);
		CustomerList.addFirst(jill);
		CustomerList.addFirst(carl);
		
	
//checkedout list
		
		LinkedPositionalList<CheckedOut> CheckedOutList = new LinkedPositionalList<>();
		
		
		//testing the methods
		
		
		
		printAllDVDs(DVDList);
	
		printAllCustomers(CustomerList);
		
		printAllRentedDVDs(CheckedOutList);
		
		System.out.println(checkCustomer("kiel", CustomerList));
		System.out.print(showCustomer("Joey Jo", CustomerList));
		
		

		
		rentDVD("Joey Jo", "The Notebook", DVDList, CustomerList, CheckedOutList);
		rentDVD("kiel", "The Notebook", DVDList, CustomerList, CheckedOutList);
		rentDVD("Joey Jo", "Star Wars", DVDList, CustomerList, CheckedOutList);
		
		returnDVD("Joey Jo", "The Notebook", DVDList, CustomerList, CheckedOutList);
		returnDVD("kiel", "The Notebook", DVDList, CustomerList, CheckedOutList);
		returnDVD("Joey Jo", "Star Wars", DVDList, CustomerList, CheckedOutList);
		
		System.out.println(showCustomersCheckedOut("Joey Jo", CustomerList, CheckedOutList));
		
		System.out.println(checkDVD("The Notebook", DVDList));
		System.out.print(showDVD("The Notebook", DVDList));

		
	}
	
	
//search methods
	
	/**
	 * 
	 * @param title of DVD to search for
	 * @param DVDlibrary within a certain store or library (our project will really only have one library, currently called "temp")
	 * @return Position<DvdType> the position of the DVD
	 * @throws NoSuchElementException if DVD doesn't exist in library
	 */
	public static Position<DvdType> searchForDVD(String title, LinkedPositionalList<DvdType> DVDlibrary)

	{
		Position<DvdType> DVDiterator = DVDlibrary.first();			//Set initial position to point to first position (node) in array
		while (DVDiterator != null) 
		{ 
			 //compare the titles
			if (title.compareTo(DVDiterator.getElement().getTitle()) == 0)	//get title of element in that position
			{
				return DVDiterator;
			}
			//else, go to next element
			DVDiterator = DVDlibrary.after(DVDiterator);			//make iterator the next position 
		 }
		return null;
	}
	
	/**
	 * 
	 * @param full name name of customer to search for
	 * @param Linked Positional List that holds CustomerType Objects CusDatabase
	 * @return the position of the Customer
	 * @throws NoSuchElementException if customer doesn't exist in database
	 */
	public static Position<CustomerType> searchForCustomer(String name, LinkedPositionalList<CustomerType> CusDatabase)

	{
				Position<CustomerType> Customeriterator = CusDatabase.first();			//Set initial position to point to first position (node) in array
				while (Customeriterator != null) 
				{ 
					 //compare the titles
					if (name.compareTo(Customeriterator.getElement().getFullName()) == 0)	//get title of element in that position
					{
						return Customeriterator;
					}
					//else, go to next element
					Customeriterator = CusDatabase.after(Customeriterator);			//make iterator the next position 
				 }
				return null;
	}
	
	/**
	 * 
	 * @param id of checkedOut item 
	 * @param tempCheck
	 * @return Position<CheckedOut> the id of checkedOut item
	 * @throws NoSuchElementException if item doesn't exist 
	 */
	public static Position<CheckedOut> searchForCheckedOut(CustomerType customer, LinkedPositionalList<CheckedOut> tempCheck)
	{
		Position<CheckedOut> checkiterator = tempCheck.first();			//Set initial position to point to first position (node) in array
		while (checkiterator != null) 
		{
			 //compare the titles
			if (customer.getAccountNumber() == checkiterator.getElement().getCustomer().getAccountNumber())	//get title of element in that position
			{
				return checkiterator;
			}
			//else, go to next element
			checkiterator =tempCheck.after(checkiterator);			//make iterator the next position 
		 }
		return null;
}
	
//dvd methods using the searchforDVD method
	
	/**
	 * 
	 * @param title
	 * @param DVDlibrary
	 * @return the details of the DVD
	 */
	public static String showDVD(String title, LinkedPositionalList<DvdType> DVDlibrary)
	{
		Position<DvdType> DVDPosition = searchForDVD(title, DVDlibrary);
		return DVDPosition.getElement().toString() + "\n";
	}
	
	/**
	 * Method returns a boolean to see if a DVD exists within a certain library
	 * @param title
	 * @param DVDlibrary
	 * @return
	 */
	public static boolean checkDVD(String title, LinkedPositionalList<DvdType> DVDlibrary)
	{
		if(searchForDVD(title, DVDlibrary) != null)		//if this method returns a position (not null), evaluates to true
			return true;
		return false;
	}

//customer methods using the searchForCustomer method
	
	/**
	 * 
	 * @param Name of the Customer
	 * @param CustomerLibrary
	 * @return the details of the customer
	 */
	public static String showCustomer(String name, LinkedPositionalList<CustomerType> Customerlibrary)
	{
		Position<CustomerType> CustomerPosition = searchForCustomer(name, Customerlibrary);
		return CustomerPosition.getElement().toString() + "\n";
	}

	/**
	 * Method returns a boolean to see if a name exists within a certain library
	 * @param name
	 * @param DVDlibrary
	 * @return
	 */
	public static boolean checkCustomer(String name, LinkedPositionalList<CustomerType> Customerlibrary)
	{
		if(searchForCustomer(name, Customerlibrary) != null)		//if this method returns a position (not null), evaluates to true
			return true;
		return false;
	}
	
//checkedOut methods using the searchForCheckedOut method
	
	/**
	 * Method returns a boolean to see if a CheckedOut exists within a certain library
	 * @param customer
	 * @param CheckedOutLibrary
	 * @return
	 */
	public static boolean checkCheckedOut(CustomerType customer, LinkedPositionalList<CheckedOut> CheckedOutlibrary)
	{
		if(searchForCheckedOut(customer, CheckedOutlibrary) != null)		//if this method returns a position (not null), evaluates to true
			return true;
		return false;
	}

	/**
	 * 
	 * @param customer
	 * @param CheckedOutLibrary
	 * @return the details of the CheckedOut Object
	 */
	public static String showCheckedOut(CustomerType customer, LinkedPositionalList<CheckedOut> CheckedOutlibrary)
	{
		Position<CheckedOut> CheckedOutPosition = searchForCheckedOut(customer, CheckedOutlibrary);
		return CheckedOutPosition.getElement().toString() + "\n";
	}

//show what dvds someone has checked out based on their name
	
	/**
	 * 
	 * @param name
	 * @param CustomerList
	 * @param CheckedOutList
	 * @return The dvds a customer has checked out
	 */
	public static String showCustomersCheckedOut(String name, LinkedPositionalList<CustomerType> Customerlibrary, LinkedPositionalList<CheckedOut> tempCheck)
		{
			if (!checkCustomer(name, Customerlibrary))
					return name + " isn't a customer.";
			
				Position<CustomerType> CustomerPosition = searchForCustomer(name, Customerlibrary);
				
					if (checkCheckedOut(CustomerPosition.getElement(), tempCheck))
						return showCheckedOut(CustomerPosition.getElement(), tempCheck);
					else
						return name + " hasn't checked anything out";
		}
			
//print list methods

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
		System.out.println();
	}
	
	/**
	 * This method prints out all the customers and the dvds they have rented given a positional list
	 * @param Customerlibrary
	 */
	public static void printAllRentedDVDs(LinkedPositionalList<CheckedOut> CheckedOutlibrary)
	{
		System.out.println("List of customers and their checked out DVDs: \n");
		//this is an iterator. Set its position to the beginning of the list.
		Position<CheckedOut> marker = CheckedOutlibrary.first();
		//loop through the whole list and reference each element to obtain methods to get Titles
		while (marker != null) 
		{ 
			 System.out.println(marker.getElement().toString());		//print title of DVD
			 marker = CheckedOutlibrary.after(marker); 						//re-initialize marker to next
		 }
		System.out.println();
	}
	
	/**
	 * This method prints out all the customers given a positional list
	 * @param Customerlibrary
	 */
	public static void printAllCustomers(LinkedPositionalList<CustomerType> customerLibrary)
	{
		System.out.println("List of all the customers: \n");
		//this is an iterator. Set its position to the beginning of the list.
		Position<CustomerType> marker = customerLibrary.first();
		//loop through the whole list and reference each element to obtain methods to get Titles
		while (marker != null) 
		{ 
			 System.out.println(marker.getElement().toString());		//print title of DVD
			 marker = customerLibrary.after(marker); 						//re-initialize marker to next
		 }
		System.out.println();
	}
	
//remove methods
	
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
			Position<DvdType> DVDPosition = searchForDVD(title, DVDlibrary);	//searching for the title					
			DVDlibrary.remove(DVDPosition);			//remove the Position from that positional list
			return title + " has been removed \n";
		}
		catch (Exception e)
		{
			return "This DVD doesn't exist \n";
		}
	}
	
	/**
	 * 
	 * @param customer
	 * @param tempCust
	 * @return 
	 */
	public static String removeCustomer(String customer, LinkedPositionalList<CustomerType> tempCust)
	{
		try
		{
			Position<CustomerType> custPosition = searchForCustomer(customer, tempCust);	//searching for the title					
			tempCust.remove(custPosition);			//remove the Position from that positional list
			return customer + " has been removed";
		}
		catch (Exception e)
		{
			return "This customer doesn't exist";
		}
}
	
	/**
	 * 
	 * @param title
	 * @param tempCheck
	 * @return 
	 */
	public static String removeCheckedOut(CustomerType customer, LinkedPositionalList<CheckedOut> tempCheck)
	{
		try
		{
			Position<CheckedOut> CheckedOutPosition = searchForCheckedOut(customer, tempCheck);	//searching for the title					
			tempCheck.remove(CheckedOutPosition);			//remove the Position from that positional list
			return customer.getFullName() + " has been removed";
		}
		catch (Exception e)
		{
			return "This checked out DVD doesn't exist";
		}
}
	
//Rent and Return - the search methods and the classes
	
	/**
	 * 
	 * @param customer name - a string
	 * @param dvd title - a string
	 * @param dvdlinkedlist
	 * @param customerlinkedlist
	 * @param checkedoutlinklist
	 * @return void
	 */
	public static void rentDVD(String name, String title, LinkedPositionalList<DvdType> DVDlibrary, LinkedPositionalList<CustomerType> customerLibrary, LinkedPositionalList<CheckedOut> checkedOutLibrary)
	{
		if (checkDVD(title, DVDlibrary) && checkCustomer(name, customerLibrary))
				{
					Position<DvdType> x = searchForDVD(title, DVDlibrary);
					
					
					Position<CustomerType> y = searchForCustomer(name, customerLibrary);
					
					if (checkCheckedOut(y.getElement(), checkedOutLibrary))
					{
						Position<CheckedOut> z = searchForCheckedOut(y.getElement(), checkedOutLibrary);
						
						if (!z.getElement().isFull())
						{
							z.getElement().addDVD(x.getElement());
							x.getElement().checkOut();
							System.out.println("Added " + title + " to the dvds " + name + " has checked out.");
						} else {
							System.out.println(name + " cannot rent anymore dvds");
							
						}
					} else {
						CheckedOut w = new CheckedOut(y.getElement());
						w.addDVD(x.getElement()); 
						checkedOutLibrary.addFirst(w);
						x.getElement().checkOut();
						System.out.println(name + " has checked out " + title);
					}
					
				}
		else if (!checkDVD(title, DVDlibrary))
				System.out.println(title + " is not availible");
		else if (!checkCustomer(name, customerLibrary))
				System.out.println(name + " is not a customer");

		System.out.println();
	}
	
	/**
	 * 
	 * @param customer name - a string
	 * @param dvd title - a string
	 * @param dvdlinkedlist
	 * @param customerlinkedlist
	 * @param checkedoutlinklist
	 * @return void
	 */
	public static void returnDVD(String name, String title, LinkedPositionalList<DvdType> DVDlibrary, LinkedPositionalList<CustomerType> customerLibrary, LinkedPositionalList<CheckedOut> checkedOutLibrary)
	{
		if (checkDVD(title, DVDlibrary) && checkCustomer(name, customerLibrary))
		{
			Position<DvdType> x = searchForDVD(title, DVDlibrary);
			
			Position<CustomerType> y = searchForCustomer(name, customerLibrary);
			
			if (checkCheckedOut(y.getElement(), checkedOutLibrary))
					{
						Position<CheckedOut> z = searchForCheckedOut(y.getElement(), checkedOutLibrary);
						z.getElement().removeDVD(x.getElement());
						
						
						if (z.getElement().isEmpty())
						{
							checkedOutLibrary.remove(z);
							x.getElement().checkIn();
							System.out.println(name + " has no more DVDs after returning " + title);
						} else {
							x.getElement().checkIn();
							System.out.println(name + " returned " + title);
						}
						
					}
		}
		else if (!checkDVD(title, DVDlibrary))
			System.out.println(title + " is not availible");
		else if (!checkCustomer(name, customerLibrary))
			System.out.println(name + " is not a customer");

	System.out.println();
	}
	
}
