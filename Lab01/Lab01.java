//Kelly Wang
//5351010
package lab01;

public class Lab01 {
	public static void main(String[] args) {
		Book b1 = new Book();
		b1.setAuthor("Kelly", "Wang", 1999, 0);
		b1.setPages(300);
		b1.setPrice(45.67);
		b1.setTitle("Importance of Human Sexuality");
		b1.setYearPublished(2019);
		System.out.println(b1.toString());
		
		Book b2 = new Book(b1);
		b2.setTitle("Writing for English Majors");
		b2.setPages(200);
		b2.setAuthor("Evan", "A", 3000, 30);
		System.out.println(b2.toString());
		System.out.println(b1.toString());
		
	}
}
