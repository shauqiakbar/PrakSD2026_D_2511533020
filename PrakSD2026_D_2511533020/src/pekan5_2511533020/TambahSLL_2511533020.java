package pekan5_2511533020;

public class TambahSLL_2511533020 {
	public static NodeSLL_2511533020 insertAtFront (NodeSLL_2511533020 head_3020, int value_3020) {
		NodeSLL_2511533020 new_node = new NodeSLL_2511533020(value_3020);
		new_node.next_3020 = head_3020;
		return new_node;
		
	}
	// fungsi menambahkan node di akhir SLL
	public static NodeSLL_2511533020 insertAtEnd(NodeSLL_2511533020 head_3020, int value_3020) {
			//buat sebuah node dengan sebuah nilai
		NodeSLL_2511533020 newNode = new NodeSLL_2511533020(value_3020);
		// jika list kosong maka node jadi head
		if (head_3020 == null ) {
			return newNode;
			
		}
		//Simpan Head ke variabel sementara
		NodeSLL_2511533020 last = head_3020;
		//telusuri ke node akhir
		while (last.next_3020 != null) {
			last = last.next_3020;
			
		}
		//ubah pointer
		last.next_3020 = newNode;
		return head_3020;
		
	}
		static NodeSLL_2511533020 GetNode(int data_3020) {
			return new NodeSLL_2511533020  (data_3020);
			}
		
		static NodeSLL_2511533020 insertPos(NodeSLL_2511533020 headNode, int position_3020, int value_3020) {
			NodeSLL_2511533020 head_3020 = headNode;
			if (position_3020 < 1)
				System.out.print("Invalid Position");
			if (position_3020 == 1) {
				NodeSLL_2511533020 new_node = new NodeSLL_2511533020(value_3020);
				new_node.next_3020 = head_3020;
				return new_node;
			} else { 
				while (position_3020-- != 0) {
					if (position_3020 == 1) {
						NodeSLL_2511533020 newNode = GetNode(value_3020);
						newNode.next_3020 = headNode.next_3020;
						headNode.next_3020 = newNode;
						break;
							
					}
					headNode = headNode.next_3020;
					
				}
				if (position_3020 != 1)
					System.out.print("Posisi di luar jangkauan"); }
			
				return head_3020;
				}
				public static void printList(NodeSLL_2511533020 head_3020) {
					NodeSLL_2511533020 curr_3020 = head_3020;
					while (curr_3020.next_3020 != null) {
						System.out.print(curr_3020.data_3020+"-->");
						curr_3020 = curr_3020.next_3020;
						
					}
					if (curr_3020.next_3020==null) {
						System.out.print(curr_3020.data_3020);
						System.out.println();
					}
				}
					public static void main(String[] args) {
						//buat linked list 2->3->5->6
						NodeSLL_2511533020 head_3020 = new NodeSLL_2511533020(2);
						head_3020.next_3020 = new NodeSLL_2511533020(3);
						head_3020.next_3020.next_3020 = new NodeSLL_2511533020(5);
						head_3020.next_3020.next_3020.next_3020 = new NodeSLL_2511533020(6);
						//cetak list asli
						System.out.print("Senarai berantai awal:");
						printList(head_3020);
						//tambahkan node baru di depan 
						System.out.print("tambah 1 simpul di depan:");
						int data_3020 = 1;
						head_3020 = insertAtFront(head_3020, data_3020);
						//cetak update list
						printList(head_3020);
						// tambahkan node baru di belakang
						System.out.print("tambah 1 simpul di belakang:");
						int data2_3020 = 7;
						head_3020 = insertAtEnd(head_3020, data2_3020);
						//cetak update list
						printList(head_3020);
						System.out.print("tambah 1 simpul ke data 4:");
						int data3_3020 = 4;
						int pos_3020 = 4;
						head_3020 = insertPos(head_3020, pos_3020, data3_3020);
						// cetak update list
						printList(head_3020);
							
				}
				
			}