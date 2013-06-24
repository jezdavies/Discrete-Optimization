import java.util.ArrayList;
import java.util.List;

/**
 * 
 */

/**
 * @author jez.davies
 *
 */
public class Knapsack
{
	private int capacity;
	private List<Item> items;
	
	public Knapsack(int capacityIn)
	{
		capacity = capacityIn;
		items = new ArrayList<Item>();
	}
	public int getValue(){
		int value = 0;
		for(Item i : items)
		{
			value += i.getValue();
		}
		return value;
	}
	
	public int getWeight()
	{
		int weight = 0;
		for(Item i : items)
		{
			weight += i.getWeight();
		}
		return weight;
	}
	
	public void addItem(Item itemIn) throws Exception
	{
		int weightWithNewItem = getWeight() + itemIn.getWeight();
		if(weightWithNewItem <= capacity)
		{
			items.add(itemIn);
		}
		else
		{
			throw new Exception("Tried to add item to Knapsack that would exceed capacity.\nKnapsack Capacity = " + capacity + "\nCurrent Knapsack Weight = " + getWeight() + "\nNew Item Weight = " + itemIn.getWeight());
		}
	}
	
	public String toString()
	{
		String output = "Knapsack details:\n";
		output += "Capacity = " + capacity + "\n";
		output += "Weight = " + getWeight() + "\n";
		output += "Value = " + getValue() + "\n";
		output += "Knapsack Contents:\n";
		for(Item i : items)
		{
			output += i.toString() + "\n";
		}
		output += "--End--\n";
		return output;
		
	}
}
