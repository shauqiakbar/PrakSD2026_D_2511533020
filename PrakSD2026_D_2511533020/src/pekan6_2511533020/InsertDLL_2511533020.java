package pekan6_2511533020;

public class InsertDLL_2511533020 {
	//menambahkan node di awal DLL
	static NodeDLL_2511533020 insertBegin(NodeDLL_2511533020 head_3020, int data_3020) {
		//buat node baru
		NodeDLL_2511533020 new_node = new NodeDLL_2511533020(data_3020);
		// jadikan pointer nextnya head
		new_node.next_3020 = head_3020;
		//jadikan pointer prev head ke new_node
		if (head_3020 != null) {
			head_3020.prev_3020 = new_node;
		}
		return new_node;
	}
		//fungsi menambhakan node di akhir
	public static NodeDLL_2511533020 insertEnd(NodeDLL_2511533020 head_3020, int newData_3020) {
		//buat node baru
		NodeDLL_2511533020 newNode = new NodeDLL_2511533020(newData_3020);
		//jika dll null jadikan head
		if (head_3020 == null) {
			head_3020 = newNode;
		}
		else {
			NodeDLL_2511533020 curr = head_3020;
			while (curr.next_3020 != null ) {
				curr = curr.next_3020;
			}
			curr.next_3020 = newNode;
			newNode.prev_3020 = curr;
		}
		return head_3020;
	}
		//fungsi menambahkan node di posisi tertentu
	public static NodeDLL_2511533020 insertAtPosition(NodeDLL_2511533020 head_3020, int pos_3020, int new_data_3020) {
		// buat node baru
		NodeDLL_2511533020 new_node = new NodeDLL_2511533020(new_data_3020);
		if (pos_3020 == 1) {
			new_node.next_3020 = head_3020;
			if (head_3020 != null) {
			head_3020.prev_3020 = new_node;
		}
			head_3020 = new_node;
			return head_3020; 
	}
	
		NodeDLL_2511533020 curr = head_3020;
		for (int i_3020 = 1; i_3020 < pos_3020 - 1 && curr != null; ++i_3020) {
			curr = curr.next_3020; 
			}
		if (curr == null) {
			System.out.println("Posisi Tidak ada");
			return head_3020; 
			}
		new_node.prev_3020 = curr;
		new_node.next_3020 = curr.next_3020;
		curr.next_3020 = new_node;
		if (new_node.next_3020 != null) {
			new_node.next_3020.prev_3020 = new_node; 
			}
		return head_3020;
				
		}
	public static void printList(NodeDLL_2511533020 head_3020) {
		NodeDLL_2511533020 curr = head_3020;
		while (curr != null) {
			System.out.print(curr.data_3020 + " <-> ");
			curr = curr.next_3020;
					
		}
		System.out.println();
		
	}
	public static void main(String[] args) {
		// membuat dll 2 <-> 3 <-> 5
		NodeDLL_2511533020 head_3020 = new NodeDLL_2511533020(2) ;
		head_3020.next_3020 = new NodeDLL_2511533020(3);
		head_3020.next_3020.prev_3020 = head_3020;
		head_3020.next_3020.next_3020 = new NodeDLL_2511533020(5);
		head_3020.next_3020.next_3020.prev_3020 = head_3020.next_3020;
		//cetak DLL awal
		System.out.print("DLL Awal: ");
		printList(head_3020);
		//tambah 1 di awal
		head_3020 = insertBegin(head_3020, 1);
		System.out.print(
				"simpul 1 ditambah di awal: ");
		printList(head_3020);
		//tambah 6 di akhir
		System.out.print(
				"Simpul 6 ditambah di akhir: ");
		int data_3020 = 6;
		head_3020 = insertEnd(head_3020, data_3020);
		printList(head_3020);
		// menambah node 4 di posisi 4
		System.out.print("Tambah node 4 di Posisi 4: ");
		int data2_3020 = 4;
		int pos_3020 = 4;
		head_3020 = insertAtPosition(head_3020, pos_3020 ,data2_3020);
		printList(head_3020);
		

	}
}
