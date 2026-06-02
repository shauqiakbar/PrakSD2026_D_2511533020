package pekan8_2511533020;

public class ShellShort_2511533020 {
	
	public static void shellSort_2511533020 (int[] A_3020) {
		int n_3020 = A_3020.length;
		int gap_3020 = n_3020 / 2;
		while (gap_3020 > 0) {
			for (int i_3020 = gap_3020; i_3020 < n_3020; i_3020++ )  {
				int temp_3020 = A_3020[i_3020];
				int j_3020 = i_3020;
				while (j_3020 >= gap_3020 && A_3020[j_3020 - gap_3020] > temp_3020) {
					A_3020[j_3020] = A_3020[j_3020 - gap_3020];
					j_3020 = j_3020 - gap_3020;
					
				}
				A_3020[j_3020] = temp_3020;
			}
			gap_3020 = gap_3020 / 2;
		}
	}
	

	public static void main(String[] args) {
		int[] data = {3, 10, 4, 6, 8, 9, 7, 2, 1, 5};
		
		System.out.print("Sebelum: ");
		printArray(data);
		
		shellSort_2511533020(data);
		
		System.out.print("Sesudah (Shell Sort): ");
		printArray(data);
		
		}
		
		public static void printArray(int[] arr) {
			for (int i_3020 : arr) System.out.print(i_3020 + " ");
			System.out.println();
		}

	}


