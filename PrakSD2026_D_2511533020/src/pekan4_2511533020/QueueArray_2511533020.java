package pekan4_2511533020;

public class QueueArray_2511533020 {
	int front_3020, rear_3020, size_3020;
	int capacity_3020;
	int array_3020[];
	
	public QueueArray_2511533020 (int capacity_3020) {
		this.capacity_3020 = capacity_3020;
		front_3020 = this.size_3020 = 0;
		rear_3020 = capacity_3020 -1;
		array_3020 = new int [this.capacity_3020];
	
	}
	boolean isFull(QueueArray_2511533020 queue) {
		return (queue.size_3020 == queue.capacity_3020);
	}
	boolean isEmpty(QueueArray_2511533020 queue) {
		return (queue.size_3020 == 0);
	}
	
	void enqueue_3020(int item_3020) {
		if (isFull(this))
			return;
		this.rear_3020 = (this.rear_3020 + 1) % this.capacity_3020;
		this.array_3020 [this.rear_3020] = item_3020;
		this.size_3020 = this.size_3020 + 1;
		System.out.println(item_3020 + " enqueued to queue");
		
	}
	int dequeue_3020() {
		if (isEmpty(this))
			return Integer.MIN_VALUE;
		int item_3020 = this.array_3020[this.front_3020];
		this.front_3020 = (this.front_3020 + 1) % this.capacity_3020;
		this.size_3020 = this.size_3020 - 1;
		return item_3020;
	}
	
	int front_3020() {
		if (isEmpty(this))
			return Integer.MIN_VALUE;
		
		return this.array_3020[this.front_3020];	
	}
	int rear_3020() {
		if (isEmpty(this))
			return Integer.MIN_VALUE;
		return this.array_3020[this.rear_3020];
		
	}
	//mencetak elemen antrian
	void display_3020() {
		int i_3020;
		if (front_3020 == rear_3020) {
			System.out.printf("\nAntrian Kosong\n");
			return;
			
		}
		//kunjungi dari belakang dan cetak
		for (i_3020 = front_3020; i_3020 < rear_3020; i_3020++) {
			System.out.printf(" %d <-- ", array_3020[i_3020]);
		}
		return;
	}
}
