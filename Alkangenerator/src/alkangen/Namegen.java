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
		case Klassifizierungen.ALKAN : return "an";
		case Klassifizierungen.ALKEN : return "en";
		case Klassifizierungen.ALKIN : return "in";
		case Klassifizierungen.ALKANOL : return "anol";
		case Klassifizierungen.ALKENOL : return "enol";
		case Klassifizierungen.ALKINOL : return "inol";
		}
		return null;
	}
	
	public String generateName(Hydrocarbon h) {
		String name = generatePrefix(h) + generateSuffix(h);
		return name;
	}
	
	
	protected static String typToName(int typ) {
		switch(typ) {
		case Klassifizierungen.ALKAN : return "Alkan";
		case Klassifizierungen.ALKEN : return "Alken";
		case Klassifizierungen.ALKIN : return "Alkin";
		case Klassifizierungen.ALKANOL : return "Alkanol";
		case Klassifizierungen.ALKENOL : return "Alkenol";
		case Klassifizierungen.ALKINOL : return "Alkinol";
		case Klassifizierungen.UNBEKANNT : return "Ungültig";
		}
		return null;
	}
	
	protected int isValid(Hydrocarbon h) {
		if(2 * h.getcAtome() + 2 == h.gethAtome()) {
			return Klassifizierungen.ALKAN;
		}
		else if(2 * h.getcAtome() == h.gethAtome() && generatePrefix(h) != "Meth") {
			return Klassifizierungen.ALKEN;
		}
		else if(2 *h.getcAtome() - 2 == h.gethAtome() && generatePrefix(h) != "Meth") {
			return Klassifizierungen.ALKIN;
		}
		else if(2 * h.getcAtome() + 1 == h.gethAtome()) {
			return Klassifizierungen.ALKANOL;
		}
		return -1;
	}
	
}
