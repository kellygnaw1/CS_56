package lab03;

//Kelly Wang 5351010
//Evan Altshule 5233234
public class Student {
	private int perm;
	private String firstName;
	private String lastName;
	
	public Student(String first, String last, int perm){
		this.perm = perm;
		firstName = first;
		lastName = last;
	}
	
	public int getPerm() {return perm;}
	public String getFirstName() {return firstName;}
	public String getLastName() {return lastName;}
	
	public void printStudent() {
		System.out.println("\t"+ perm + " | " + lastName + ", " + firstName);
	}
}

