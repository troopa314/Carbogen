package alkangen;
import java.util.Random;
public class Namegen {
	
	Random random1 = new Random();
	String[] Alkane = {"Meth", "Eth", "Prop", "But", "Pent", "Hex", "Hept", "Oct", "Non", "Dec", "Undec", "Dodec" ,
			"Tridec", "Tetradec", "Pentadec", "Hexadec", "Heptadec", "Octadec", "Nonadec", "Icos", "Henicos", "Docos", "Tricos",
			"Tetracos", "Pentacos", "Hexacos", "Heptacos", "Octacos", "Nonacos", "Triacont", "Hentriacont", "Dotriacont",
			"Tritriacont", "Tetratriacont", "Pentatriacont", "Hexatriacont", "Heptatriacont", "Octatriacont",
			"Nonatriacont", "Tetracont", "Hentetracont", "Dotetracont", "Tritetracont", "Tetratetracont", "Pentatetracont",
			"Hexatetracont", "Heptatetracont", "Octatetracont", "Nonatetracont", "Pentacont"};

	
	
	
	protected String generatePrefix(int cAtome, int hAtome) {
		boolean isValid = false;
		String prefix = null;
		while(!isValid) {
			int r = random1.nextInt(Alkane.length - 1);
			if (r == cAtome - 1) {
				isValid = true;
				try{
				prefix = Alkane[r];
				}
				catch(ArrayIndexOutOfBoundsException e) {
					prefix = Alkane[0];
					
				}
				break;
			}	
			else {
				isValid = false;
			}
			
		}
		return prefix;
	}
	
	protected String generateSuffix(Kohlenwasserstoff k) {
		switch(isValid(k)) {
		case Klassifizierungen.ALKAN : return "an";
		case Klassifizierungen.ALKEN : return "en";
		case Klassifizierungen.ALKIN : return "in";
		case Klassifizierungen.ALKANOL : return "anol";
		case Klassifizierungen.ALKENOL : return "enol";
		case Klassifizierungen.ALKINOL : return "inol";
		}
		return null;
	}
	
	public String generateName(Kohlenwasserstoff k) {
		String name = generatePrefix(k.getcAtome(), k.gethAtome()) + generateSuffix(k);
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
		}
		return "Unbekannt";
	}
	
	protected int isValid(Kohlenwasserstoff k) {
		if(2 * k.getcAtome() + 2 == k.gethAtome()) {
			return Klassifizierungen.ALKAN;
		}
		else if(2 * k.getcAtome() == k.gethAtome()) {
			return Klassifizierungen.ALKEN;
		}
		else if(2 *k.getcAtome() - 2 == k.gethAtome()) {
			return Klassifizierungen.ALKIN;
		}
		else if(2 * k.getcAtome() + 1 == k.gethAtome()) {
			return Klassifizierungen.ALKANOL;
		}
		return -1;
	}
	
}
