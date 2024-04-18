package application;

public class Node implements Comparable<Node>{

	private int freq;
	private char character;
	private Node left,right;
public static int order=0;
public int postion;
	


	public Node(int freq,char character) {
		this.freq = freq;
		this.character=character;
		this.left = this.right = null;
		 this.postion = order++;
		
	}
	
//	public Node(int freq,char character, Node left,Node Right ) {
//		this.freq = freq;
//		this.left=left;
//		this.right=Right;
//	   
//	}
	
	
//	public Node() {
//		this.left = this.right = null;
//	}



	@Override
	public String toString() {
		return "Node [freq=" + freq + ", character=" + character + "]";
	}


	public int getFreq() {
		return freq;
	}


	public char getCharacter() {
		return character;
	}


	public Node getLeft() {
		return left;
	}


	public Node getRight() {
		return right;
	}


	public void setFreq(int freq) {
		this.freq = freq;
	}


	public void setCharacter(char character) {
		this.character = character;
	}


	public void setLeft(Node left) {
		this.left = left;
	}


	public void setRight(Node right) {
		this.right = right;
	}
	
	public boolean isLeaf() {
		return left == null && right == null;
	}


	@Override
	public int compareTo(Node o) {
		 if (this.freq != o.freq) {
	            return Integer.compare(this.freq, o.freq);
	        } else if (this.character != o.character) {
	            // If characters are not '\0', compare them
	            if (this.character != '\0' && o.character != '\0') {
	                return Character.compare(this.character, o.character);
	            } else if (this.character == '\0') {
	                // If this.character is '\0', it comes before other characters
	                return 1;
	            } else {
	                // If o.character is '\0', it comes after other characters
	                return -1;
	            }
	        } else {
	            return Integer.compare(this.postion, o.postion);
	        }
	    }
		 
//	     if (this.freq != o.freq) {
//	            return Integer.compare(this.freq, o.freq);
//	        } else if (this.getFreq() == o.getFreq()) {
//	        	int r=this.character-o.getCharacter();
//	           
//	        } else {
//	        	return this.character-o.getCharacter();
//	        }
       
	       
	
}

