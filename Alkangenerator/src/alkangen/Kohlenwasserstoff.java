package alkangen;
/**
 * 
 * @author Troopa
 * @version 26.01.2014
 */



public class Kohlenwasserstoff {
	
	private int cAtome, hAtome;
	private String name;
	private int typ;
	
	public Kohlenwasserstoff(int cAtome, int hAtome) {
		this.cAtome = cAtome;
		this.hAtome = hAtome;
		this.name = new Namegen().generateName(this);
		this.typ = new Namegen().isValid(this);
	}
	
	public int getcAtome() {
		return cAtome;
	}

	public void setcAtome(int cAtome) {
		this.cAtome = cAtome;
	}

	public int gethAtome() {
		return hAtome;
	}

	public void sethAtome(int hAtome) {
		this.hAtome = hAtome;
	}
	
	public String getName()
	{
		return name;
	}

	public int getTyp() {
		return this.typ;
	}
}
