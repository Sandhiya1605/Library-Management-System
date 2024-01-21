package librarymanagement;
import java.util.Scanner;
public class Students {
	Scanner sc=new Scanner(System.in);
	Student theStudents[]=new Student[50];
	public static int count=0;
	
	public void addStudent(Student s){
        for (int i = 0; i < count; i++) {
            if (s.regNum.equalsIgnoreCase(
                    theStudents[i].regNum)) {
                System.out.println(
                    "Student of Reg Num " + s.regNum
                    + " is Already Registered.");
 
                return;
            }
        }
 
        if (count <= 50) {
            theStudents[count] = s;
            count++;
        }
    }
	
	public void showAllStudents(){
		System.out.println("Student Name\tReg Number");
		for(int i=0;i<count;i++) {
			System.out.println(theStudents[i].studentName+"\t\t"+theStudents[i].regNum);
		}
	}
	
	public int isStudent() {
        System.out.println("Enter Reg Number:");
        String regNum = sc.nextLine();
        for (int i = 0; i < count; i++) {
            if (theStudents[i].regNum.equalsIgnoreCase(
                    regNum)) {
                return i;
            }
        }
        System.out.println("Student is not Registered.");
        System.out.println("Get Registered First.");
        return -1;
    }
	
	public void checkOutBook(Books book)
    {
        int studentIndex = this.isStudent();
        if (studentIndex != -1) {
            System.out.println("checking out");
 
            book.showAllBooks();
            Book b = book.checkOutBook();
 
            System.out.println("checking out");
            if (b != null) {
 
                if (theStudents[studentIndex].booksCount
                    <= 3) {
 
                    System.out.println("adding book");
                    theStudents[studentIndex].borrowedBooks
                        [theStudents[studentIndex]
                             .booksCount]= b;
                    theStudents[studentIndex].booksCount++;
                    return;
                }
                else {
                    System.out.println(
                        "Student Can not Borrow more than 3 Books.");
                    return;
                }
            }
            System.out.println("Book is not Available.");
        }
    }
 
	public void checkInBook(Books book)
    {
        int studentIndex = this.isStudent();
        if (studentIndex != -1) {
            System.out.println(
                "S.No\t\t\tBook Name\t\t\tAuthor Name");
            Student s = theStudents[studentIndex];
            for (int i = 0; i < s.booksCount; i++) {
                System.out.println(
                    s.borrowedBooks[i].sNo + "\t\t\t"
                    + s.borrowedBooks[i].bookName + "\t\t\t"
                    + s.borrowedBooks[i].authorName);
            }
            System.out.println(
                "Enter Serial Number of Book to be Checked In:");
 
            int sNo = sc.nextInt();
 
            for (int i = 0; i < s.booksCount; i++) {
                if (sNo == s.borrowedBooks[i].sNo) {
                    book.checkInBook(s.borrowedBooks[i]);
                    s.borrowedBooks[i] = null;
 
                    return;
                }
            }
 
            System.out.println("Book of Serial No " + sNo
                               + "not Found");
        }
    }
	

}
