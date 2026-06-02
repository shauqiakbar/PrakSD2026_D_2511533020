package pekan8_2511533020;

public class QuickSort_2511533020 {
	static void swap(int[] arr_3020, int i_3020, int j_3020)
	{
		int temp_3020 = arr_3020[i_3020];
		arr_3020[i_3020] = arr_3020[j_3020];
		arr_3020[j_3020] = temp_3020;
		
	}
	// Metode tambahan untuk mengatur pivot menggunakan Median-of-Three
	static void medianOfThree(int[] arr_3020, int low_3020, int high_3020)
	{
		int mid_3020 = low_3020 + (high_3020 - low_3020) / 2;
		
		// Urutkan elemen low, mid, dan high
		if (arr_3020[low_3020] > arr_3020[mid_3020]) {
			swap(arr_3020, low_3020, mid_3020);
		}
		if (arr_3020[low_3020] > arr_3020[high_3020]) {
			swap(arr_3020, low_3020, high_3020);
		}
		if (arr_3020[mid_3020] > arr_3020[high_3020]) {
			swap(arr_3020, mid_3020, high_3020);
		}
		swap(arr_3020, mid_3020, high_3020);
	}
	static int partition(int[] arr_3020, int low_3020, int high_3020)
	{
		// Panggil fungsi medianOfThree sebelum menentukan pivot
		medianOfThree(arr_3020, low_3020, high_3020);
		
		int pivot_3020 = arr_3020[high_3020]; // Sekarang arr[high] sudah berisi nilai median
		int i_3020 = (low_3020 - 1);
		
		for (int j_3020 = low_3020; j_3020 <= high_3020 - 1; j_3020++) {
			// Jika elemen saat ini lebih kecil dari atau sama dengan pivot 
			if (arr_3020[j_3020] < pivot_3020) {
				// Increment indeks yang lebih kecil
				i_3020++;
				swap(arr_3020, i_3020, j_3020);
			}
		}
		swap(arr_3020, i_3020 + 1, high_3020);
		return (i_3020 + 1);
	}
	static void quickSort_2511533020(int[] arr_3020, int low_3020, int high_3020)
	{
		if (low_3020 < high_3020) {
			int pi_3020 = partition(arr_3020, low_3020, high_3020);
			quickSort_2511533020(arr_3020, low_3020, pi_3020 - 1);
			quickSort_2511533020(arr_3020, pi_3020 + 1, high_3020);
			
		}
	}
	
	public static void printArr_2511533020(int[] arr_3020)
	{
		for (int i_3020 = 0; i_3020 < arr_3020.length; i_3020++) {
			System.out.print(arr_3020[i_3020] + " ");
			
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
	
	int[] arr_3020 = { 10, 7, 8, 1, 5 };
	int N_3020 = arr_3020.length;
	System.out.print("Data sebelum diurutkan: ");
	printArr_2511533020(arr_3020);
	
	quickSort_2511533020(arr_3020, 0, N_3020 - 1);
	
	System.out.print("Data Terurut quickSort: ");
	printArr_2511533020(arr_3020);
	
		}
	
}

