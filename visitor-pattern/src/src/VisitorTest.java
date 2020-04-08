package src;

public class VisitorTest {
	public static void main(String [] args) {
		
		TaxVisitor taxCalc = new TaxVisitor();
		
		Canned peaches = new Canned(2.49);
		Fresh bread = new Fresh(5.79);
		Imported wine = new Imported(23.99);
		
		System.out.println("Peaches: " + peaches.accept(taxCalc));
		System.out.println("Peaches: " + bread.accept(taxCalc));
		System.out.println("Peaches: " + wine.accept(taxCalc));
	}
}
