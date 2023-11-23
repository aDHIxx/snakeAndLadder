import java.util.Random;

public class snakeAndLadderGame {
    public static void main(String[] args) {
        System.out.println("Welcome to Snake and Ladder Game");
        playGame();
    }

    private static void playGame() {
        int position = 0;
        int targetPosition = 100;
        int diceFaces = 6;
        int maxDiceRolls = 10;

        Random random = new Random();

        for (int i = 0; i < maxDiceRolls; i++) {
            int diceRoll = random.nextInt(diceFaces) + 1;
            System.out.println("Dice Roll: " + diceRoll);

            position += diceRoll;

            if (position > targetPosition) {
                int exceed = position - targetPosition;
                position = exceed;
            }

            position = checkSnakeAndLadder(position);

            System.out.println("Current Position: " + position);

            if (position == targetPosition) {
                System.out.println("Won!");
                break;
            }
        }
    }
    private static int checkSnakeAndLadder(int currPosition) {
        switch (currPosition) {
            case 14:
                System.out.println("Snake! Down to 7.");
                return 7;
            case 19:
                System.out.println("Snake! Down to 2.");
                return 2;
            case 27:
                System.out.println("Snake! Down to 9.");
                return 9;
            case 40:
                System.out.println("Snake! Down to 3.");
                return 3;
            case 50:
                System.out.println("Snake! Down to 5.");
                return 5;
            case 7:
                System.out.println("Ladder! Up to 14.");
                return 14;
            case 16:
                System.out.println("Ladder! Up to 27.");
                return 27;
            case 32:
                System.out.println("Ladder! Up to 70.");
                return 70;
            case 46:
                System.out.println("Ladder! Up to 50.");
                return 50;
            case 49:
                System.out.println("Ladder! Up to 67.");
                return 67;
            default:
                return currPosition;

    }
}
}
