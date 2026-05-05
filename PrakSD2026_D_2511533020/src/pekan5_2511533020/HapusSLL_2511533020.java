package pekan5_2511533020;


public class HapusSLL_2511533020 {

    public static NodeSLL_2511533020 deletehead_3020(NodeSLL_2511533020 head_3020) {
        if (head_3020 == null) return null;
        head_3020 = head_3020.next_3020;
        return head_3020;
    }

    public static NodeSLL_2511533020 removeLastNode_3020(NodeSLL_2511533020 head_3020) {
        if (head_3020 == null) return null;
        if (head_3020.next_3020 == null) return null;
        NodeSLL_2511533020 secondLast_3020 = head_3020;
        while (secondLast_3020.next_3020.next_3020 != null) {
            secondLast_3020 = secondLast_3020.next_3020;
        }
        secondLast_3020.next_3020 = null;
        return head_3020;
    }

    public static NodeSLL_2511533020 deleteNode_3020(NodeSLL_2511533020 head_3020, int position_3020) {
        if (head_3020 == null) return head_3020;
        if (position_3020 == 1) {
            return head_3020.next_3020;
        }
        NodeSLL_2511533020 temp_3020 = head_3020;
        NodeSLL_2511533020 prev_3020 = null;
        for (int i_3020 = 1; temp_3020 != null && i_3020 < position_3020; i_3020++) {
            prev_3020 = temp_3020;
            temp_3020 = temp_3020.next_3020;
        }
        if (temp_3020 != null) {
            prev_3020.next_3020 = temp_3020.next_3020;
        } else {
            System.out.println("Data tidak ada");
        }
        return head_3020;
    }

    public static void printList_3020(NodeSLL_2511533020 head_3020) {
        if (head_3020 == null) {
            System.out.println("List kosong");
            return;
        }
        NodeSLL_2511533020 curr_3020 = head_3020;
        while (curr_3020.next_3020 != null) {
            System.out.print(curr_3020.data_3020 + "-->");
            curr_3020 = curr_3020.next_3020;
        }
        System.out.print(curr_3020.data_3020);
        System.out.println();
    }

    public static void main(String[] args) {
        NodeSLL_2511533020 head_3020 = new NodeSLL_2511533020(1);
        head_3020.next_3020 = new NodeSLL_2511533020(2);
        head_3020.next_3020.next_3020 = new NodeSLL_2511533020(3);
        head_3020.next_3020.next_3020.next_3020 = new NodeSLL_2511533020(4);
        head_3020.next_3020.next_3020.next_3020.next_3020 = new NodeSLL_2511533020(5);
        head_3020.next_3020.next_3020.next_3020.next_3020.next_3020 = new NodeSLL_2511533020(6);

        System.out.println("List awal: ");
        printList_3020(head_3020);

        head_3020 = deletehead_3020(head_3020);
        System.out.println("List setelah head dihapus: ");
        printList_3020(head_3020);

        head_3020 = removeLastNode_3020(head_3020);
        System.out.println("List setelah simpul terakhir dihapus: ");
        printList_3020(head_3020);

        int position_3020 = 2;
        head_3020 = deleteNode_3020(head_3020, position_3020);
        System.out.println("List setelah posisi 2 dihapus: ");
        printList_3020(head_3020);
    }
}