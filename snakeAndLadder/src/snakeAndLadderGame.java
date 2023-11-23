import java.util.Random;

public class snakeAndLadderGame {

    public static void main(String[] args) {
        System.out.println("Welcome to Snake and Ladder Game");
        int initialPos = 0;
        System.out.println("Player initial position is: " + initialPos);
        int diceRollCount = 0; // Counter to track the number of times the dice is rolled


        // Repeat the game until the player reaches the winning position
        while (initialPos < 100) {
            // Roll the dice
            int diceRoll = rollDie();
            diceRollCount++;
            System.out.println("Dice Roll: " + diceRoll);

            // Check for Options No Play, Ladder, or Snake
            int option = checkOption();
            System.out.println("Option: " + option);

            // Update player position based on the option
            initialPos = updatePosition(initialPos, diceRoll, option);
        }

        System.out.println("You have won! You've reached the winning position: " + initialPos);
        System.out.println("Number of times the dice was rolled to each 100: " + diceRollCount);
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
