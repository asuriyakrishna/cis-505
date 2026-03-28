/*
Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
Comprehensive Version (12th ed.). Pearson Education, Inc.
*/
package Module_2.SportsTeamApp;

/*
Clas to test the Team class.
 */
public class TestSportsTeamApp {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        String continueInput = "Y";

        while (continueInput.equalsIgnoreCase("Y")) {
            System.out.println("Welcome to the Sports Team App");
            System.out.println();
            System.out.print("Enter a team name: ");
            String teamName = scanner.nextLine();
            Team team = new Team(teamName);

            System.out.println("Enter the player names: ");
            System.out.print("  hint: Use commas for multiple players; no spaces>: ");
            String playerNamesInput = scanner.nextLine();
            String[] playerNames = playerNamesInput.split(",");

            for (String playerName : playerNames) {
                team.addPlayer(playerName.trim());
            }

            System.out.println();
            System.out.println("--Team Summary--");
            System.out.println("Number of players in team: " + team.getPlayerCount());
            String[] activePlayers = java.util.Arrays.copyOf(team.getPlayers(), team.getPlayerCount());
            System.out.println("Players on team: " + String.join(", ", activePlayers));

            System.out.print("Continue? (y/n): ");
            continueInput = scanner.nextLine();
        }

        System.out.println();
        System.out.println();
        System.out.print("End of line...");
        scanner.close();
    }
    
}
