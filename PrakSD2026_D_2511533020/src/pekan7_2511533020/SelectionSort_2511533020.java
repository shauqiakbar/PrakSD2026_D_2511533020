package pekan7_2511533020;

public class SelectionSort_2511533020 {
		public static void selectionSort (int[] arr) {
			int n_3020 = arr.length;
			for (int i_3020 = 0; i_3020 < n_3020; i_3020++) {
				int minIndex_3020 = i_3020;
				for (int j_3020 = i_3020 + 1; j_3020 < n_3020; j_3020++) {
					if (arr[j_3020] < arr[minIndex_3020]) {
						minIndex_3020 = j_3020;
					
					}
				}
				int temp_3020 = arr[i_3020];
				arr[i_3020] = arr[minIndex_3020];
				arr[minIndex_3020] = temp_3020;
				
			}
		}
		public static void main(String[] args) {
		int arr[] = { 23, 78, 45, 8, 32, 56, 1 };
		int n_3020 = arr.length;
		System.out.printf("array yang belum terurut:\n");
		for (int i_3020 = 0; i_3020 < n_3020; i_3020++)
			System.out.print(arr[i_3020] + " ");
		System.out.println("");
		selectionSort(arr);
		System.out.printf("array yang terurut:\n");
		for (int i_3020 = 0; i_3020 < n_3020; i_3020++)
			System.out.print(arr[i_3020] + " ");
		System.out.println("");
			
	}

}
