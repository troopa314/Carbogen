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
		try{fw = new FileWriter(file);} catch(IOException e){e.printStackTrace();};
		//Somehow, switches do not work.
		if(typ == Types.ALKANE) {
			m = 2;
		}
		else if(typ == Types.ALKENE) {
			m = 0;
		}
		else if(typ == Types.ALKINE) {
			m = -2;
		}
		else if(typ == Types.ALKANOLE) {
			m = 1;
		}
		for(int i = 1; i <= max; i++) {
			Hydrocarbon h = new Hydrocarbon(i, 2*i+m);
				fw.write("Name: " + h.getName());
				fw.append( System.getProperty("line.separator") );
				fw.write("C-Atoms: " + h.getcAtome());
				fw.append( System.getProperty("line.separator") );
				fw.write("H-Atoms: " + h.gethAtome());
				fw.append( System.getProperty("line.separator") );
				fw.write("Type: " + Namegen.typToName(h.getType()));
				fw.append( System.getProperty("line.separator") );
				fw.write("____________________");
				fw.append( System.getProperty("line.separator") );
		}
			fw.close();
	}

}
