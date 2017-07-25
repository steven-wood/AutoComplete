/*
 * enum that contains values and methods that make converting keycodes to chars very easy.
 */
public enum KeyboardProcessor {
	SHIFT(54, ""),
	ENTER(28, ""),
	SPACE(57, " "),
	LEFTSHIFT(58, ""),
	CAPSLOCK(42, ""),
	BACKSPACE(14,""),
	Q(16, "q"),
	W(17, "w"),
	E(18, "e"),
	R(19, "r"),
	T(20, "t"),
	Y(21, "y"),
	U(22, "u"),
	I(23, "i"),
	O(24, "o"),
	P(25, "p"),
	A(30, "a"),
	S(31, "s"),
	D(32, "d"),
	F(33, "f"),
	G(34, "g"),
	H(35, "h"),
	J(36, "j"),
	K(37, "k"),
	L(38, "l"),
	Z(44, "z"),
	X(45, "x"),
	C(46, "c"),
	V(47, "v"),
	B(48, "b"),
	N(49, "n"),
	M(50, "m"),
	BACKSLASH(43, ""),
	LEFTCTRL(29, "");
	
    private final int keyCode;
    private final String s;
    
    //Constructor that takes in an int and String and sets them to private variables.
	KeyboardProcessor(int keyCode, String s){
		this.keyCode = keyCode;
		this.s = s;
	}
	
	public int getKeyNum() {
        return this.keyCode;
    }
	
	//Returns the String of the value.
	public String getString(){
		return s;
	}
	
	//Returns the string of the given KeyCode.
	public static String getString(int code){
		for(KeyboardProcessor e: KeyboardProcessor.values()) 
		    if(e.keyCode == code) 
		      return e.getString();
		  return "";	  
	}
}
