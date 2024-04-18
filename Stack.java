package application;



public class Stack {
	Nodestack first;
	public static int countstacknodes=0;
	
	
//	public int countstack() {
//		Nodestack r =first;
//		int count=0;
//		while (r != null) {
//			count++;
//			r = r.getNext();
//		}
//		return count;
//	}
//	
	public void push(Nodestack newr) {
		if(first==null) {
			first=newr;
		}
		else {
			newr.setNext(first);
			first=newr;
		}
		countstacknodes++;
	}
	public Nodestack pop() {
		Nodestack temp=first;
		if(first==null) {
			System.out.println("The Stack is empty!!");
		//	return null;
		}
		else {
			first=first.getNext();
			temp.setNext(null);
		}
		countstacknodes--;
		return temp;
		
	}
	
	public boolean isEmpty() {
		if(first==null) {
			return true;
		}
		else {
			return false;
		}
	}
//	public void Printstack() {
//		StackNode r =first;
//		String d;
//		while (r != null) {
//			d=new SimpleDateFormat("MM/dd/yyyy").format(r.getMart().getDateofdeath());
//			Main.elements2.add(new MartTable(r.getMart().getName(),r.getMart().getAge(),d,r.getMart().getGender(),r.getMart().getSm()));
//			r = r.getNext();
//		}
//	}

}