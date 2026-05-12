package pekan6_2511533020;

public class HapusDLL_2511533020 {
	// fungsi mengapus node awal
	public static NodeDLL_2511533020 de1Head(NodeDLL_2511533020 head_3020) {
		if (head_3020 == null) {
			return null; 		}
		NodeDLL_2511533020 temp = head_3020;
		head_3020 = head_3020.next_3020;
		if (head_3020 != null) 		{
			head_3020.prev_3020 = null; 	}
		return head_3020;
		}
	//fungsi menghapus di akhir
	public static NodeDLL_2511533020 de1Last(NodeDLL_2511533020 head_3020) {
		if (head_3020 == null) {
			return null; 		}
		if (head_3020.next_3020 == null)	{
			return null;		}
		NodeDLL_2511533020 curr = head_3020;
		while (curr.next_3020 != null) {
			curr = curr.next_3020;
		}
		// update pointer previous node
		if (curr.prev_3020 != null) {
			curr.prev_3020.next_3020 = null;	}
		return head_3020;
		}
	// fungsi menghapus node posisi tertentu 
	public static NodeDLL_2511533020 de1Pos(NodeDLL_2511533020 head_3020, int pos_3020) {
		// jika DLL kosong
		if (head_3020 == null) {
			return head_3020; 	}
		NodeDLL_2511533020 curr = head_3020;
		// telusuri sampai ke node yang akan dihapus
		for (int i_3020 = 1; curr != null && i_3020 < pos_3020; ++i_3020) {
			curr = curr.next_3020;	}
		// jika posisi tidak ditemukan
		if (curr == null) {
			return head_3020; 	}
		// Update pointer
		if (curr.next_3020 != null) {
			curr.prev_3020.next_3020 = curr.next_3020; 	}
		if (curr.next_3020 != null) {
			curr.next_3020.prev_3020 = curr.prev_3020;	}
		// Jika yang dihapus head
		if (head_3020 == curr) {
			head_3020 = curr.next_3020;		}
		return head_3020;
				
	}
		
	public static void printList(NodeDLL_2511533020 head_3020) {
		NodeDLL_2511533020 curr = head_3020;
		while (curr != null) {
			System.out.print(curr.data_3020 + " ->");
			curr = curr.next_3020;
		}
		System.out.println();
		
	}
	public static void main(String[] args) {
		// buat sebuah DLL
		NodeDLL_2511533020 head_3020 = new NodeDLL_2511533020(1);
		head_3020.next_3020 = new NodeDLL_2511533020(2);
		head_3020.next_3020.prev_3020 = head_3020;
		head_3020.next_3020.next_3020 = new NodeDLL_2511533020(3);
		head_3020.next_3020.next_3020.prev_3020 = head_3020.next_3020;
		head_3020.next_3020.next_3020.next_3020 = new NodeDLL_2511533020(4);
		head_3020.next_3020.next_3020.next_3020.prev_3020 = head_3020.next_3020.next_3020;
		head_3020.next_3020.next_3020.next_3020.next_3020 = new NodeDLL_2511533020 (5);
		head_3020.next_3020.next_3020.next_3020.next_3020.prev_3020 = 		head_3020.next_3020.next_3020.next_3020;
		
		System.out.print("DLL Awal: ");
		printList(head_3020);
		
		System.out.print("Setelah head dihapus: ");
		head_3020 = de1Head(head_3020);
		printList(head_3020);
		
		System.out.print("Setelah node terakhir dihapus: ");
		head_3020 = de1Last(head_3020);
		printList(head_3020);
		
		System.out.print("Menghapus Node Ke 2: ");
		head_3020 = de1Pos(head_3020, 2);
		
		printList(head_3020);
		
		
	}

}
