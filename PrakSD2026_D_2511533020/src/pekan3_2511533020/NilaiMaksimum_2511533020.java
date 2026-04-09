package pekan3_2511533020;
import java.util.*;
public class NilaiMaksimum_2511533020 {
	public static int max_3020(Stack<Integer> s_3020) {
		Stack<Integer> backup_3020 = new Stack<Integer>();
		int maxValue_3020 = s_3020.pop();
		backup_3020.push(maxValue_3020) ;
		while (!s_3020.isEmpty()) {
			int next_3020 = s_3020.pop();
			backup_3020.push (next_3020);
			maxValue_3020 = Math.max(maxValue_3020, next_3020);
		}
		while (!backup_3020.isEmpty()) {
			s_3020.push(backup_3020.pop());
		}
		return maxValue_3020;
	}	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> s_3020 = new Stack<Integer>();
		s_3020.push(70);
		s_3020.push(12);
		s_3020.push(20);
		System.out.println("isi stack" + s_3020);
		System.out.println("Stack Teratas " + s_3020.peek());
		System.out.println("Nilai maksimum" + max_3020(s_3020));
		
	}

}
