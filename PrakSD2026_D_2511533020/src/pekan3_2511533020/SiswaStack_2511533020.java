package pekan3_2511533020;
import java.util.*;


class Siswa_2511533020 {
    String nama_3020;
    int nim_3020;
    public Siswa_2511533020(String nama_3020, int nim_3020) {
        this.nama_3020 = nama_3020;
        this.nim_3020 = nim_3020;
    }
    public String toString() {
        return "Nim: " + nim_3020 + ", Nama: " + nama_3020;
    }
}

public class SiswaStack_2511533020 {
    private ArrayList<Siswa_2511533020> stack;  
    

	
	public SiswaStack_2511533020() {
		stack = new ArrayList<>();
		
	}

	
	public void push(Siswa_2511533020 mhs) {
		stack.add(mhs);
	
	}
	public Siswa_2511533020 pop() {
		if (!isEmpty()) {
			return stack.remove(stack.size() - 1);
			
		}
		return null;
	}
	
	public Siswa_2511533020 peek() {
		if (!isEmpty()) {
			return stack.get((stack.size()) -1);
		}
		return null;
	}
	
	public boolean isEmpty() {
		return stack.isEmpty();
		
	}
	
	public void tampilkanSiswa_2511533020() {
		for (int i = stack.size() - 1; i >= 0; i--) {
			System.out.println(stack.get(i));
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SiswaStack_2511533020 studentStack = new SiswaStack_2511533020();
		
		Siswa_2511533020 mhs1 = new Siswa_2511533020("Ali", 1);
		Siswa_2511533020 mhs2 = new Siswa_2511533020("Boby", 2);
		Siswa_2511533020 mhs3 = new Siswa_2511533020("Charles", 3);
		
		studentStack.push(mhs1);
		studentStack.push(mhs2);
		studentStack.push(mhs3);
		
		System.out.println("Siswa di dalam stack");
		studentStack.tampilkanSiswa_2511533020();
		
		System.out.println("Siswa Teratas " + studentStack.peek());
		System.out.println("Mengeluarkan Siswa Teratas Dari Stack: " + studentStack.pop());
		System.out.println("daftar siswa setelah di pop :");
		studentStack.tampilkanSiswa_2511533020();

	}

}
