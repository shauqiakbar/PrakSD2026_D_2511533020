package pekan3_2511533020;

public class stackArray_2511533020 {
	static final int MAX_3020 = 1000;
	int top_3020;
	int a_3020[] = new int [MAX_3020];
	boolean isEmpty_3020()
	{ 
		return (top_3020 < 0);
		
	}
	stackArray_2511533020()
	{
		top_3020 = -1;
	
	}
	boolean push(int x_3020)
	{
		if (top_3020 >= (MAX_3020 -1 )) {
			System.out.println("Stack Overflow");
			return false;
		}
		else {
	a_3020[++top_3020] = x_3020;
			System.out.println(x_3020 + "dimasukan dalam stack");
			return true;
		}
	}
	int pop_3020()
	{
		if (top_3020 < 0) {
			System.out.println("Stack Underflow");
			return 0;
		}
	
		else {
			int x_3020 = a_3020 [top_3020--];
			return x_3020;
			
		}
	}
		int peek_3020()
		{
			if (top_3020 < 0) {
				System.out.println("Stack Underflow");
				return 0;
			}
			else {
				int x_3020  = a_3020[top_3020];
				return x_3020;
		}
		}
		void print_3020 () {
			for(int i_3020 = top_3020; i_3020 > -1; i_3020--) {
				System.out.print(" "+ a_3020[i_3020]);
			}
		}
		
}