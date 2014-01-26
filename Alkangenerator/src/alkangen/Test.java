/**
 * 
 */
package alkangen;

import java.io.*;

import javax.swing.JOptionPane;

/**
 * @author Umut
 *
 */
public class Test {
	
	public static void main(String[] args) throws IOException {
		int m = 0;
		int max = Integer.parseInt(JOptionPane.showInputDialog("Maximalwert:"));
		int typ = Integer.parseInt(JOptionPane.showInputDialog("Typ der zu generierenden Kohlenwasserstoffe: "));
		if(typ >= 100){ typ = 99; }
		Writer fw = null;
		File file = new File("Kohlenwasserstoffe.txt");
		try{fw = new FileWriter(file);} catch(IOException e){};
		if(typ == Klassifizierungen.ALKAN) {
			m = 2;
		}
		else if(typ == Klassifizierungen.ALKEN) {
			m = 0;
		}
		else if(typ == Klassifizierungen.ALKIN) {
			m = -2;
		}
		else if(typ == Klassifizierungen.ALKANOL) {
			m = 1;
		}
		for(int i = 1; i <= max; i++) {
			Kohlenwasserstoff k = new Kohlenwasserstoff(i, 2*i+m);
				fw.write("Name: " + k.getName());
				fw.append( System.getProperty("line.separator") );
				fw.write("C-Atome: " + k.getcAtome());
				fw.append( System.getProperty("line.separator") );
				fw.write("H-Atome: " + k.gethAtome());
				fw.append( System.getProperty("line.separator") );
				fw.write("Typ: " + Namegen.typToName(k.getTyp()));
				fw.append( System.getProperty("line.separator") );
				fw.write("____________________");
				fw.append( System.getProperty("line.separator") );
		}
			fw.close();
	}

}
