import java.util.Random;

public class snakeAndLadderGame {

    public static void main(String[] args) {
        System.out.println("Welcome to Snake and Ladder Game");
        int initialPos = 0;
        System.out.println("Player initial position is: " + initialPos);

        // roll the dice  --> rollDie() method
        int diceRoll = rollDie();
        System.out.println("Dice Roll: " + diceRoll);

        // Check for Options No Play, Ladder, or Snake checkOption() method
        int option = checkOption();
        System.out.println("Option: " + option);

        // Update player position based on the option
        updatePosition(initialPos, diceRoll, option);
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
     */
    private static void updatePosition(int currentPosition, int diceRoll, int option) {
        switch (option) {
            case 0:
                System.out.println("No Play.");
                break;
            case 1:
                System.out.println("Ladder! Player moves ahead by " + diceRoll + " positions.");
                currentPosition += diceRoll;
                if (currentPosition > 100) {
                    currentPosition = 100 - currentPosition; // Player cannot go above position 100
                }
                break;
            case 2:
                System.out.println("Snake! Player moves behind by " + diceRoll + " positions.");
                currentPosition -= diceRoll;
                if (currentPosition < 0) {
                    currentPosition = 0; // Player cannot go below position 0
                }
                break;
        }

        System.out.println("New Position: " + currentPosition);
    }

}
