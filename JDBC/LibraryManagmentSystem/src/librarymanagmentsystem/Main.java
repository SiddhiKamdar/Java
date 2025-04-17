package librarymanagmentsystem;
import java.sql.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        DBConnector connector = new DBConnector();
        Connection connection = connector.getConnection();
        
        if(connection != null){
            System.out.println("Connection Successfull!");
        }
        
        Author author = new Author(connection);
        Book book = new Book(connection);
        
        Scanner scanner = new Scanner(System.in);
        
        int choice;
        do {
            System.out.println("\nMenu: Library Managment System: ");
            System.out.println("1. Add Author");
            System.out.println("2. Update Author");
            System.out.println("3. Delete Author");
            System.out.println("4. List all Authors");
            System.out.println("5. Add Book");
            System.out.println("6. Update Book");
            System.out.println("7. Delete Book");
            System.out.println("8. List all Books");
            System.out.println("9. Exit");
            
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            
            switch(choice){
                case 1:
                    System.out.print("Enter author name: ");
                    String authorName = scanner.nextLine();
                    author.addAuthor(authorName);
                    System.out.print("Author Added Successfully");
                    break;
                
                case 2:
                    System.out.print("Enter author id: ");
                    int authorIdToUpdate = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new author name: ");
                    String newAuthorName = scanner.nextLine();
                    author.updateAuthor(authorIdToUpdate, newAuthorName);
                    System.out.print("Author Updated Successfully");
                    break;
                
                case 3:
                    System.out.print("Enter author id to delete: ");
                    int authorIdToDelete = scanner.nextInt();
                    author.deleteAuthor(authorIdToDelete);
                    System.out.print("Author Deleted Successfully");
                    break;
                
                case 4:
                    System.out.print("List of author: ");
                    for(String a: author.getAllAuthors()){
                        System.out.println(a);
                    }
                    break;
                    
                case 5:
                    System.out.print("Enter book title: ");
                    String bookTitle = scanner.nextLine();
                    System.out.print("Enter author Id: ");
                    int authorIdForBook = scanner.nextInt();
                    book.addBook(bookTitle, authorIdForBook);
                    System.out.print("Book added Successfully");
                    break;
                   
                case 6:
                    System.out.print("Enter book id: ");
                    int bookIdToUpdate = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new book title: ");
                    String newBookTitle = scanner.nextLine();
                    System.out.print("Enter new author id: ");
                    int newAuthorIdForBook = scanner.nextInt();
                    book.updateBook(bookIdToUpdate, newBookTitle, newAuthorIdForBook);
                    System.out.print("Book Updated Successfully");
                    break;
                    
                case 7:
                    System.out.print("Enter book id to delete: ");
                    int bookIdToDelete = scanner.nextInt();
                    book.deleteBook(bookIdToDelete);
                    System.out.print("Book Delete Successfully");
                    break;
                    
                case 8:
                    System.out.print("List of Books: ");
                    for(String b: book.getAllBooks()){
                        System.out.println(b);
                    }
                    break;
                    
                case 9:
                    System.out.println("Exiting....\nThanks for visiting!!");
                    break;
                 
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }                      
        } while(choice != 9);
        
        connector.closeConnection();
    }
}
