package comp2011.mid;

public class Expression {

	public static boolean isMultiBalanced(String s) {
		CharStack stack = new CharStack();
		System.out.println("In this running, I'll also print out the content of the stack after dealing with each character.");
		System.out.println("If you don't want to see them, comment out Line 16.");
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c == '('|| c == '[' || c == '{') stack.push(c);
			else if(c == ')' || c == ']'  || c == '}') {
			    if( stack.isEmpty() ) return false;
				int d = c - stack.pop();
				if (d < 0 || d > 2) return false;
			}
			System.out.println(stack);
		}
		return stack.isEmpty();
	}
	
	/*
	 * This is the only difficult question.
	 * The main difficulties are 
	 * (1) a ] doesn't eat up all ['s;  ("[[[]]" is balanced.) and
	 * (2) only ORIGINALLY CONSECUTIVE is counted ("[()[]" is not balanced.).
	 * 
	 * Most answers I have seen fail to take care of (1).
	 */
	public static boolean isGeneralizedBalanced(String s) {
		return false;
	}

	public static boolean isBalanced(String s) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(') count++;
			else if (c == ')') count--;
			if (count < 0) return false;
		}
		return count == 0;
	}
	
	public static void main(String[] args) {
		String s = "(()(()))";
		System.out.println(s + (isBalanced(s) ? " is " : " is not ") + "balanced.");
		s = "(()((()))";
		System.out.println(s + (isBalanced(s) ? " is " : " is not ") + "balanced.");
		String[] ss = {"{[]([])[]}", "[[((()]]", "[[[]]", "[()[(()]", "())"}; 
		System.out.println(s + (isMultiBalanced(s) ? " is " : " is not ") + "balanced.");
		for (int i = 0; i < ss.length; i++) 
		    System.out.println(ss[i] + 
		            (isGeneralizedBalanced(ss[i]) ? " is " : " is not ") + "balanced.");
	}

}
