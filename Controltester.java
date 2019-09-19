import java.io.FileNotFoundException;

public class Controltester {
	public static void main(String[] args) throws FileNotFoundException {
		Control test = new Control();
		
		test.printOutput();
		System.out.print(test.rowTest(2, 28));
		System.out.print(test.colTest(2, 42));
		System.out.print(test.sectionTest(9, 66));
		test.accessData();
	}
}
