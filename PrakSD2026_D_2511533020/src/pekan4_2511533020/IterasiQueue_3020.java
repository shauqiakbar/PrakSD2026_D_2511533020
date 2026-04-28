package pekan4_2511533020;
import java.util.*;
public class IterasiQueue_3020 {

	public static void main(String[] args) {
		
		Queue<String> q_3020 = new LinkedList<>();
		q_3020.add("Praktikum");
		q_3020.add("Struktur");
		q_3020.add("Data");
		q_3020.add("Dan");
		q_3020.add("Algoritma");
		Iterator<String> iterator_3020 = q_3020.iterator();
		while (iterator_3020.hasNext()) {
			System.out.print(iterator_3020.next() + " ");
		}
	}

}
