import java.util.Random;

public class snakeAndLadderGame {

    /*@name: main
     *@desc: intialize the intial position of player to 0
     */
    
    public static void main(String[] args) {
        System.out.println("Welcome to Snake and Ladder Game");
        int initialPos = 0;
        System.out.println("Player initial position is: " + initialPos);

        // Let's roll the dice using the rollDie method
        int diceRoll = rollDie();
        System.out.println("Dice Roll: " + diceRoll);
    }

    /*
     * @name: rollDie
     * @desc: Simulates rolling a six-sided die and returns the result.
     */
    private static int rollDie() {
        Random random = new Random();
        return random.nextInt(6) + 1; // Generate a random number between 1 and 6
    }
}
