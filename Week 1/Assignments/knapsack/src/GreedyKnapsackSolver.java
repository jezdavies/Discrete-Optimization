import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class GreedyKnapsackSolver implements KnapsackSolver {

	private List<Item> items;
	//private TreeSet<Node> nodes;
	private Node solutionNode; //node that will be used to store the best current solution node
	private int capacity;
	private int numberOfItems;
	
	/* (non-Javadoc)
	 * @see KnapsackSolver#solve(int, int, java.util.List)
	 */
	
	public Knapsack solve(int numberOfItemsIn, int capacityIn,
			List<Item> itemsIn) throws Exception {

		//store the parameters so they can be used throughout
		capacity = capacityIn;
		numberOfItems = numberOfItemsIn;
		items = itemsIn;
		
		//create the TreeSet that will hold our solution nodes - pass it a comparator
		//nodes = new TreeSet<Node>(Node.descendingEstimateNodeComparator);

		
		//return the Knapsack with the optimum contents
		return getOptimumSack();
		
	}
	
	private Knapsack getOptimumSack() throws Exception
	{
		//sort the items by their value/weight ratio
		Collections.sort(items, Item.descendingRatioItemComparator);
		//now just loop through the items and keep putting them in while you can
		int remainingCapactiy = capacity;
		List<Item> solutionItems = new ArrayList<Item>();
		Knapsack sack = new Knapsack(capacity);
		for(Item i: items){
			if(i.getWeight() <= remainingCapactiy){
				solutionItems.add(i);
				remainingCapactiy -= i.getWeight();
			}
			
		}
		//now sort the items back into the original order
		Collections.sort(items, Item.ascendingItemNumberItemComparator);
		//now for each item in the solution add it into the Knapsack;
		sack.replaceItemList(solutionItems);
		return sack;
	}

}
