package pekan5_2511533020;

public class PencarianSLL_251153020 {
	static boolean searchKey_3020(NodeSLL_2511533020 head_3020, int key_3020) {
		NodeSLL_2511533020 curr_3020 = head_3020;
		while (curr_3020 != null) {
			if (curr_3020.data_3020 == key_3020) 
				return true;
		curr_3020 = curr_3020.next_3020;	}
		return false; }
	public static void traversal (NodeSLL_2511533020 head_3020) {
		//mulai dari head
		NodeSLL_2511533020 curr_3020 = head_3020;
		//telusuri sampai pointer null
		while (curr_3020 != null) {
			System.out.print(" " + curr_3020.data_3020);
			curr_3020 = curr_3020.next_3020; }
		System.out.println(); }
		public static void main(String[] args) {
			NodeSLL_2511533020 head_3020 = new NodeSLL_2511533020(14);
			head_3020.next_3020 = new NodeSLL_2511533020(21);
			head_3020.next_3020.next_3020 = new NodeSLL_2511533020(13);
			head_3020.next_3020.next_3020.next_3020 = new NodeSLL_2511533020(30);
			head_3020.next_3020.next_3020.next_3020.next_3020 = new NodeSLL_2511533020(10);
			System.out.print("Penelusuran SLL : ");
			traversal(head_3020);
			//data yang akan dicari 
			int key_3020 = 30;
			System.out.print("cari data " +key_3020+ " = ");
			if (searchKey_3020(head_3020, key_3020))
				System.out.println("ketemu");
			else
				System.out.println("tidak ada");
			
		
	}

}
