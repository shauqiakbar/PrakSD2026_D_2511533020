package pekan8_2511533020;

public class MergeSort_2511533020 {
	void merge_3020(int arr_3020[], int l_3020, int m_3020, int r_3020) {
		int n1_3020 = m_3020 - l_3020 + 1;
		int n2_3020 = r_3020 - m_3020;
		
		int L_3020[] = new int[n1_3020];
		int R_3020[] = new int[n2_3020];
		
		for (int i_3020 = 0; i_3020 < n1_3020; ++i_3020)
			L_3020[i_3020] = arr_3020[l_3020 + i_3020];
		for (int j_3020 = 0; j_3020 < n2_3020; ++j_3020)
			R_3020[j_3020] = arr_3020[m_3020 + 1 + j_3020];
		
		int i_3020 = 0, j_3020 = 0;
		int k_3020 = l_3020;
		
		while (i_3020 < n1_3020 && j_3020 < n2_3020) {
			if (L_3020[i_3020] <= R_3020[j_3020]) {
				arr_3020[k_3020] = L_3020[i_3020];
				i_3020++;
			} else {
				arr_3020[k_3020] = R_3020[j_3020];
				j_3020++;
			}
			k_3020++;
		}
		
		while (i_3020 < n1_3020) {
			arr_3020[k_3020] = L_3020[i_3020];
			i_3020++;
			k_3020++;
		}
		
		while (j_3020 < n2_3020) {
			arr_3020[k_3020] = R_3020[j_3020];
			j_3020++;
			k_3020++;
		}
	}
	
	void sort_3020(int arr_3020[], int l_3020, int r_3020) {
		if (l_3020 < r_3020) {
			int m_3020 = (l_3020 + r_3020) / 2;
			sort_3020(arr_3020, l_3020, m_3020);
			sort_3020(arr_3020, m_3020 + 1, r_3020);
			merge_3020(arr_3020, l_3020, m_3020, r_3020);
		}
	}
	
	static void printArray_3020(int arr_3020[]) {
		int n_3020 = arr_3020.length;
		for (int i_3020 = 0; i_3020 < n_3020; ++i_3020)
			System.out.print(arr_3020[i_3020] + " ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		int arr_3020[] = { 12, 11, 13, 5, 6, 7 };
		System.out.println("Sebelum terurut");
		printArray_3020(arr_3020);
		MergeSort_2511533020 ob_3020 = new MergeSort_2511533020();
		ob_3020.sort_3020(arr_3020, 0, arr_3020.length - 1);
		System.out.println("\nSesudah Terurut menggunakan merge Sort");
		printArray_3020(arr_3020);
	}
}