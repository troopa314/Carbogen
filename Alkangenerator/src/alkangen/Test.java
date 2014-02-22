/**
 * 
 */
package alkangen;

import javax.swing.JOptionPane;

/**
 * @author Umut
 *
 */
public class Test {
	
	public static void main(String[] args) {
		for(int i = 1; i <= 51; i++) {
			Kohlenwasserstoff k = new Kohlenwasserstoff(i, 2*i+1);
			JOptionPane.showMessageDialog(null,
					"Name des Kohlenwasserstoffes: " + k.getName()
					+ "\nAnzahl der C-Atome: " + k.getcAtome()
					+ "\nAnzahl der H-Atome: " + k.gethAtome()
					+ "\nTyp: " + Namegen.typToName(k.getTyp()));
		}
	}

}
