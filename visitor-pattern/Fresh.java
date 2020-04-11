

public class Fresh implements Visitable{
	private double price;
	
	public Fresh(double price) {
		this.price = price;
	}
	
	public double accept(Visitor visitor) {
		return visitor.visit(this);
	}
	
	public double getPrice() {
		return this.price;
	}
}

