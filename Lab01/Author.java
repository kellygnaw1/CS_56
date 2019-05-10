//Kelly Wang
//5351010
package lab01;

public class Author {
	private String firstName;
	private String lastName;
	private int birthYr;
	private int numPublication; 
	
	//default constructor 
	public Author() {}
	
	//copy constructor 
	public Author(Author otherAuthor)
	{
		this.firstName = otherAuthor.firstName;
		this.lastName = otherAuthor.lastName;
		this.birthYr = otherAuthor.birthYr;
		this.numPublication = otherAuthor.numPublication;
	}
	//accessors
	public String getFirstName() 
	{
		return firstName;
	}
	
	public String getlastName()
	{
		return lastName;
	}
	
	public int getBirthYr()
	{
		return birthYr;
	}
	
	public int getNumPub()
	{
		return numPublication; 
	}
	
	//mutators
	public void setFirstName(String first)
	{
		firstName = first; 
	}
	
	public void setLastName(String last)
	{
		lastName = last; 
	}
	
	public void setBirthYr(int year)
	{
		birthYr = year;
	}
	
	public void setNumPub(int num)
	{
		numPublication = num; 
	}

}
