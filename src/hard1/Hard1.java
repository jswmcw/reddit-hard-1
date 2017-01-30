/**
 * 
 * @author JeremyW
 * https://www.reddit.com/r/dailyprogrammer/comments/pii6j/difficult_challenge_1/
 * 
 */
package hard1;
import java.io.IOException;
import java.util.Scanner;

public class Hard1 {
	private int guess = 50;
	private int topLimit = 100;
	private int bottomLimit = 0;
	private int guessCount = 0;
	private Scanner sc = new Scanner(System.in);
	
	private boolean checkGuess() {
		String answer;
		do {
			System.out.printf("Is your number %d? (y/n): ", guess);
			answer = sc.nextLine().toUpperCase();
			if (answer.equals("Y")) {
				guessCount++;
				return true;
			}
			else if (answer.equals("N")) {
				guessCount++;
				if (checkHighLow() > 0) {
					bottomLimit = guess;
					guess = guess + (topLimit - bottomLimit) / 2;
				}
				else {
				    topLimit = guess;
					guess = guess - (topLimit - bottomLimit) / 2;
				}
			}
		} while (!answer.equals("Y") && !answer.equals("N"));
		
		return false;
		
	}
	
	private int checkHighLow() {
		String answer;
		do {
			System.out.printf("Is your number higher or lower than %d? (h/l): ", guess);
			answer = sc.nextLine().toUpperCase();
			if (answer.equals("H")) {
				if (topLimit - bottomLimit <= 2) guess++;
				return 1;
			}
		} while (!answer.equals("H") && !answer.equals("L"));
		if (topLimit - bottomLimit <= 2) guess--;
		return -1;
		
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println("Choose a whole number from 1 to 100 and i will guess it 8 tries or less!\n"
				+ "Press [Enter] when ready ");
		System.in.read();
		Hard1 guesser = new Hard1();
		while (!guesser.checkGuess());
		guesser.sc.close();
		System.out.printf("Your number is %s and I found it in %s tries!", guesser.guess, guesser.guessCount);
		
	}

}
