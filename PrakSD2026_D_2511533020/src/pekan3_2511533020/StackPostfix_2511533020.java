package pekan3_2511533020;

import java.util.Scanner;
import java.util.Stack;

public class StackPostfix_2511533020 {
		public static int postfixEvaluate(String expression) {
			Stack<Integer> s_3020 = new Stack<Integer>() ;
			Scanner input_3020 = new Scanner(expression);
			while (input_3020.hasNext()) {
				if (input_3020.hasNextInt()) {
					s_3020.push(input_3020.nextInt());
				} else {
					String operator_3020 = input_3020.next();
					int operand2_3020 = s_3020.pop();
					int operand1_3020 = s_3020.pop();
					if (operator_3020.equals("+")) {
						s_3020.push(operand1_3020 + operand2_3020);
					} else if (operator_3020.equals("-")) {
						s_3020.push(operand1_3020 - operand2_3020);
					} else if (operator_3020.equals("*")) {
						s_3020.push(operand1_3020 * operand2_3020);
					} else {
						s_3020.push(operand1_3020 / operand2_3020);
						
					}
					
				}
			}
			input_3020.close();
			return s_3020.pop();
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hasil postfix= "+postfixEvaluate("5 2 4 * + 7 -"));

	}

}
