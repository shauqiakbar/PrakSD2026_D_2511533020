package pekan7_2511533020;

public class BubleSort_2511533020 {
	public static void bubbleSort (int[] arr) {
		int n_3020 = arr.length;
		for (int i_3020 = 0; i_3020 < n_3020; i_3020++) {
			for(int j_3020 = 0; j_3020 < n_3020 - i_3020 - 1; j_3020++) {
				if (arr[j_3020] > arr[j_3020 + 1]) {
					int temp_3020 = arr[j_3020];
					arr[j_3020 + 1] = temp_3020;
				// System.out.println("data:"+arr[j]+" "+arr[j+1]);
				}
			}
		}
		
	}
	public static void main(String[] args) {
		int arr[] = { 23, 78, 45, 8, 32, 56, 1 };
		int n_3020 = arr.length;
		System.out.print("array yang belum terurut:");
		for (int i_3020 = 0; i_3020 < n_3020; i_3020++)
			System.out.print(arr[i_3020] + " ");
		System.out.println("");
		bubbleSort(arr);
		System.out.print("array yang belum menggunakan Buble Sort:");
		for (int i_3020 = 0; i_3020 < n_3020; i_3020++)
			System.out.print(arr[i_3020] + " ");
		System.out.println(" ");

	}

}
