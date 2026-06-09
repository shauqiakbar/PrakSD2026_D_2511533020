package pekan9_2511533020;

public class Btree_2511533020 {
		private Node_2511533020 root_3020;
		private Node_2511533020 currentNode;
		public Btree_2511533020() {
			root_3020 = null;
		}
		public boolean search_3020(int data_3020) {
			return search_3020(root_3020, data_3020);
		}
		private boolean search_3020(Node_2511533020 node, int data_3020) {
			if (node.getData_3020() == data_3020)
				return true;
			if (node.getLeft() != null)
				if (search_3020(node.getLeft(), data_3020))
					return true;
			if (node.getRight() != null)
				if (search_3020(node.getRight(), data_3020))
					return true;
			return false;
		}
		public void printInorder_3020() {
			root_3020.printInorder_3020 (root_3020);
		}
		public void printPreorder_3020() {
			root_3020.printPreorder_3020(root_3020);
		}
		public void printPostorder_3020() {
			root_3020.printPostorder_3020(root_3020);
		}
		
		
		public Node_2511533020 getRoot_3020() {
			return root_3020;
		}
		public boolean isEmpty_3020() {
			return root_3020 == null;
		}
		
		public int countNodes_3020() {
			return countNodes_3020(root_3020);
		}
		private int countNodes_3020(Node_2511533020 node) {
			int count_3020 = 1;
			if (node == null) {
				return 0;
			} else {
				count_3020 += countNodes_3020(node.getLeft());
				count_3020 += countNodes_3020(node.getRight());
				return count_3020;
			}
		}
		public void print_3020() {
			root_3020.print_3020();
		}
		
		public Node_2511533020 getCurrent_3020() {
			return currentNode;
		}
		
		public void setCurrent_3020(Node_2511533020 node) {
			this.currentNode = node;
		}
		
		public void setRoot_3020(Node_2511533020 root_3020) {
			this.root_3020 = root_3020;
		}
		public void printPorstOrder_2511533020() {
			// TODO Auto-generated method stub
			
		}
}