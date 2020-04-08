package src;

import java.text.DecimalFormat;

class TaxVisitor implements Visitor {
	DecimalFormat df = new DecimalFormat("#.##");
	private double cannedTax = 0.09;
	private double freshTax = 0.14;
	private double importedTax = 0.23;
	public TaxVisitor() {}
	
	public double visit(Canned cannedItem) {
		System.out.println("Liquor Item: Price with tax");
		return Double.parseDouble(df.format((cannedItem.getPrice() * cannedTax) + cannedItem.getPrice()));
	}
	
	public double visit(Fresh freshItem) {
		System.out.println("Liquor Item: Price with tax");
		return Double.parseDouble(df.format((freshItem.getPrice() * freshTax) + freshItem.getPrice()));
	}
	
	public double visit(Imported importedItem) {
		System.out.println("Liquor Item: Price with tax");
		return Double.parseDouble(df.format((importedItem.getPrice() * importedTax) + importedItem.getPrice()));
	}
}