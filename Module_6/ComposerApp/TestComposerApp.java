/*
Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
Comprehensive Version (12th ed.). Pearson Education, Inc.
 */
package Module_6.ComposerApp;
/*
Class named TestComposerApp to test the classes Composer and MemComposerDao
 */
public class TestComposerApp {
    
    //Prompt the user with a menu
    public static void main(String[] args) {

        java.util.Scanner scanner = new java.util.Scanner(System.in);
        String userInput;
        
        // Display the menu
        System.out.println("  Welcome to the Composer App");
        System.out.println();

        MemComposerDao composerDao = new MemComposerDao();
        do {
        System.out.println("  MENU OPTIONS");
        System.out.println("    1. View composers");
        System.out.println("    2. Find composer");
        System.out.println("    3. Add composer");
        System.out.println("    4. Exit");
        System.out.println();
        System.out.print("  Please choose an option: ");
            userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase("4")) {
                System.out.println();
                System.out.println("  Goodbye");
                break;
            }

            switch (userInput) {
                case "1":
                    // Display a list of composers
                    System.out.println();
                    System.out.println();
                    System.out.println("  --DISPLAYING COMPOSERS--");
                    for (Composer composer : composerDao.findAll()) {
                        System.out.println(composer.toString());
                        System.out.println();
                    }
                    break;
                case "2":
                    // Prompt the user to enter an id and display the selected composer object
                    System.out.print("  Enter an id: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    Composer composer = composerDao.findBy(id);
                    if (composer != null) {
                        System.out.println();
                        System.out.println("  --DISPLAYING COMPOSER--");
                        System.out.println(composer.toString());
                        System.out.println();
                    } else {
                        System.out.println("  Composer not found.");
                    }
                    break;
                case "3":
                    // Prompt the user to create a new composer
                    System.out.print("  Enter an ID: ");
                    int newId = Integer.parseInt(scanner.nextLine());
                    System.out.print("  Enter a name: ");
                    String name = scanner.nextLine();
                    System.out.print("  Enter a genre: ");
                    String genre = scanner.nextLine();
                    System.out.println();
                    Composer newComposer = new Composer(newId, name, genre);
                    composerDao.insert(newComposer);
                    break;
                default:
                    System.out.println("  Invalid option. Please try again.");
            }   
        } while (true);
        scanner.close();
}
}
