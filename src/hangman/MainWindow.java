package hangman;

//import java.awt.*; // keep here in case it is needed
import javax.swing.JFrame;

public class MainWindow extends JFrame {
	private HealthPanel hp;
	
	public MainWindow(){
		this(7);
	}
	
	public MainWindow(int n){
		hp = new HealthPanel(n);
		this.setSize(600, 600);
		this.add(hp);
	}
	
	public int removeLife() {
		return this.hp.removeLife();
	}

}
