package pekan2_2511533020;
import java.util.ArrayList;
public class ArrayList1_2511533020 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Size of the ArrayList
		int n = 5;
		//Declaring the ArrayList with initial size n
		ArrayList<Integer> arrli = new ArrayList<Integer>(n);
		//Apending new elements at the end of the list
		for (int i = 1; i <= n; i++)
			arrli.add(i);
		//Printing elements
		System.out.println(arrli);
		//Remove elements at index 3
		arrli.remove(3);
		//Displaying the ArrayList
		//after deletion
		System.out.println(arrli);
		///Printing elements one by one
		for (int i = 0; i < arrli.size(); i++)
			System.out.print(arrli.get(i) + " ");
	}
	
}
