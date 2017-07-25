import java.util.ArrayList;

/*
 * Ternary Search Tree
 */
public class TST {

	protected Node head;
	private int idCounter =0;
	
	//Delegates to overloaded add method in order to add a String to the TST
	public void add(String text){
		head = add(text, head ,0);
	}
	
	//Adds a String to the TST by recursively either adding a Node or moving down the tree every method call.
	public Node add(String text, Node currentNode, int index){
		if(currentNode == null){
			currentNode = new Node(text.charAt(index), idCounter++);
		}
		if(currentNode.getLetter()<text.charAt(index))
			currentNode.setRight(add(text, currentNode.getRight(), index));
		else if(currentNode.getLetter()>text.charAt(index))
			currentNode.setLeft(add(text, currentNode.getLeft(), index));
		else 
			if(index+1<text.length())
				currentNode.setMiddle(add(text, currentNode.getMiddle(), index+1));
			else currentNode.setWordEnd(true);	
		return currentNode;
	}

	private class edContainer{
		int frequency;
		String text;
		public edContainer(String text, int frequency){
			this.frequency = frequency;
			this.text = text;
		}
		public String toString(){
			return text+":"+frequency;
		}
	}

	public ArrayList<edContainer> getAllWordsUnderEditDistance(String text, int distance){
		ArrayList<edContainer> list = new ArrayList<edContainer>();
		getAllWordsUnderEditDistance(text,"", list, head);
		return list;
	}

	public void getAllWordsUnderEditDistance(String text, String cumulativeString, ArrayList<edContainer> list, Node currentNode){
	if (currentNode != null){
		getAllWordsUnderEditDistance(text, cumulativeString, list, currentNode.getLeft());
		getAllWordsUnderEditDistance(text, cumulativeString, list, currentNode.getRight());
		cumulativeString += currentNode.getLetter();
		if(LevenshteinDistance.editCount(text, cumulativeString)<3)
		if (currentNode.isWordEnd())
			list.add(new edContainer(cumulativeString, currentNode.getFrequency()));
		getAllWordsUnderEditDistance(text, cumulativeString, list, currentNode.getMiddle());
		}
	}

	public int setFrequency(String text, int frequency){
		Node endNode = retreiveEndNode(text);
		return (endNode==null)?0:endNode.setFrequency(frequency);
	}

	public int increaseFrequency(String text){
		Node endNode = retreiveEndNode(text);
		return (endNode==null)?0:endNode.increaseFrequency();
	}

	public int getFrequency(String text){
		Node endNode = retreiveEndNode(text);
		return endNode.getFrequency();
	}

	public Node retreiveEndNode(String text){
		return retreiveEndNode(text, head, 0);
	}

	public Node retreiveEndNode(String text, Node currentNode, int index){
		if(currentNode == null) return null;
		if(currentNode.getLetter()<text.charAt(index))
			return retreiveEndNode(text, currentNode.getRight(), index);
		else if(currentNode.getLetter()>text.charAt(index))
			return retreiveEndNode(text, currentNode.getLeft(), index);
		else
			if(index+1<text.length())
				return retreiveEndNode(text, currentNode.getMiddle(), index+1);
		return currentNode;
	}
	ArrayList<String> al;
	public String toString(){
	 al = new ArrayList<String>();
		toString(head, "");
		return al.toString();
	}


	private void toString(Node currentNode, String str){
		if (currentNode != null){		
			toString(currentNode.getLeft(), str);

			str = str + currentNode.getLetter();
			if (currentNode.isWordEnd())
				al.add(str);

			toString(currentNode.getMiddle(), str);
			str = str.substring(0, str.length() - 1);

			toString(currentNode.getRight(), str);
		}
	}

	public int size(){
		al = new ArrayList<String>();
		toString(head, "");
		return al.size();
	}
}
