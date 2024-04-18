package application;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Huffman {
	public static int p=0;
	
	public Huffman() {
		
	}
	
public void BuildTreeofPriority(int arr[],char[] arr2,PriorityQueue<Node> q,List<SortListhuff> result, Map<Character, String> res){
	for(int i=0 ; i<arr.length;i++) {
		Node temp=new Node(arr[i],arr2[i]);
		temp.setLeft(null);
		temp.setRight(null);
			q.add(temp);
		}

	while(q.size()>1) {
	Node z=null;
	Node a=q.poll();
	Node b=q.poll();
//System.out.println("1 -->  "+a.getCharacter()+"  -->  "+a.getFreq() +" left  "+a.getLeft()+"  right  "+a.getRight());
//System.out.println("2 -->  "+b.getCharacter()+" -->  "+b.getFreq() +"  left  "+b.getLeft()+"  right  "+b.getRight());
	z= new Node(a.getFreq()+b.getFreq(),'\0');
z.setLeft(a);
z.setRight(b);
//	System.out.println("3"+z.getCharacter()+" --> "+z.getFreq() +"left"+z.getLeft()+"right"+z.getRight());
	q.add(z);
	}
	Node root =q.peek();
	printLeafPaths(root,result,"",res);
	
}

    public void stringheader(Node root) {
	if(root!=null) {
	   stringheader(root.getLeft());
       stringheader(root.getRight());
     if (root.getLeft() == null && root.getRight() == null) {
  	if (p==0) {
  		Main.head="1"+String.valueOf(root.getCharacter());
  		p++;
  	}
  	else {
     Main.head=Main.head+"1"+String.valueOf(root.getCharacter());
     }
  }
  else{
    Main.head=Main.head+"0";	
  }
	}
	
}
	
	




//	public static List<SortListhuff> getResult() {
//	return result;
//}
//
//public static void setResult(List<SortListhuff> result) {
//	Huffman.result = result;
//}


	public void printLeafPaths(Node root, List<SortListhuff> result,String code,Map<Character, String> res) {
       if(root==null) {
	   return;
       }
            printLeafPaths(root.getLeft(),result, code+"0",res);
	        printLeafPaths(root.getRight(),result,code+"1",res);
	        if (root.getLeft() == null && root.getRight() == null) {
	        	res.put(root.getCharacter(), code);
	            result.add(new SortListhuff(root.getCharacter(),code,root.getFreq()));
	           }
	}
	
	public void printLeafPathsdecom(Nodestack root,String code,Map<Character, String> res) {
	       if(root!=null) {
		   
	       
	            printLeafPathsdecom(root.getLeft(), code+"0",res);
		        printLeafPathsdecom(root.getRight(),code+"1",res);
		        if (root.getLeft() == null && root.getRight() == null) {
		        	res.put(root.getCharacter(), code);
		           }}
		}
}
	
