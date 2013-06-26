import java.util.Comparator;


public class Item
{
	
	private int itemNumber;
	private int value;
	private int weight;
	
	public int getItemNumber()
	{
		return itemNumber;
	}
	public int getValue()
	{
		return value;
	}

	public int getWeight()
	{
		return weight;
	}
	
	public Double getValueWeightRatio()
	{
		Double ratio = new Double((double) value/weight);
		return ratio;
	}

	public Item(int itemNumber_in,int value_in,int weight_in)
	{
		itemNumber = itemNumber_in;
		value = value_in;
		weight = weight_in;
	}
	
	public String toString()
	{
		String output = "Item Details:\n";
		output += "itemNumber = " + itemNumber + "\n";
		output += "value = " + value + "\n";
		output += "weight = " + weight + "\n";
		output += "--End item details--";
		return output;
	}
	
	public static Comparator<Item> descendingRatioItemComparator = new Comparator<Item>(){
		public int compare(Item item1, Item item2){
			Double item1Ratio = new Double(item1.getValueWeightRatio());
			Double item2Ratio = new Double(item2.getValueWeightRatio());
			//use descending order
			int compareResult = item2Ratio.compareTo(item1Ratio);
			return compareResult;
		}
	};
	
	public static Comparator<Item> ascendingItemNumberItemComparator = new Comparator<Item>(){
		public int compare(Item item1, Item item2){
			Integer itemID1 = new Integer(item1.getItemNumber());
			Integer itemID2 = new Integer(item2.getItemNumber());
			//use ascending order
			int compareResult = itemID1.compareTo(itemID2);
			return compareResult;
		}
	};


}
