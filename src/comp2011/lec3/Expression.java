package comp2011.lec3;

public class Expression {

	public static boolean isMultipleBalanced(char[] s) {
		CharStack stack = new CharStack();
		for (int i = 0; i < s.length; i++) {
			if (s[i] == '(' || s[i] == '[' || s[i] == '{') stack.push(s[i]);
			if (s[i] == ')') {
				if (stack.isEmpty()) return false;
				char c = stack.pop();
				if (c != '(') return false;
			}
			if (s[i] == ']') {
				if (stack.isEmpty()) return false;
				char c = stack.pop();
				if (c != '[') return false;
			}
			if (s[i] == '}') {
				if (stack.isEmpty()) return false;
				char c = stack.pop();
				if (c != '{') return false;
			}
		}
		return stack.isEmpty();
	}

	public static boolean isBalanced(char[] s) {
		return false;
	}

	public static void main(String[] args) {
		String s = "(()(()))";
		System.out.println(s + (isBalanced(s.toCharArray()) ? " is " : " is not ") + "balanced.");
		s = "(()((()))";
		System.out.println(s + (isBalanced(s.toCharArray()) ? " is " : " is not ") + "balanced.");
		s = "{[]([])[]}";//"{ ( } )";
		System.out.println(s + (isMultipleBalanced(s.toCharArray()) ? " is " : " is not ") + "balanced.");
	}
}
