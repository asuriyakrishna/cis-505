/*
Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
Comprehensive Version (12th ed.). Pearson Education, Inc.
*/
package Module_2.SportsTeamApp;

/*
Class to represent a sports team.
 */
public class Team {
    private String teamName;
    private String[] players = new String[20];
    private int playerCount = 0;
    public Team(String teamName) {
        this.teamName = teamName;
    }
    /*
    Method to add a player to team.     
    */
    public void addPlayer(String player) {
        if (playerCount < players.length) {
            players[playerCount] = player;
            playerCount++;
        }
    }
    /*
    A public string array method named getPlayers that returns the players data field.
     */
    public String[] getPlayers() {
        return players;
    }

    /*
    A public int method named getPlayerCount that returns the playerCount data field
     */
    public int getPlayerCount() {
        return playerCount;
    }
    /*  public string method named getTeamName that returns the teamName data field
     */
    public String getTeamName() {
        return teamName;
    }

}