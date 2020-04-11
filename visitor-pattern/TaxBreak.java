import java.text.DecimalFormat;

class TaxBreak implements Visitor {
	DecimalFormat df = new DecimalFormat("#.##");
	private double cannedTax = 0.03;
	private double freshTax = 0.07;
	private double importedTax = 0.13;
	public TaxBreak() {}
	
	public double visit(Canned cannedItem) {
		System.out.println("Vising Canned item (TaxBreak)");
		return Double.parseDouble(df.format((cannedItem.getPrice() * cannedTax) + cannedItem.getPrice()));
	}
	
	public double visit(Fresh freshItem) {
		System.out.println("Vising Fresh item (TaxBreak)");
		return Double.parseDouble(df.format((freshItem.getPrice() * freshTax) + freshItem.getPrice()));
	}
	
	public double visit(Imported importedItem) {
		System.out.println("Vising Imported item (TaxBreak)");
		return Double.parseDouble(df.format((importedItem.getPrice() * importedTax) + importedItem.getPrice()));
	}
}
