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
		case Types.ALKAN : return "an";
		case Types.ALKEN : return "en";
		case Types.ALKIN : return "in";
		case Types.ALKANOL : return "anol";
		case Types.ALKENOL : return "enol";
		case Types.ALKINOL : return "inol";
		}
		return null;
	}
	
	public String generateName(Hydrocarbon h) {
		String name = generatePrefix(h) + generateSuffix(h);
		return name;
	}
	
	
	protected static String typToName(int typ) {
		switch(typ) {
		case Types.ALKAN : return "Alkan";
		case Types.ALKEN : return "Alken";
		case Types.ALKIN : return "Alkin";
		case Types.ALKANOL : return "Alkanol";
		case Types.ALKENOL : return "Alkenol";
		case Types.ALKINOL : return "Alkinol";
		case Types.UNBEKANNT : return "Ungültig";
		}
		return null;
	}
	
	protected int isValid(Hydrocarbon h) {
		if(2 * h.getcAtome() + 2 == h.gethAtome()) {
			return Types.ALKAN;
		}
		else if(2 * h.getcAtome() == h.gethAtome() && generatePrefix(h) != "Meth") {
			return Types.ALKEN;
		}
		else if(2 *h.getcAtome() - 2 == h.gethAtome() && generatePrefix(h) != "Meth") {
			return Types.ALKIN;
		}
		else if(2 * h.getcAtome() + 1 == h.gethAtome()) {
			return Types.ALKANOL;
		}
		return -1;
	}
	
}
