package application;

public class Nodestack {
	private char character;
	 private Nodestack next;
private Nodestack left;
private Nodestack right;

	 Nodestack(char character){
		 this.character=character;
		 this.left=null;
		 this.right=null;
	 }
	 
	public Nodestack getLeft() {
		return left;
	}

	public Nodestack getRight() {
		return right;
	}

	public void setLeft(Nodestack left) {
		this.left = left;
	}

	public void setRight(Nodestack right) {
		this.right = right;
	}

	public char getCharacter() {
		return character;
	}

	public void setCharacter(char character) {
		this.character = character;
	}

	public Nodestack getNext() {
		return next;
	}

	public void setNext(Nodestack next) {
		this.next = next;
	}

}


