import java.util.*;
public class Postfix {
	
	public static void main(String[] args) {
		System.out.println(postfixEvaluate("6 8 2 / 1 - *"));
		System.out.println(postfixEvaluate("8 5 * 7 4 2 + * +"));
		System.out.println(postfixEvaluate("2 3 + 4 5 * +"));
	}
	
	public static int postfixEvaluate(String s) {
	// Using a stack to track all the numbers and temporary results
		Stack<Integer> st = new Stack<Integer> ();
		Scanner next = new Scanner(s);
		//test until we have next opcode or operator. 
		while (next.hasNext()) {
			//if it's operand
			if (next.hasNextInt()) {
				st.push(next.nextInt());
			}   //if it's operator
			else {
				// pop the top 2 elements from the stack
				int num2 = st.pop();   
				int num1 = st.pop();
				String curr = next.next();
				
				if (curr.equals("+")) {
					st.push(num1 + num2);
				} else if (curr.equals("-")) {
					st.push(num1 - num2);
				} else if (curr.equals("*")) {
					st.push(num1 * num2);
				} else {
					st.push(num1 / num2);
				}
			}
		}
		return st.pop();
    }
}
	

