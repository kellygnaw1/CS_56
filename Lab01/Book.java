//Kelly Wang 
//5351010
package lab01;

public class Book {
	private int totalPages; 
	private int yearPublished;
	private double priceUSD;
	private String title; 
	private Author author; 
	
	//default constructor 
	public Book() 
	{
		author = new Author();
	}
	
	//copy constructor 
	public Book(Book otherBook)
	{
		this.totalPages = otherBook.totalPages;
		this.yearPublished = otherBook.yearPublished;
		this.priceUSD = otherBook.priceUSD;
		this.title = otherBook.title;
		this.author = otherBook.author;
	}
	
	//accessors
	public int getPages()
	{
		return totalPages;
	}
	
	public int getYearPublished()
	{
		return yearPublished;
	}
	
	public double getPrice()
	{
		return priceUSD;
	}
	
	public String getTitle()
	{
		return title; 
	}
	
	public Author getAuthor()
	{
		return author; 
	}
	
	//mutators
	
	public void setPages(int pages)
	{
		totalPages = pages;
	}
	
	public void setYearPublished(int year)
	{
		yearPublished = year;
	}
	
	public void setPrice(double price)
	{
		priceUSD = price;
	}
	
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	public void setAuthor(String firstName, String lastName, int birthYear, int numOfPublications)
	{
		author.setFirstName(firstName);
		author.setLastName(lastName);
		author.setBirthYr(birthYear);
		author.setNumPub(numOfPublications);
	}
	
	public String toString()
	{
		return("Title: " + title + "\n" +
				"Publish Year: " + yearPublished + "\n" +
				"Total Pages: " + totalPages + "\n" +
				"Price: $" + priceUSD + "\n" +
				"Author: " + author.getFirstName() + " " + author.getlastName() + "\n" +
				"Author's birth year: " + author.getBirthYr() + "\n"+
				"Author's total number of publications: " + author.getNumPub() + "\n");
	}

}
