package pekan6_2511533020;

public class PenelusuranDLL_2511533020 {
	//fungsi penelusuran maju
	static void forwardTraversal(NodeDLL_2511533020 head_3020) {
		//memulai penelusuran head
		NodeDLL_2511533020 curr = head_3020;
		//lanjutkan sampai akhir 
		while (curr != null) {
			//print data
			System.out.print(curr.data_3020 + " <-> ");
			//pindah ke node berikutnya
			curr = curr.next_3020;
		}
		//print spasi
		System.out.println();
	}
	//fungsi penelusuran mundur 
	static void backwardTraversal (NodeDLL_2511533020 tail_3020) {
		// muali dari akhir
		NodeDLL_2511533020 curr = tail_3020;
		//lanjut sampai head
		while (curr != null) {
			//cetak data
			System.out.print(curr.data_3020 + " <-> ");
			//pindah ke node sebelumnya
			curr = curr.prev_3020;
		}
		//cetak spasi
		System.out.println();
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// cetak DLL
		NodeDLL_2511533020 head_3020 = new NodeDLL_2511533020(1);
		NodeDLL_2511533020 second_3020 = new NodeDLL_2511533020(2);
		NodeDLL_2511533020 third_3020 = new NodeDLL_2511533020(3);
		
		head_3020.next_3020 = second_3020;
		second_3020.prev_3020 = head_3020;
		second_3020.next_3020 = third_3020;
		third_3020.prev_3020 = second_3020;
		
		System.out.println("Penelusuran Maju:");
		forwardTraversal(head_3020);
		
		System.out.println("Penelusuran Mundur:");
		backwardTraversal(third_3020);

	}

}
