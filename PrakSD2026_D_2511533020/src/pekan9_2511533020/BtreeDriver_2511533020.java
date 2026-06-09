package pekan9_2511533020;

public class BtreeDriver_2511533020 {

	public static void main(String[] args) {
		// Membuat Pohon
		Btree_2511533020 tree_3020 = new Btree_2511533020();
		System.out.print("Jumlah Simpul awal pohon: ");
		System.out.println(tree_3020.countNodes_3020());
		// menambahkan simpul data 1
		Node_2511533020 root_3020 = new Node_2511533020(1);
		// menjadikan simpul 1 sebagai root
		tree_3020.setRoot_3020(root_3020);
		System.out.println("Jumlah simpul jika hanya ada root");
		System.out.println(tree_3020.countNodes_3020());
		Node_2511533020 node2_3020 = new Node_2511533020(2);
		Node_2511533020 node3_3020 = new Node_2511533020(3); 
		Node_2511533020 node4_3020 = new Node_2511533020(4);
		Node_2511533020 node5_3020 = new Node_2511533020(5);
		Node_2511533020 node6_3020 = new Node_2511533020(6);
		Node_2511533020 node7_3020 = new Node_2511533020(7);
		Node_2511533020 node8_3020 = new Node_2511533020(8);
		Node_2511533020 node9_3020 = new Node_2511533020(9);
		root_3020.setLeft_3020(node2_3020);
		node2_3020.setLeft_3020(node4_3020);
		node2_3020.setRight_3020(node5_3020);
		node4_3020.setRight_3020(node8_3020);
		root_3020.setRight_3020(node3_3020);
		node3_3020.setLeft_3020(node6_3020);
		node3_3020.setRight_3020(node7_3020);
		node6_3020.setLeft_3020(node9_3020);
		// Set root
		tree_3020.setCurrent_3020(tree_3020.getRoot_3020());
		System.out.println("Menampilkan simpul terakhir : ");
		System.out.println(tree_3020.getCurrent_3020().getData_3020());
		System.out.println("Jumlah simpul; setelah simpul 7 ditambahkan ");
		System.out.println(tree_3020.countNodes_3020());
		System.out.println("InOrder: ");
		tree_3020.printInorder_3020();
		System.out.println("\nPreorder : ");
		tree_3020.printPreorder_3020();
		System.out.println("\nPostorder :");
		tree_3020.printPostorder_3020();
		System.out.println("\nmenampilkan simpul dalam bentuk pohon");
		tree_3020.print_3020();
	}

}