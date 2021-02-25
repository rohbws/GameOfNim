/**
 * BOARD class created by Rohan Bosworth on 2/24/21
 * 
 * This class handles the Board but is not intended to be used an object.
 * Refer to the class but do not create a separate object from it.
 */
public class Board {
    // Instance variable to store the current number of pieces on the Board
    private static int pieces = 0;

    /**
     * populate method
     * 
     * This method populates the game board with a random number of pieces between 10 and 50
     * 
     * Pre-requisite: populate method has been called and pieces is instantiated.
     * 
     * Post-requisite: pieces is initiated to a random value between 10 and 50
     */
    public static void populate() {
        // Determine a random integer between 10 and 50 and store result in pieces
        pieces = (int) (Math.random() * 40 + 10);
    } // End of populate

    /**
     * getNumPieces getter
     * 
     * This method returns the nuber of pieces so the value can be accessed
     * 
     * @return The current number of pieces on the board
     */
    public static int getNumPieces() {
        return pieces;
    } // End of getNumPieces

    /**
     * removePieces method
     * 
     * This method removes pieces from the board but does not validate that the number of pieces is less than half the pieces on the board
     * 
     * Pre-requisite: pieces has been properly initialized with a random number of pieces, cannot be null
     * 
     * Post-requisite: numPieces is subtracted from the current number of pieces on the board
     * 
     * @param numPieces The number of pieces to be removed from the board
     */
    public static void removePieces(int numPieces) {
        // Remove the requested number of pieces from the board
        pieces -= numPieces;
    } // End of removePieces
} // End of Board class
