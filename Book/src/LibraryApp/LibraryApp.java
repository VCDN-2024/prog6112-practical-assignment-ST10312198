import java.util.InputMismatchException;
import java.util.Scanner;

public class LibraryApp {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            displayMenu();
            option = getValidIntInput(scanner, "Enter your choice: ");

            switch (option) {
                case 1:
                    addBook(scanner, library);
                    break;
                case 2:
                    library.displayAllBooks();
                    break;
                case 3:
                    searchBook(scanner, library);
                    break;
                case 4:
                    System.out.println("Exiting the application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 4);

        scanner.close();
    }

    
    private static void displayMenu() {
        System.out.println("\nLibrary Menu:");
        System.out.println("1. Add a New Book");
        System.out.println("2. Display All Books");
        System.out.println("3. Search for a Book by Title");
        System.out.println("4. Exit");
    }

    
    private static void addBook(Scanner scanner, Library library) {
        System.out.print("Enter Book Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Author Name: ");
        String author = scanner.nextLine();
        int year = getValidIntInput(scanner, "Enter Year of Publication: ");

        Book book = new Book(title, author, year);
        library.addBook(book);
    }

    
    private static void searchBook(Scanner scanner, Library library) {
        System.out.print("Enter Book Title to search: ");
        String title = scanner.nextLine();
        library.searchBookByTitle(title);
    }

    
    private static int getValidIntInput(Scanner scanner, String prompt) {
        int number;
        while (true) {
            System.out.print(prompt);
            try {
                number = scanner.nextInt();
                scanner.nextLine(); 
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); 
            }
        }
        return number;
    }
}

//-----Code Attribution-----//
//(Quick Overview - Library Management System)//
//Available at: (https://youtu.be/esIfJnbrJo8?si=g9QZO3QZfJuCQM81 )//
//Accessed on: (28 August 2024)//

//-----Code Attribution-----//
//( Library Management System - New Book Page)//
//Available at: (https://youtu.be/Jeon7O2qDKk?si=XC-y9H4ejEGL2RgP )//
//Accessed on: (28 August 2024)//
