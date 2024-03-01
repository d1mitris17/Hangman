package hangman;

public class Run {

	public static void main(String[] args) {
			MainWindow mw = new MainWindow();
			mw.setVisible(true);
			int i;
			int n =0;
			do {
				n += 1;
				i = mw.removeLife();
				System.out.println(n);
			} while(i == 0);
	}

}
