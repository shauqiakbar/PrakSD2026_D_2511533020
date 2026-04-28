package pekan4_2511533020;
import java.util.*;

public class ReverseData_2511533020 {
	public static void main(String[] args) {
		Queue<Integer> q_3020 = new LinkedList<Integer>();
		q_3020.add(1);
		q_3020.add(2);
		q_3020.add(3);
		System.out.println("sebelum reverse" + q_3020);
		Stack<Integer> s_3020 = new Stack<Integer>();
		while(!q_3020.isEmpty()) { //Q -> S
			s_3020.push(q_3020.remove());
		}
		while (!s_3020.isEmpty()) {
			q_3020.add(s_3020.pop());
			
		}
		System.out.println("sesudah reverse= " + q_3020);
	}
}
