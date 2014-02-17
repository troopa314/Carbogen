package alkangen;
/**
 * 
 * @author Troopa
 * @version 26.01.2014
 */



public class Hydrocarbon {
	
	private int cAtoms, hAtoms;
	private String name;
	private int type;
	
	public Hydrocarbon(int cAtoms, int hAtoms) {
		this.cAtoms = cAtoms;
		this.hAtoms = hAtoms;
		this.name = new Namegen().generateName(this);
		this.type = new Namegen().isValid(this);
	}
	
	public int getcAtome() {
		return cAtoms;
	}

	public void setcAtome(int cAtoms) {
		this.cAtoms = cAtoms;
	}

	public int gethAtome() {
		return hAtoms;
	}

	public void sethAtome(int hAtoms) {
		this.hAtoms = hAtoms;
	}
	
	public String getName()
	{
		return name;//Wieso überall außer hier this ? :D
	}

	public int getType() {
		return this.type;
	}
}
