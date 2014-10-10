import java.util.*;

public class Pig {
  public static void main(String[] args) {
    playGame();
  }

    public static void writeBlank(int number) {
      for (int i = 1; i <= number; i++) {
        System.out.println();
      }
    }

    public static int rollDice() {
      Random r = new Random();
      int number = r.nextInt(6) + 1;
      return number;
  }

    public static int turnComputer() {
      int counter = 1;
      int sum = 0;

      while (counter <= 4) {
        int roll = rollDice();

        if (roll == 1) {
          sum = 0;
          counter = 5;
        } else {
          sum = sum + roll;
          counter++;
        }
        writeBlank(1);
        System.out.println("Points so far = " + sum);
      }

      writeBlank(1);
      System.out.println("This turn the computer gained " + sum + " points!");
      return sum;
    }

    public static int turnPlayer() {
      Scanner console = new Scanner(System.in);
      int sum = 0;
      int choice = 1;

      do {
        writeBlank(1);
        System.out.print("Do you wish to roll(type 1), or hold(type 2)?: ");
        choice = console.nextInt();
        int roll = rollDice();

        if (choice == 2) {
          break;
        } else if (roll == 1) {
          sum = 0;
          choice = 2;
        } else {
          sum = sum + roll;
        }

        writeBlank(1);
        System.out.println("Points so far = " + sum);
      } while (choice == 1);

      writeBlank(1);
      System.out.println("This turn you gained " + sum + " points!");
      return sum;
    }

    public static void playGame() {
      int computerTotal = 0;
      int playerTotal = 0;

      while(computerTotal < 100 && playerTotal < 100) {
        writeBlank(2);
        System.out.println("Players Turn!");
        int playerSum = turnPlayer();
        playerTotal = playerTotal + playerSum;
        writeBlank(1);
        System.out.println("Players total = " + playerTotal);

        if (playerTotal >= 100) {
          break;
        }

        writeBlank(2);
        System.out.println("Computers Turn!");
        int computerSum = turnComputer();
        computerTotal = computerTotal + computerSum;
        writeBlank(1);
        System.out.println("Computers total = " + computerTotal);
      }

      if (computerTotal >= 100) {
        writeBlank(2);
        System.out.println("Computer Wins!");
      } else if (playerTotal >= 100) {
        writeBlank(2);
        System.out.println("You win!");
      } else {
        writeBlank(2);
        System.out.println("You tied!");
      }
    }
}
