package NumberToString;

import java.util.Scanner;

public class LiczbyTekstowo {

	public static void main(String[] args) throws InterruptedException {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("Podaj liczbę: ");
			String userString = scanner.nextLine();

			if (userString.equals("k")) {
				break;
			}

			System.out.println(userString + " " + Liczby.wartoscTekstowo(userString));
		}
		scanner.close();
	}

}
