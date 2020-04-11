import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		if(args.length == 1 && args[0].equals("test")) {
			testVisitor();
		}
		else {
			TaxVisitor taxCalc = new TaxVisitor();
			TaxBreak taxBreak = new TaxBreak();
			
			Canned peaches = new Canned(2.49);
			Fresh bread = new Fresh(5.80);
			Imported wine = new Imported(23.99);
			

			System.out.println("Peaches price after tax: " + peaches.accept(taxCalc));
			System.out.println("Bread price after tax: " + bread.accept(taxCalc));
			System.out.println("Wine price after tax: " + wine.accept(taxCalc));

			System.out.println("\n--Tax Break--\n");

			System.out.println("Peaches price after tax break: " + peaches.accept(taxBreak));
			System.out.println("Bread price after tax break: " + bread.accept(taxBreak));
			System.out.println("Wine price after tax break: " + wine.accept(taxBreak));
		}
	}

	public static void testVisitor() {
		TaxVisitor taxCalc = new TaxVisitor();
		TaxBreak taxBreak = new TaxBreak();
			
		Canned peaches = new Canned(3.09);
		Fresh bread = new Fresh(6.89);
		Imported wine = new Imported(25.98);

		assert peaches.accept(taxCalc) == 3.37;
		assert bread.accept(taxCalc) == 7.85;
		assert wine.accept(taxCalc) == 31.96;

		System.out.println();

		assert peaches.accept(taxBreak) == 3.18;
		assert bread.accept(taxBreak) == 7.37;
		assert wine.accept(taxBreak) == 29.36;
		
		System.out.println();
		
		System.out.println("All test cases passed!");
	}
}
