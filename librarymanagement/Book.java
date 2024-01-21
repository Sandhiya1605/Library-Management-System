package librarymanagement;
import java.util.Scanner;

public class Book {
	public int sNo;
	public String authorName;
	public String bookName;
	public int bookQty;
	public int bookCopy;
	
	Scanner sc=new Scanner(System.in);
	
	public Book() {
		System.out.println("Enter the Serial No of Book:");
		this.sNo=sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter the Book name:");
		this.bookName=sc.nextLine();
		
		System.out.println("Enter Author name:");
		this.authorName=sc.nextLine();
		
		System.out.println("Enter the quantity of Books:");
		this.bookQty=sc.nextInt();
		bookCopy=this.bookQty;
		
	}

}
