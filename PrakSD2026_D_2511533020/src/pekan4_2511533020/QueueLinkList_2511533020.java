package pekan4_2511533020;

import java.util.*;

public class QueueLinkList_2511533020 {

	public static void main(String[] args) {
		Queue<Integer> q_3020 = new LinkedList<>() ;
		// tambah elemen {0, 1, 2, 3, 4, 5} ke antrian
		
		for (int i_3020 = 0; i_3020 < 6; i_3020++) 
			q_3020.add(i_3020);
			//Menampilkan isi antrian.
			System.out.println("Elemen antrian " + q_3020);
			//Untuk menghapus kepala antrian.
			int hapus_3020 = q_3020.remove();
			System.out.println(q_3020);
			//Untuk melihat antrian terdepan
			int depan_3020 = q_3020.peek();
			System.out.println("Kepala Antrian = " + depan_3020);
			
			int banyak_3020 = q_3020.size();
			System.out.println("Size Antrian = " + banyak_3020);
		}
		

	

}
