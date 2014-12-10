import java.util.Scanner;
/*
 * igrica Iks - Oks radjena 27.11.2014. godine
 * za zadacu:
 * ispravite ispis i zavrsite funkcije za provjeru nerjesenog rezultata i ispis nerjesenog rezultata i pobjednika
 * treba prepraviti ne radi dobro
 */

public class IksOks {

	public static void main(String[] args) {
		igrajIgricuIksOks('X', 'O', ' ');
	}

	private static void igrajIgricuIksOks(char prviIgrac, char drugiIgrac, char nijedanIgrac) {
		int aktivniIgrac = 0; //0 - igrac X; 1 - igrac O
		String izabranoPolje = null;
		char[][] poljanaZaIgru = new char[3][3];
		boolean krajIgre = false;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				poljanaZaIgru[i][j] = nijedanIgrac;
			}
		}
		
		do {
			do {
				izabranoPolje = unesiPolje(aktivniIgrac);
			} while (!izabranoPoljeJeIspravno(izabranoPolje, poljanaZaIgru, nijedanIgrac));
			postaviPolje((aktivniIgrac == 0 ? prviIgrac : drugiIgrac), izabranoPolje, poljanaZaIgru);
			krajIgre = krajIgre(poljanaZaIgru, nijedanIgrac);
			if (!krajIgre) {
				aktivniIgrac = promijeniAktivnogIgraca(aktivniIgrac);
			}
			ispisiStanjeIgrice(poljanaZaIgru);
		} while (!krajIgre);
		if (nemaPobjednika(poljanaZaIgru)) {
			ispisiRemi();
		} else {
			ispisiPobjednika(aktivniIgrac);
		}
	}

	private static void ispisiStanjeIgrice(char[][] poljanaZaIgru) {
		for (int i = 0; i< 3; i++) {
			System.out.printf("+---+---+---+\n| %s | %s | %s |\n", poljanaZaIgru[i][0], poljanaZaIgru[i][1], poljanaZaIgru[i][2]);
		}
		System.out.println("+---+---+---+");
	}

	private static void ispisiPobjednika(int aktivniIgrac) {
		// TODO Auto-generated method stub
		
	}

	private static void ispisiRemi() {
		// TODO Auto-generated method stub
		
	}

	private static boolean nemaPobjednika(char[][] poljanaZaIgru) {
		// TODO Auto-generated method stub
		return false;
	}

	private static int promijeniAktivnogIgraca(int aktivniIgrac) {
		return 1 - aktivniIgrac;
	}

	private static boolean krajIgre(char[][] poljanaZaIgru, char nijedanIgrac) {
		int popunjenihPolja = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (poljanaZaIgru[i][j] != nijedanIgrac) {
					popunjenihPolja++;
				}
			}
		}
		if (popunjenihPolja == 9) {
			return true;
		}
		for (int i = 0; i < 3; i++) {
			boolean kraj = false;
			kraj = (poljanaZaIgru[i][0] != nijedanIgrac) && (poljanaZaIgru[i][0] == poljanaZaIgru[i][1]) && (poljanaZaIgru[i][0] == poljanaZaIgru[i][2]);
			if (kraj == true) {
				return true;
			}
			kraj = (poljanaZaIgru[0][i] != nijedanIgrac) && (poljanaZaIgru[0][i] == poljanaZaIgru[1][i]) && (poljanaZaIgru[0][i] == poljanaZaIgru[2][i]);
			if (kraj == true) {
				return true;
			}

		}
		boolean kraj = false;
		kraj = (poljanaZaIgru[0][0] != nijedanIgrac) && (poljanaZaIgru[0][0] == poljanaZaIgru[1][1]) && (poljanaZaIgru[0][0] == poljanaZaIgru[2][2]);
		if (kraj == true) {
			return true;
		}
		kraj = (poljanaZaIgru[2][0] != nijedanIgrac) && (poljanaZaIgru[2][0] == poljanaZaIgru[1][1]) && (poljanaZaIgru[2][0] == poljanaZaIgru[0][2]);
		if (kraj == true) {
			return true;
		}

		return false;
	}

	private static void postaviPolje(char igrac, String izabranoPolje,	char[][] poljanaZaIgru) {
		int polje = Integer.parseInt(izabranoPolje);
		poljanaZaIgru[(polje - 1) / 3][(polje - 1) % 3] = igrac;
	}

	private static boolean izabranoPoljeJeIspravno(String izabranoPolje,	char[][] poljanaZaIgru, char nijedanIgrac) {
		/*
		 * 7 8 9
		 * 4 5 6
		 * 1 2 3
		 */
		try {
			int polje = Integer.parseInt(izabranoPolje);
			if ((polje < 10) && (polje > 0)) {
				if (poljanaZaIgru[(polje - 1) / 3][(polje - 1) % 3] == nijedanIgrac) {
					return true;
				}
			}
		} catch (Exception e) {
		}
		return false;
	}

	private static String unesiPolje(int aktivniIgrac) {
		Scanner in = new Scanner(System.in);
		System.out.println("Unesi polje koje zalis odigrati:\n+---+---+---+\n| 7 | 8 | 9 |\n| 4 | 5 | 6 |\n| 1 | 2 | 3 |\n+---+---+---+");
		String str = in.nextLine();
//		System.out.println("uneseno je " + str);
		return str;
	}

}
