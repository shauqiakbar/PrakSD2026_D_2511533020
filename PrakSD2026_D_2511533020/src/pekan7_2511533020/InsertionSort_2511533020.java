package pekan7_2511533020;

public class InsertionSort_2511533020 {
	public static void insertionSort (int[] arr)	{
		int n_3020 = arr.length;
		for (int i_3020 = 1; i_3020 < n_3020; i_3020++) {
			int key_3020 = arr[i_3020];
			int j_3020 = i_3020 - 1;
			while (j_3020 >= 0 && arr[j_3020] > key_3020) {
				arr[j_3020 + 1] = arr[j_3020];
				j_3020--;
				
			}
			arr[j_3020 + 1] = key_3020;
		}
	}
		public static void main(String[] args) {
			int arr[] = { 23, 78, 45, 8, 32, 56, 1 };
			int n_3020 = arr.length;
			System.out.printf("array yang belum terurut:\n");
			for (int i_3020 = 0; i_3020 < n_3020; i_3020++)
				System.out.print(arr[i_3020] + " ");
			System.out.println("");
			insertionSort(arr);
			for (int i_3020 = 0; i_3020 < n_3020 ; i_3020++)
				System.out.print(arr[i_3020] + " " );
			System.out.println("");
				

			
			
		
		
	}
}
