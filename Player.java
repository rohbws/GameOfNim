import java.util.Scanner;

/**
 * PLAYER class created by Rohan Bosworth on 2/24/21
 * 
 * This class is designed to handle individual players and track their points and name
 * 
 * Pre-requisite: Game is initiated
 * 
 * Post-requisite: Players have defined their names and have 0 points to begin
 */
public class Player {

    // Initialize instance variables containing a player's points and name
    private int points = 0;
    private String name = "";

    /**
     * Constructor for the Player Class
     * 
     * This method takes a String input from the user and stores the result in their name
     * 
     * Pre-requisite: Player object instantiated
     * 
     * Post-requisite: Name variable instantiated with player's name
     */
    public Player() {
        // Scanner object used to take in the user's name
        Scanner scan = new Scanner(System.in);

        // Name is stored in an instance variable
        name = scan.nextLine();

        // Points is reset to 0
        points = 0;
    } // End of constructor

    /**
     * Getter for the String name
     * 
     * @return the player's name
     */
    public String getName() {
        return name;
    } // End of getName

    /**
     * Getter for the int points
     * 
     * @return the player's point total
     */
    public int getPoints() {
        return points;
    } // End of getPoints

    /**
     * incrScore Method
     * 
     * Increments the players score by given value
     * 
     * Pre-requisite: points has been initialized properly and is not null
     * 
     * Post-requisite: points has been incremented by parameter increment
     * 
     * @param increment the desired amount to increment the number of points by
     */
    public void incrScore(int increment) {
        points += increment;
    } // End of incrScore method
}