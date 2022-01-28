package NumberToString;

public class Liczby extends Slownik {

	public static String wartoscTekstowo(String userString) {

		String slownie = "";

		if (userString.length() < 1) {
			return "";
		}
		int liczba = Integer.parseInt(userString);

		switch (userString.length()) {

		case 1: {
			slownie += " " + getJednosci(liczba);
			break;
		}

		case 2: {
			slownie += " " + getDziesiatki(liczba);
			break;
		}

		case 3: {
			slownie += " " + getSetki(liczba);
			break;
		}

		case 4: {
			slownie += " " + getTysiac(liczba);
			break;
		}
		case 5:
			slownie += getDziesiatki(liczba / 1000) + " " + Slownik.tysiac[2] + " " + getSetki(liczba % 1000);
			break;
		case 6:
			slownie += getSetki(liczba / 1000) + " " + Slownik.tysiac[2] + " " + getSetki(liczba % 1000);
			break;

		case 7:
			slownie += getJednosci(liczba / 1000000) + " " + Slownik.milion[0] + " " + getSetki(liczba % 1000);
			break;
		default:
			slownie += liczba;
			break;
		}
		return slownie;
	}

	public static String getJednosci(int liczba) {
		return Slownik.jednosci[liczba];
	}

	public static String getDziesiatki(int liczba) {

		if (liczba == 0) {
			return "";
		}

		if (liczba < 10) {
			return getJednosci(liczba);
		}

		if (liczba % 10 == 0) {
			int li = liczba / 10;
			switch (li) {
			case 1:
				return Slownik.dziesiatki[0];
			case 2:
				return getJednosci(li) + Slownik.dziesiatki[3];
			case 3:
			case 4:
				return getJednosci(li) + Slownik.dziesiatki[4];
			default:
				return getJednosci(li) + Slownik.dziesiatki[5];
			}
		} else if (liczba % 10 != 0 && liczba < 20) {
			int li = liczba % 10;
			switch (li) {
			case 1:
				return getJednosci(li) + Slownik.dziesiatki[1];
			case 9:
				return getJednosci(li + 1) + Slownik.dziesiatki[2];
			default:
				return getJednosci(li) + Slownik.dziesiatki[2];
			}
		} else {
			int li = liczba % 10;
			switch (li) {
			default:
				return getDziesiatki(liczba / 10 * 10) + " " + getJednosci(li);
			}
		}
	};

	public static String getSetki(int liczba) {

		int li = liczba / 100;
		String slownie = "";
		switch (li) {
		case 1:
			slownie = Slownik.setki[0];
			break;
		case 2:
			slownie = Slownik.setki[1];
			break;
		case 3:
		case 4:
			slownie = getJednosci(li) + Slownik.setki[2];
			break;
		default:
			slownie = getJednosci(li) + Slownik.setki[3];
			break;
		}

		return slownie + " " + getDziesiatki(liczba % 100);
	};

	public static String getTysiac(int liczba) {

		int li = liczba / 1000;
		String slownie = "";
		switch (li) {
		case 1:
			slownie = tysiac[0] + " " + getSetki(liczba / 10);
			break;
		case 2:
		case 3:
		case 4:
			slownie = getJednosci(li) + " " + tysiac[1] + " " + getSetki(liczba / 10);
			break;
		default:
			slownie = getJednosci(li) + " " + tysiac[2] + " " + getSetki(liczba / 10);

		}
		return slownie;
	};

	public static String getMilion(int liczba) {
		int li = liczba / 1000;
		String slownie = "";
		switch (li) {
		case 1:
			slownie = tysiac[0] + " " + getSetki(liczba / 10);
			break;
		case 2:
		case 3:
		case 4:
			slownie = getJednosci(li) + " " + tysiac[1] + " " + getSetki(liczba / 10);
			break;
		default:
			slownie = getJednosci(li) + " " + tysiac[2] + " " + getSetki(liczba / 10);

		}
		return slownie;
	}

}
