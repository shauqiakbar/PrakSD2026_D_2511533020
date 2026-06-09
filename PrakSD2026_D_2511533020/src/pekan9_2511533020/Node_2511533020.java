package pekan9_2511533020;

public class Node_2511533020 {
		int data_3020;
		Node_2511533020 left_3020;
		Node_2511533020 right_3020;
		public Node_2511533020(int data_3020) {
			this.data_3020 = data_3020;
			left_3020 = null;
			right_3020 = null;
		}
		public void setLeft_3020(Node_2511533020 node) {
			if (left_3020 == null)
				left_3020 = node;
		}
		public void setRight_3020(Node_2511533020 node) {
			if (right_3020 == null)
				right_3020 = node;
		}
		public Node_2511533020 getLeft() {
			return left_3020;
		}
		public Node_2511533020 getRight() {
			return right_3020;
		}
		public int getData_3020() {
		return data_3020;
		}
		public void setData(int data_3020) {
			this.data_3020 = data_3020;
		}
		
		void printPreorder_3020(Node_2511533020 node) {
			if (node == null)
			return;
			System.out.print(node.data_3020 + " ");
			printPreorder_3020(node.left_3020);
			printPreorder_3020(node.right_3020);
		}
		void printPostorder_3020(Node_2511533020 node) {
			if (node == null)
				return;
				printPostorder_3020(node.left_3020);
				printPostorder_3020(node.right_3020);
				System.out.print(node.data_3020 + " ");
			}
			void printInorder_3020(Node_2511533020 node) {
				if (node == null)
					return;
				printInorder_3020(node.left_3020);
				System.out.print(node.data_3020 + " ");
				printInorder_3020(node.right_3020);
				
			}
			public String print_3020() {
				return this.print("", true,"");
			}
			public String print(String prefix, boolean isTail, String sb ) {
				if (right_3020 != null) {
					right_3020.print(prefix + (isTail ? "|   " : "   "), false, sb);
			}
				System.out.println( prefix+(isTail ? "\\-- " : "/--")+data_3020);
				if (left_3020 != null) {
					left_3020.print(prefix+(isTail ? "  " : "|   "),true, sb); 
				}
				return sb;
		
			}
		}
