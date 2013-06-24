
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

}
