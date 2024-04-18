package application;

public class SortListhuff {
	private String s;
	  private char character;
	  private int freq;
	 public SortListhuff(char character, String s,int freq){
		this. character=character;
		this.s=s;
		this.freq=freq;
		}

	@Override
	public String toString() {
		return "String=" + s+ ",  Char =" +  character+" freq="+freq;
	}



	public int getFreq() {
		return freq;
	}

	public void setFreq(int freq) {
		this.freq = freq;
	}

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}

	public void setCharacter(char character) {
		this.character = character;
	}

	public char getCharacter() {
		return character;
	}

}
