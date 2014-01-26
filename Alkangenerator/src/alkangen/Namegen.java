package alkangen;
import java.util.Random;

/**
 * 
 * @author Troopa
 * @version 26.01.2014
 */
public class Namegen {
	
	Random random1 = new Random();
	

	
	
	
	protected String generatePrefix(Hydrocarbon h) {
		boolean isValid = false;
		String prefix = null;
		while(!isValid) {
			int r = random1.nextInt(Alkanes.Prefixes.length - 1);
			if (r == h.getcAtome() - 1) {
				isValid = true;
				try{
				prefix = Alkanes.Prefixes[r];
				}
				catch(ArrayIndexOutOfBoundsException e) {
					prefix = Alkanes.Prefixes[0];
				}
				break;
			}	
			else {
				isValid = false;
			}
			
		}
		return prefix;
	}
	
	protected String generateSuffix(Hydrocarbon h) {
		switch(isValid(h)) {
		case Types.ALKANE : return "ane";
		case Types.ALKENE : return "ene";
		case Types.ALKINE : return "ine";
		case Types.ALKANOLE: return "anole";
		case Types.ALKENOLE : return "enole";
		case Types.ALKINOLE : return "inole";
		}
		return null;
	}
	
	public String generateName(Hydrocarbon h) {
		String name = generatePrefix(h) + generateSuffix(h);
		return name;
	}
	
	
	protected static String typToName(int typ) {
		switch(typ) {
		case Types.ALKANE : return "Alkane";
		case Types.ALKENE : return "Alkene";
		case Types.ALKINE : return "Alkine";
		case Types.ALKANOLE : return "Alkanole";
		case Types.ALKENOLE : return "Alkenole";
		case Types.ALKINOLE : return "Alkinole";
		case Types.UNKNOWN : return "Unknown";
		}
		return null;
	}
	
	protected int isValid(Hydrocarbon h) {
		if(2 * h.getcAtome() + 2 == h.gethAtome()) {
			return Types.ALKANE;
		}
		else if(2 * h.getcAtome() == h.gethAtome() && generatePrefix(h) != "Meth") {
			return Types.ALKENE;
		}
		else if(2 *h.getcAtome() - 2 == h.gethAtome() && generatePrefix(h) != "Meth") {
			return Types.ALKINE;
		}
		else if(2 * h.getcAtome() + 1 == h.gethAtome()) {
			return Types.ALKANOLE;
		}
		return -1;
	}
	
}
