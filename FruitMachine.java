//Miruna Andreea Lazar 2459499L

import javax.swing.SwingUtilities;

public class FruitMachine {
    public static void main(String [] args) {
//prevents program from crashing in some circumstances. refernce:https://www.youtube.com/watch?v=WRwPVZ4jmNY
    	SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new MainFrame();
			}
    	});           
    }
}