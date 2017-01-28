/**
 * 
 * @author jswmcw
 *
 */
package hard1;
import java.io.IOException;
import java.util.Scanner;

public class Hard1 {
	private int guess = 50;
	private int range = 50;
	private int guessCount = 0;
	
	private boolean checkGuess() {
		Scanner sc = new Scanner(System.in);
		
		System.out.printf("Is your number %d? (y/n): \n", guess);
		if (sc.hasNext() && sc.nextLine().equalsIgnoreCase("y")) {
			sc.close();
			return true;
		}
		guessCount++;
		if (checkHighLow() > 0) guess += (range /= 2);
		else guess -= (range /= 2);
		sc.close();
		return false;
		
	}
	
	private int checkHighLow() {
		Scanner sc = new Scanner(System.in);
		System.out.printf("Is your number higher or lower than %s? (h/l): ", guess);
		if (sc.hasNext() && sc.nextLine().equalsIgnoreCase("h")) {
			sc.close();
			return 1;
		}
		sc.close();
		return -1;
		
	}
	
	

	public static void main(String[] args) throws IOException {
		System.out.println("Choose a whole number from 1 to 100 and i will guess it within 7 tries!\n"
				+ "Press [Enter] when ready ");
		System.in.read();
		Hard1 guesser = new Hard1();
		while (!guesser.checkGuess()) {
			guesser.checkGuess();
		}
		System.out.printf("Your number is %s and I found it in %s tries!", guesser.guess, guesser.guessCount);
		/*if (!guesser.checkGuess()) {
			guesser.guessCount++;
			if (guesser.checkHighLow() > 0) guesser.guess += (guesser.range /= 2);
			else guesser.guess -= (guesser.range /= 2);
		}*/

	}

}
