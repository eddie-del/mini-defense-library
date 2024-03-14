import java.util.Scanner;
public class LibraryRandB {
   //Genre of Books
   public static String [][] history = {
		   {"1", "History book PH", "Available", "1500"}, 
		   {"2", "History Book US", "Available", "1000"}, 
		   {"3", "History Book JP", "Available", "1100"}
		   };
   public static String [][] romance = {
		   {"4", "Romance book PH", "Available", "1100"}, 
		   {"5", "Romance Book US", "Available", "1300"}, 
		   {"6", "Romance Book JP", "Available", "1450"}
		   };
   public static String [][] educational = {
		   {"7", "Programming PH\t\t", "Available", "1500"}, 
		   {"8", "Data Structures US \t", "Available", "1400"}, 
		   {"9", "Object Oriented Programming JP", "Available", "1400"}
		   };
   public static String [][] world = {
		   {"10", "The Contemporary World", "Available", "1100"}, 
		   {"11", "Art Appreciation ", "Available", "1000"}, 
		   {"12", "Contemporary Arts", "Available", "1200"}
		   };
   
   //indexes for ID, title, availability
   // idNum = 0;
   // TitleNum = 1;
   // Availability = 2;
   // price = 4
    // main method :3
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        
        String login = authentication(sc);
        
       switch (login) {
           case "Admin":
               adminInterface(sc);
               break;
           case "User":
               userInterface(sc);
               break;
           default:
               main(null);
               break;
       }       
    }
    
    //Login authentication function
    public static String authentication(Scanner sc) {
    	//Login Credentials
    	final String USER = "User";
    	final String PASS = "user123";
    	final String USER2 = "Admin";
    	final String PASS2 = "admin123";
    	   
        System.out.print("Enter Username: ");
        String username = sc.nextLine();
        System.out.print("Enter Password: ");
        String password = sc.nextLine();
        
        if (username.equals(USER) && password.equals(PASS)) {
            return "User";
        }
        else if (username.equals(USER2) && password.equals(PASS2)) {
            return "Admin";
        }
        else {
            System.out.println("Invalid Username or Password\n");
            
            return "";
          
        }	
    }
    
    //userInterface function
    public static void userInterface(Scanner sc) {
       int choice;
       String userEntry;
       
        do {
            System.out.println("\n==================================================================");
            System.out.println("========================Welcome to Library========================");
            System.out.println("==================================================================");
            System.out.println(" 1. Display Available Books ");
            System.out.println(" 2. Borrow a book");
            System.out.println(" 3. Return a book");
            System.out.println(" 4. Log out");
            System.out.print("Enter your choice: ");
            userEntry = sc.nextLine();
            
            while(checkInput(userEntry)) {
             	System.out.print("Enter your choice(no letters): ");
             	userEntry = sc.nextLine();
             }
             choice = Integer.parseInt(userEntry);
     
            switch(choice) {
                case 1:
                    displayBooks(sc);
                    break;     
                    
                case 2:
                    borrowBook(sc);
                    break;
                    
                case 3:
                	int pili;
                	System.out.println("\n==================================================================");
                	System.out.println("==================================================================");
                	System.out.println("1. Return a Book ");
                	System.out.println("2. Replace a Book");
                	System.out.print("Enter your choice: ");
                	String payEntry = sc.nextLine();
                    while(checkInput(payEntry)) {
                     	System.out.print("Enter your choice(no letters): ");
                     	payEntry = sc.nextLine();
                     }
                     pili = Integer.parseInt(payEntry);
                	
                	switch (pili) {
                		case 1 :
                			returnBook(sc);
                			break;
                		case 2:
                			replaceBook(sc);
                			break;
                		default:
                			System.out.println("\nInvalid Choice! Try again");
                			
                	} 
                    break;
                    
                case 4:
                    System.out.println("\n==================================================================");
                    System.out.println("=============Logged out! Thank you for using the system.==========");
                    System.out.println("==================================================================\n");
                    main(null);
                 default:
                	 System.out.println("\nInvalid Choice! Try again");
            }
        } while (choice != 4);
    }
    //adminInterface function
    public static void adminInterface(Scanner sc) {
        
        int choice;
        do {
            System.out.println("\n==================================================================");
            System.out.println("========================Welcome to Library========================");
            System.out.println("==================================================================");
            System.out.println("\n1. Display Available Books ");
            System.out.println("2. Log out");
            System.out.print("Enter your choice: ");
            String userEntry = sc.nextLine();
            
            while(checkInput(userEntry)) {
             	System.out.print("Enter your choice(no letters): ");
             	userEntry = sc.nextLine();
             }
             choice = Integer.parseInt(userEntry);
            
            switch(choice) {
                case 1:
                    displayAdminAvailability(sc);
                    break;
                    
                case 2:
                    System.out.println("\n==================================================================");
                    System.out.println("=============Logged out! Thank you for using the system.==========");
                    System.out.println("==================================================================\n");
                    main(null);
                    break;
                
                default:
               	 System.out.println("\nInvalid Choice! Try again");
                       
            }
            
        } while (choice != 2);
        
        
        
    }
    
    // First choice in Use: Display available genre of books 
    public static void displayBooks(Scanner sc){
        System.out.println("\n==================================================================");
        System.out.println("==================================================================\n");
        System.out.println("Choose a genre");
        System.out.println("1. History ");
        System.out.println("2. Romance");
        System.out.println("3. Educational");
        System.out.println("4. World ");
        System.out.print("Enter your Choice: ");
        String userEntry = sc.nextLine();
        
        while(checkInput(userEntry)) {
         	System.out.print("Enter your choice(no letters): ");
         	userEntry = sc.nextLine();
         }
         int choices = Integer.parseInt(userEntry);
        
            switch(choices) {
                case 1:
                    System.out.println("\n==================================================================");
                    System.out.println("==================================================================\n");
                    for (String []book: history) {
                    System.out.println("ID: " + book[0] + "\tTitle: " + book[1] + "\tStatus: " + book[2]);
                    }
                    break;
                    
                case 2: 
                    System.out.println("\n==================================================================");
                    System.out.println("==================================================================\n");
                    for (String [] love: romance) {
                    System.out.println("ID: " + love[0] + "\tTitle: " + love[1] + "\tStatus: " + love[2]);
                    }
                    break;
                case 3: 
                    System.out.println("\n==================================================================");
                    System.out.println("==================================================================\n");
                    for (String [] educ: educational) {
                    System.out.println("ID: " + educ[0] + "\tTitle: " + educ[1] + "\tStatus: " + educ[2]);
                    }
                    break;
                case 4:
                    System.out.println("\n==================================================================");
                    System.out.println("==================================================================\n");
                    for (String []dio: world) {
                    System.out.println("ID: " + dio[0] + "\tTitle: " + dio[1] + "\tStatus: " + dio[2]);
                    }
                    break;
                default:
                    System.out.println("\n Invalid Choice! Try again");
            }
    }
    // First Choice in Admin: Id, Title, Availability, and Price
    public static void displayAdminAvailability (Scanner sc) {
    	 System.out.println("\n==================================================================");
         System.out.println("==================================================================\n");
         System.out.println("Choose a genre");
         System.out.println("1. History ");
         System.out.println("2. Romance");
         System.out.println("3. Educational");
         System.out.println("4. World ");
         System.out.print("Enter your Choice: ");
         String userEntry = sc.nextLine();
         
         while(checkInput(userEntry)) {
          	System.out.print("Enter your choice(no letters): ");
          	userEntry = sc.nextLine();
          }
          int choices = Integer.parseInt(userEntry);
         
             switch(choices) {
                 case 1:
                     System.out.println("\n==================================================================");
                     System.out.println("==================================================================\n");
                     for (String []book: history) {
                     System.out.println("ID: " + book[0] + "\tTitle: " + book[1] + "\tStatus: " + book[2] + "\tPrice: Php " + book[3]);
                     }
                     break;
                     
                 case 2: 
                     System.out.println("\n==================================================================");
                     System.out.println("==================================================================\n");
                     for (String [] love: romance) {
                     System.out.println("ID: " + love[0] + "\tTitle: " + love[1] + "\tStatus: " + love[2] + "\tPrice: Php " + love[3]);
                     }
                     break;
                 case 3: 
                     System.out.println("\n==================================================================");
                     System.out.println("==================================================================\n");
                     for (String [] educ: educational) {
                     System.out.println("ID: " + educ[0] + "\tTitle: " + educ[1] + "\tStatus: " + educ[2]  + "\tPrice: Php " + educ[3]);
                     }
                     break;
                 case 4:
                     System.out.println("\n==================================================================");
                     System.out.println("==================================================================\n");
                     for (String []dio: world) {
                     System.out.println("ID: " + dio[0] + "\tTitle: " + dio[1] + "\tStatus: " + dio[2]  + "\tPrice: Php " + dio[3]);
                     }
                     break;
                 default:
                     System.out.println("\n Invalid Choice! Try again");
             }
    }
    // Second choice in User: Borrow different Genre of books
    public static void borrowBook (Scanner sc) {
        System.out.println("\n==================================================================");
        System.out.println("==================================================================\n");
        System.out.println("Choose a genre");
        System.out.println("1. History ");
        System.out.println("2. Romance");
        System.out.println("3. Educational");
        System.out.println("4. World ");
        System.out.print("Enter your Choice: ");
        String userEntry = sc.nextLine();
        
        while(checkInput(userEntry)) {
         	System.out.print("Enter your choice(no letters): ");
         	userEntry = sc.nextLine();
         }
         int choices = Integer.parseInt(userEntry);
        
        int choices2;
            switch(choices) {
                case 1:
                    System.out.println("\n==================================================================");
                    System.out.println("==================================================================\n");
                    for (String []book: history) {
                    System.out.println("ID: " + book[0] + "\tTitle: " + book[1] + "\tStatus: " + book[2]);
                    }
                    System.out.print("\nEnter book ID: ");
                    choices2 = sc.nextInt();
                    for (String []book: history) {
                        if (Integer.parseInt(book[0]) == choices2 && book[2].equalsIgnoreCase("available")) {
                            book[2] = "Borrowed";
                            System.out.println("You successfully borrowed: " + book[1]);
                            return;
                        } 
                    }
                    System.out.println("Invalid book ID or the book is unavailable");
                    break;
                    
                case 2: 
                    System.out.println("\n==================================================================");
                    System.out.println("==================================================================\n");
                    for (String [] love: romance) {
                    System.out.println("ID: " + love[0] + "\tTitle: " + love[1] + "\tStatus: " + love[2]);
                    }
                    System.out.print("\nEnter book ID: ");
                    choices2 = sc.nextInt();
                    for (String []love: romance) {
                        if (Integer.parseInt(love[0]) == choices2 && love[2].equalsIgnoreCase("available")) {
                            love[2] = "Borrowed";
                            System.out.println("You successfully borrowed: " + love[1]);
                            return;
                        } 
                    }
                    System.out.println("Invalid book ID or the book is unavailable");
                    break;
                case 3: 
                    System.out.println("\n==================================================================");
                    System.out.println("==================================================================\n");
                    for (String [] educ: educational) {
                    System.out.println("ID: " + educ[0] + "\tTitle: " + educ[1] + "\tStatus: " + educ[2]);
                    }
                    System.out.print("\nEnter book ID: ");
                    choices2 = sc.nextInt();
                    for (String []educ: educational) {
                        if (Integer.parseInt(educ[0]) == choices2 && educ[2].equalsIgnoreCase("available")) {
                            educ[2] = "Borrowed";
                            System.out.println("You successfully borrowed: " + educ[1]);
                            return;
                        } 
                    }
                    System.out.println("Invalid book ID or the book is unavailable");
                    break;
                case 4:
                    System.out.println("\n==================================================================");
                    System.out.println("==================================================================\n");
                    for (String []dio: world) {
                    System.out.println("ID: " + dio[0] + "\tTitle: " + dio[1] + "\tStatus: " + dio[2]);
                    }
                    System.out.print("\nEnter book ID: ");
                    choices2 = sc.nextInt();
                    for (String []dio: world) {
                        if (Integer.parseInt(dio[0]) == choices2 && dio[2].equalsIgnoreCase("available")) {
                            dio[2] = "Borrowed";
                            System.out.println("You successfully borrowed: " + dio[1]);
                            return;
                        } 
                    }
                    System.out.println("Invalid book ID or the book is unavailable");
                    break;
                default:
                    System.out.println("\n Invalid Choice! Try again");
            }
        
    }
    //Third Choice in User: Return book using book id
    public static void returnBook(Scanner sc){

    	 System.out.println("\n==================================================================");
         System.out.println("==================================================================\n");
         System.out.println("Choose a genre");
         System.out.println("1. History ");
         System.out.println("2. Romance");
         System.out.println("3. Educational");
         System.out.println("4. World ");
         System.out.print("Enter your Choice: ");
         String userEntry = sc.nextLine();
         
         while(checkInput(userEntry)) {
          	System.out.print("Enter your choice(no letters): ");
          	userEntry = sc.nextLine();
          }
          int choices = Integer.parseInt(userEntry);
         int choices2;
             switch(choices) {
                 case 1:
                     System.out.println("\n==================================================================");
                     System.out.println("==================================================================\n");
                     for (String []book: history) {
                     System.out.println("ID: " + book[0] + "\tTitle: " + book[1] + "\tStatus: " + book[2]);
                     }
                     System.out.print("\nEnter book ID: ");
                     choices2 = sc.nextInt();
                     for (String []book: history) {
                         if (Integer.parseInt(book[0]) == choices2 && book[2].equalsIgnoreCase("Borrowed")) {
                             book[2] = "Available";
                             System.out.println("You successfully returned: " + book[1]);
                             return;
                         } 
                     }
                     System.out.println("Invalid book ID or the book is unavailable");
                     break;
                     
                 case 2: 
                     System.out.println("\n==================================================================");
                     System.out.println("==================================================================\n");
                     for (String [] love: romance) {
                     System.out.println("ID: " + love[0] + "\tTitle: " + love[1] + "\tStatus: " + love[2]);
                     }
                     System.out.print("\nEnter book ID: ");
                     choices2 = sc.nextInt();
                     for (String []love: romance) {
                         if (Integer.parseInt(love[0]) == choices2 && love[2].equalsIgnoreCase("Borrowed")) {
                             love[2] = "Available";
                             System.out.println("You successfully returned: " + love[1]);
                             return;
                         } 
                     }
                     System.out.println("Invalid book ID or the book is unavailable");
                     break;
                 case 3: 
                     System.out.println("\n==================================================================");
                     System.out.println("==================================================================\n");
                     for (String [] educ: educational) {
                     System.out.println("ID: " + educ[0] + "\tTitle: " + educ[1] + "\tStatus: " + educ[2]);
                     }
                     System.out.print("\nEnter book ID: ");
                     choices2 = sc.nextInt();
                     for (String []educ: educational) {
                         if (Integer.parseInt(educ[0]) == choices2 && educ[2].equalsIgnoreCase("Borrowed")) {
                             educ[2] = "Available";
                             System.out.println("You successfully returned: " + educ[1]);
                             return;
                         } 
                     }
                     System.out.println("Invalid book ID or the book is unavailable");
                     break;
                 case 4:
                     System.out.println("\n==================================================================");
                     System.out.println("==================================================================\n");
                     for (String []dio: world) {
                     System.out.println("ID: " + dio[0] + "\tTitle: " + dio[1] + "\tStatus: " + dio[2]);
                     }
                     System.out.print("\nEnter book ID: ");
                     choices2 = sc.nextInt();
                     for (String []dio: world) {
                         if (Integer.parseInt(dio[0]) == choices2 && dio[2].equalsIgnoreCase("Borrowed")) {
                             dio[2] = "Available";
                             System.out.println("You successfully returned: " + dio[1]);
                             return;
                         } 
                     }
                     System.out.println("Invalid book ID or the book is unavailable");
                     break;
                 default:
                     System.out.println("\n Invalid Choice! Try again");
             }
    }  
    //Third Choice in User: Book ID
    public static void replaceBook(Scanner sc) {
    	int choice,choices;
    	System.out.println("\n==================================================================");
        System.out.println("==================================================================\n");
        System.out.println("Choose a genre");
        System.out.println("1. History ");
        System.out.println("2. Romance");
        System.out.println("3. Educational");
        System.out.println("4. World ");
        System.out.print("Enter your Choice: ");
        String userEntry = sc.nextLine();
        
        while(checkInput(userEntry)) {
         	System.out.print("Enter your choice(no letters): ");
         	userEntry = sc.nextLine();
         }
        choice = Integer.parseInt(userEntry);
    	choice = sc.nextInt();
             switch(choice) {
                 case 1:
                     System.out.println("\n==================================================================");
                     System.out.println("==================================================================\n");
                     System.out.print("\nEnter book ID: ");
                     choices = sc.nextInt();
                     for (String []book: history) {
                         if (Integer.parseInt(book[0]) == choices && book[2].equalsIgnoreCase("Borrowed")) {
                             book[2] = "available";
                             System.out.println("ID: " + book[0] + "\tTitle: " + book[1] + "\tPrice: Php " + book[3]);
                             System.out.println("\nWhat type of payment do you prefer?");
         					System.out.println("1. Online Payment ");
         					System.out.println("2. Cash");
         					System.out.print("Enter your choice: ");
         					int choices2 = sc.nextInt();
             		
         					switch (choices2) {
         						case 1:
         							onlinePayment();
         							break;
         						case 2:
         							cashPayment();
         							break;
         					}
                             
                             return;
                         } 
                     }
                     System.out.println("Invalid book ID or the book is unavailable");
                     break;
                 case 2:
                     System.out.println("\n==================================================================");
                     System.out.println("==================================================================\n");
                     System.out.print("\nEnter book ID: ");
                     choices = sc.nextInt();
                     for (String []love: romance) {
                         if (Integer.parseInt(love[0]) == choices && love[2].equalsIgnoreCase("Borrowed")) {
                             love[2] = "available";
                             System.out.println("ID: " + love[0] + "\tTitle: " + love[1] + "\tPrice: Php " + love[3]);
                             System.out.println("\nWhat type of payment do you prefer?");
         					System.out.println("1. Online Payment ");
         					System.out.println("2. Cash");
         					System.out.print("Enter your choice: ");
         					int choices2 = sc.nextInt();
             		
         					switch (choices2) {
         						case 1:
         							onlinePayment();
         							break;
         						case 2:
         							cashPayment();
         							break;
         					}
                             
                             return;
                         } 
                     }
                     System.out.println("Invalid book ID or the book is unavailable");
                     break;
                 case 3:
                     System.out.println("\n==================================================================");
                     System.out.println("==================================================================\n");
                     System.out.print("\nEnter book ID: ");
                     choices = sc.nextInt();
                     for (String []educ: educational) {
                         if (Integer.parseInt(educ[0]) == choices && educ[2].equalsIgnoreCase("Borrowed")) {
                             educ[2] = "available";
                             System.out.println("ID: " + educ[0] + "\tTitle: " + educ[1] + "\tPrice: Php " + educ[3]);
                             System.out.println("\nWhat type of payment do you prefer?");
         					System.out.println("1. Online Payment ");
         					System.out.println("2. Cash");
         					System.out.print("Enter your choice: ");
         					int choices2 = sc.nextInt();
             		
         					switch (choices2) {
         						case 1:
         							onlinePayment();
         							break;
         						case 2:
         							cashPayment();
         							break;
         					}
                             
                             return;
                         } 
                     }
                     System.out.println("Invalid book ID or the book is unavailable");
                     break;
                 case 4:
                     System.out.println("\n==================================================================");
                     System.out.println("==================================================================\n");
                     System.out.print("\nEnter book ID: ");
                     choices = sc.nextInt();
                     for (String []dio: world) {
                         if (Integer.parseInt(dio[0]) == choices && dio[2].equalsIgnoreCase("Borrowed")) { 
                             dio[2] = "available";
                             System.out.println("ID: " + dio[0] + "\tTitle: " + dio[1] + "\tPrice: Php " + dio[3]);
                             System.out.println("\nWhat type of payment do you prefer?");
         					System.out.println("1. Online Payment ");
         					System.out.println("2. Cash");
         					System.out.print("Enter your choice: ");
         					int choices2 = sc.nextInt();
             		
         					switch (choices2) {
         						case 1:
         							onlinePayment();
         							break;
         						case 2:
         							cashPayment();
         							break;
         					}
                             
                             return;
                         } 
                     }
                     System.out.println("Invalid book ID or the book is unavailable");
                     break;
                 default:
                	 System.out.println("\nInvalid Choice! Please Try again");
             }
    }
    //payment methods
    public static void onlinePayment () {
    	System.out.println("\nSTI Gcash number: 0986 656 6969");
    	System.out.println("ooootoooooooooool");
    	System.out.println("o1ootoooooioooool");
    	System.out.println("o1ootoooooioooool");
    	System.out.println("o1ootoooooioooool");
    	System.out.println("o1ooooooooioooool");
    	System.out.println("ooooooooooooooooo");
    	System.out.println("ooooooooooooooooo");
    	System.out.println("ooooooooooooooooo");
    	}
    public static void cashPayment () {

    	System.out.println("\nPlease approach the cashier to pay for lost books");
    }
    public static boolean checkInput (String userEntry) {
    	boolean hasString = false; 
    	int index = 0;
    		while(index < userEntry.length()) {
    			if(!(userEntry.charAt(index) >= '0' && userEntry.charAt(index) <= '9')) {
    				hasString = true; 
    			}
    			index++;
    		}
    	
    	return hasString;
    	}
    
}