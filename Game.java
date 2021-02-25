import java.util.Scanner;

/**
 * GAME class created by Rohan Bosworth on 2/24/21
 * 
 * This class contains one method which allows the user to play the Game of Nim.
 * A constructor is also used to declare players and whether the game should repeat.
 */
public class Game {
    // Two players competing in the game
    private Player player1;
    private Player player2;
    // A boolean determining whether the users will play again
    private boolean playAgain = true;

    /**
     * Constructor for the Game class
     * 
     * Initializes players for the game
     * 
     * Pre-requisite: Object of Game class has been initialized
     * 
     * Post-requisite: Both players have been created with respective names
     */
    public Game() {
        // Prompt Player 1 for their name
        System.out.println("Welcome to the Game of Nim. Player 1, please enter your name!");
        // Initialize player1 which sets their name
        player1 = new Player();

        // Prompt Player 2 for their name
        System.out.println("Great! Player 2, please enter your name.");
        // Initialize player2 which sets their name
        player2 = new Player();
    } // End of constructor

    /**
     * play method
     * 
     * This method will play the Game of Nim and contains all the required tools to do so. A simple call to this method will begin a full game
     * 
     * Pre-requisite: Both players have been properly initialized using the constructor
     * 
     * Post-requisite: Game is complete and winner is determined.
     */
	public void play() {
        // Declare a new Scanner object to be used later in the game
        Scanner scan = new Scanner(System.in);
        // Prompt the users to get them ready to play.
        System.out.println("Let's Play!");
        // Initialize another player to be used later to organize rounds
        Player currentPlayer = player2;

        // Loop while the players want to continue the game
        while(playAgain) {

            // Determine a player at random to begin the round. Aliasing will be used to ensure points are totaled correctly.
            if (Math.random() < 0.5) {
                // Alias player1 to current player
                currentPlayer = player1;
            }
            else {
                // Alias player2 to current player
                currentPlayer = player2;
            }

            // Loop while the round has not ended, the last piece has not been taken and a winner has not been decided
            while(Board.getNumPieces() > 1) {
                // Alternate the player from the previous loop so turns go back and forth (First player is still random)
                if (currentPlayer == player1) {
                    // If the the last player to remove pieces is player 1, the current player is player 2
                    currentPlayer = player2;
                }
                else {
                    // If the the last player to remove pieces is player 2, the current player is player 1
                    currentPlayer = player1;
                }

                // Prompt the current player with the number of pieces on the board and ask how many they would like to remove
                System.out.println("There are " + Board.getNumPieces() + " pieces on the Board. How many pieces would you like to remove " + currentPlayer.getName() + "?");

                // Initialize some variables to store input
                int numPieces = 0;
                String input = ""; // This String is used to take input to ensure that the user provides a proper number (in case the user types letters)

                // Store first input in the input string
                input = scan.nextLine();

                // These variables will be used to validate the input and provide an accurate error message
                boolean validInput = false;
                String error = "";

                // Loop as long as the input provided by the user is invalid
                while(!validInput) {
                    // Use a try_catch in case the user provided letters in their response which cannot be stored in an integer
                    try {
                        // Attempt to store the user input in an integer, error will be thrown if user used characters other than numbers
                        numPieces = Integer.parseInt(input);
                        // Determine if the user input is less than half the pieces on the board
                        if (numPieces <= Board.getNumPieces() / 2) {
                            // The user has provided valid input
                            validInput = true;
                        }
                        else { // The user has entered too large of an input
                            // Store an error message to be used later
                            error = "Please enter a number less than or equal to half the pieces on the board.";
                            // Report that the user's input is invalid and must be renterred
                            validInput = false;
                        }
                    } catch (Exception e) { // The user has provided characters other than numbers in their input
                        // Report that the input is invalid
                        validInput = false;
                        // Provide a custom error message to be used later
                        error = "Please enter a valid Integer";
                    }

                    // If the input is invalid, ask for input again
                    if (!validInput) {
                        // Print out the user's error before reprompting them
                        System.out.println(error);

                        // Prompt the user for input again
                        input = scan.nextLine();
                    }
                } // End of while loop used to determine valid input

                // The user has provided valid input so remove pieces from the Board
                Board.removePieces(numPieces);
            } // End of while loop containing one round

            // Add one point to the current player's score. By incrementing the score of currentPlayer, the score of either player1 or player2 is incremented due to aliasing
            currentPlayer.incrScore(1);

            // Report the player that has won the game and NOT taken the last piece
            System.out.println(currentPlayer.getName() + " has won the round and currently has " + currentPlayer.getPoints() + " points!");
            // Determine which player lost to report their score
            if (currentPlayer == player1) {
                // Player 2 has lost so report their score
                System.out.println(player2.getName() + " currently has " + player2.getPoints() + " points.");
            }
            else {
                // Player 1 has lost so report their score
                System.out.println(player1.getName() + " currently has " + player1.getPoints() + " points.");
            }
            
            // Prompt the user if they would like to play again
            System.out.println("Would you like to play again? Please answer \"yes\" or \"no\".");
            // Store the user's response in a new String
            String again = scan.nextLine();

            // Determine if the user has provided a valid input of "yes" or "no" and continue prompting until they do
            while(!again.equals("yes") && !again.equals("no")) {
                // Reprompt the user for input
                System.out.println("Would you like to play again? Please answer \"yes\" or \"no\".");
                again = scan.nextLine();
            }

            // Determine if the user has requested to play again
            if (again.equals("yes")) {
                // Set playAgain to true and the loop will continue
                playAgain = true;
            }
            else {
                // The players have ended the game and playAgain is set to false, ending the game
                playAgain = false;
            }

            // Repopulate the Board in case players have decided to play again
            Board.populate();
        } // End of while loop containing entire game

        // Determine if player 1 has won the game
        if (player1.getPoints() > player2.getPoints()) {
            // Report player one has won the game along with their score
            System.out.println(player1.getName() + " has won the game with " + player1.getPoints() + " points!");
            // Report player 2's score as well
            System.out.println(player2.getName() + " came in second with " + player2.getPoints() + " points!");
        }
        // Determine if the players have tied
        else if (player1.getPoints() == player2.getPoints()) {
            // Resport the score at which the player's have tied
            System.out.println("You have tied the game at " + player1.getPoints() + " points!");
        }
        else { // Player 2 has won the game
            // Report player two has won the game along with their score
            System.out.println(player2.getName() + " has won the game with " + player2.getPoints() + " points!");
            // Report player 2's score as well
            System.out.println(player1.getName() + " came in second with " + player1.getPoints() + " points!");
        }
    }// End of play method    
} // End of Board class
