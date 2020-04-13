//Visitor interface for Canned goods, Fresh goods, and Imported goods. 
interface Visitor {
	public double visit(Canned cannedItem);
	public double visit(Fresh freshItem);
	public double visit(Imported importedItem);
}