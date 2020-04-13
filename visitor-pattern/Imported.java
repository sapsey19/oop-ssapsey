public class Imported implements Visitable {
	private double price;
	
	public Imported(double price) {
		this.price = price;
	}
	
	public double accept(Visitor visitor) {
		return visitor.visit(this);
	}
	
	public double getPrice() {
		return this.price;
	}
}