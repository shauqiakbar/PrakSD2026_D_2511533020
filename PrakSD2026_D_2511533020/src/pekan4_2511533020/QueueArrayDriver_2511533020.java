package pekan4_2511533020;

public class QueueArrayDriver_2511533020 {
		public static void main(String[] args) {
			QueueArray_2511533020 queue_3020 = new QueueArray_2511533020(1000) ;
			queue_3020.enqueue_3020(10);
			queue_3020.enqueue_3020(20);
			queue_3020.enqueue_3020(30);
			queue_3020.enqueue_3020(40);
			System.out.println("Item di depan" + queue_3020.front_3020());
			System.out.println("Item paling belakang" + queue_3020.rear_3020());
			System.out.println("tampilan queue");
			queue_3020.display_3020();
			System.out.println(queue_3020.dequeue_3020() + " dihapus dari queue");
			System.out.println("item di depan: " + queue_3020.front_3020());
			System.out.println("item di belakang: " + queue_3020.rear_3020());
			System.out.println("tampilan queue setelah satu data dihapus");
			queue_3020.display_3020();
			
			
		}
}
