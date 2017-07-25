import java.util.ArrayList;

/*
 * Node for a TST that has spellchecking capabilities to store the most popular words found under it.
 * countArr contains the count of the most popular Strings under it and stringArr holds the corresponding words for the counts.
 */
public class Node {
	private Node right, middle, left;
	private boolean isWordEnd;
	private char letter;
	private int frequency;
	private int id;
	private Node previous;
	//Constructor that sets the letter.
	public Node(char letter){
		frequency=0;
		this.letter = letter;
		isWordEnd = false;
	}

	//Constructor that sets the lett
	public Node(char letter, int id){
		frequency=0;
		this.letter = letter;
		isWordEnd = false;
		this.id = id;
	}

	//Constructor that sets the letter and isWordEnd values;
	public Node(char letter, boolean isWordEnd){
		this(letter);
		this.isWordEnd = isWordEnd;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public Node getMiddle() {
		return middle;
	}

	public void setMiddle(Node middle) {
		this.middle = middle;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public boolean isWordEnd() {
		return isWordEnd;
	}

	public void setWordEnd(boolean isWordEnd) {
		this.isWordEnd = isWordEnd;
	}

	public char getLetter() {
		return letter;
	}

	public void setLetter(char letter) {
		this.letter = letter;
	}

	public int getID(){
		return id;
	}

	public int setFrequency(int frequency){
		this.frequency = frequency;
		return frequency;
	}

	public int increaseFrequency(){
		frequency++;
		return  frequency;
	}

	public int getFrequency(){
		return frequency;
	}

	public void setPrev(Node previous){
		this.previous = previous;
	}

	public Node getPrev(){
		return previous;
	}

	public String getWord(){
		return "FILLER";
	}

	public String toString(){
		String str = "|";
		if(getLeft()!=null) str+=getLeft().getLetter()+":";
		if(getMiddle()!=null) str+=getMiddle().getLetter();
		if(getRight()!=null) str+=":"+getRight().getLetter();
		return str+"|";
	}
}
