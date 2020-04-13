//Interface for all items that need a visitor
interface Visitable {
	public double accept(Visitor visitor);
}