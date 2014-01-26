/**
 * 
 */
package alkangen;

import java.io.*;

import javax.swing.JOptionPane;

/**
 * 
 * @author Troopa
 * @version 26.01.2014
 */

public class Test {
	
	public static void main(String[] args) throws IOException {
		int m = 0;
		int max = Integer.parseInt(JOptionPane.showInputDialog("Calculate until:"));
		int typ = Integer.parseInt(JOptionPane.showInputDialog("Type of the generated Hydrocarbons:"));
		if(typ >= 100){ typ = 99; }
		Writer fw = null;
		File file = new File("Hydrocarbons.txt");
		try{fw = new FileWriter(file);} catch(IOException e){};
		if(typ == Types.ALKAN) {
			m = 2;
		}
		else if(typ == Types.ALKEN) {
			m = 0;
		}
		else if(typ == Types.ALKIN) {
			m = -2;
		}
		else if(typ == Types.ALKANOL) {
			m = 1;
		}
		for(int i = 1; i <= max; i++) {
			Hydrocarbon h = new Hydrocarbon(i, 2*i+m);
				fw.write("Name: " + h.getName());
				fw.append( System.getProperty("line.separator") );
				fw.write("C-Atome: " + h.getcAtome());
				fw.append( System.getProperty("line.separator") );
				fw.write("H-Atome: " + h.gethAtome());
				fw.append( System.getProperty("line.separator") );
				fw.write("Typ: " + Namegen.typToName(h.getType()));
				fw.append( System.getProperty("line.separator") );
				fw.write("____________________");
				fw.append( System.getProperty("line.separator") );
		}
			fw.close();
	}

}
