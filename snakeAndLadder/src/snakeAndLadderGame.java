import java.util.Random;

public class snakeAndLadderGame {


        public static void main (String[]args){
            System.out.println("Welcome to Snake and Ladder Game");
            int targetPosition = 100;

            int player1Pos = 0;
            int player2Pos = 0;

            int currentPlayer = 1; // 1 for Player 1, 2 for Player 2

            while (player1Pos < targetPosition && player2Pos < targetPosition) {
                int diceRoll = rollDie();
                System.out.println("Dice Roll: " + diceRoll);

                int option = checkOption();
                System.out.println("Option: " + option);

                if (currentPlayer == 1) {
                    player1Pos = updatePosition(player1Pos, diceRoll, option);
                    System.out.println("Player 1's Position: " + player1Pos);
                } else {
                    player2Pos = updatePosition(player2Pos, diceRoll, option);
                    System.out.println("Player 2's Position: " + player2Pos);
                }

                // Check for ladder and allow the player to play again
                if (option == 1) {
                    System.out.println("You got a ladder ! PLayer "+currentPlayer+" play again!!.");
                } else {
                    // Switch to the next player
                    currentPlayer = (currentPlayer == 1) ? 2 : 1;
                }
            }

            if (player1Pos >= targetPosition) {
                System.out.println("Player 1 won the game!");
            } else {
                System.out.println("Player 2 won the game!");
            }
        }

    /*
     * @name: rollDie
     * @desc: Simulates rolling a six-sided die and returns the result.
     */
    private static int rollDie() {
        Random random = new Random();
        return random.nextInt(6) + 1; // Generate a random number between 1 and 6
    }

    /*
     * @name: checkOption
     * @desc: Uses ((RANDOM)) to check for options.
     *        Returns 0 -> No Play, 1 -> Ladder, 2 -> Snake.
     */
    private static int checkOption() {
        Random random = new Random();
        return random.nextInt(3); // Generate a random number between 0 and 2
    }

    /*
     * @name: updatePosition
     * @desc: Updates player position based on the option (No Play, Ladder, or Snake).
     * @param: currentPosition, diceRoll, option
     * @return: updated position
     */
    private static int updatePosition(int currentPosition, int diceRoll, int option) {
        switch (option) {
            case 0:
                System.out.println("No Play.");
                break;
            case 1:
                System.out.println("Ladder! Player moves ahead by " + diceRoll + " positions.");

                // Calculate the potential new position
                int potentialPosition = currentPosition + diceRoll;

                if (potentialPosition <= 100) {
                    // If the potential position is within or at the winning position, update normally
                    currentPosition = potentialPosition;
                } else {
                    // If the potential position exceeds the winning position, stay in the same previous position
                    System.out.println("Overshoots 100! No moves to be taken.");
                }
                break;
            case 2:
                System.out.println("Snake! Player moves behind by " + diceRoll + " positions.");
                currentPosition -= diceRoll;
                if (currentPosition < 0) {
                    currentPosition = 0; // If the player position goes below 0, stay at 0
                }
                break;
        }

        System.out.println("New Position: " + currentPosition);
        return currentPosition;
    }

}
