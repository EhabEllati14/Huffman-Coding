package application;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class HuffTable {
	private SimpleStringProperty ASCII ;
	private SimpleIntegerProperty Length;
	private SimpleStringProperty bytecode;
	private SimpleStringProperty huffmanCode;
	private SimpleIntegerProperty frequencey;
	
	public HuffTable(String s1,String s3,String s4,int s2,int s5) {
		
		ASCII=new SimpleStringProperty(s1);
		 Length= new SimpleIntegerProperty(s2);
		 bytecode=new SimpleStringProperty(s3);
		 huffmanCode=new SimpleStringProperty(s4);
		 frequencey=new SimpleIntegerProperty(s5);
	}

	public String getASCII() {
		return ASCII.get();
	}

	public int getLength() {
		return Length.get();
	}

	public String getBytecode() {
		return bytecode.get();
	}

	public String getHuffmanCode() {
		return huffmanCode.get();
	}

	public int getFrequencey() {
		return frequencey.get();
	}
	public void setASCII(String r) {
		ASCII.set(r);
	}

	public void setLength(int r) {
		Length.set(r);
	}

	public void setBytecode(String r) {
	    bytecode.set(r);
	}

	public void setHuffmanCode(String r) {
		huffmanCode.set(r);
	}

	public void setFrequencey(int r) {
		frequencey.set(r);
	}


}


