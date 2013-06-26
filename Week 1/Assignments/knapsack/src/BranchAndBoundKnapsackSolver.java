import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 */

/**
 * @author jez.davies
 *
 */
public class BranchAndBoundKnapsackSolver extends KnapsackSolver {

	private List<Item> items;
	//private TreeSet<Node> nodes;
	private Node solutionNode; //node that will be used to store the best current solution node

	
	/* (non-Javadoc)
	 * @see KnapsackSolver#solve(int, int, java.util.List)
	 */
	@Override
	protected Knapsack solve(int numberOfItemsIn, int capacityIn,
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
		
		//calculate the root node optimistic evaluation
		int rootOptimisticEvaluation = calculateRootOptimisticEvaluation();
		
		
		//create root node
		Node rootNode = new Node(0, capacity, rootOptimisticEvaluation, 0, new ArrayList<Integer>());
		//now recursively process the node and all it's possible children
		processNode(rootNode);

		//we now have the best node so create the corresponding knapsack
		return createKnapsackFromNode(solutionNode);
	}
	


	private int calculateRootOptimisticEvaluation() {
		// TODO create sensible implementation of calculating rootOptimisticEvaluation based upon relaxation of ability to take only part of an item
		int evaluation = 0;		
		for (Item i : items){
			evaluation += i.getValue();
		}
		return evaluation;
	}

	private void processNode(Node currentNode){
		
		//check if it's worth processing this node (i.e. we don't have a solution node yet
		// or the current node's estimate greater than or equal to the actual value of the current best solution node)
		
		if((solutionNode == null) || (currentNode.getEstimate() >= solutionNode.getValue())){
			//it's worth processing
			//check to see if this Node is the node for the final item in the list
			if(currentNode.getItemIndex() <(items.size() -1)){
				//it's not the last item in the list so let's create the child nodes to represent taking or not taking the next item
				//get the item that is next in the list
				int nextItemIndex = currentNode.getItemIndex()+1;
				Item nextItem = items.get(nextItemIndex);
				//create the child nodes for this node
				createPositiveNode(currentNode, nextItemIndex, nextItem);
				createNegativeNode(currentNode, nextItemIndex, nextItem);
			} else{
				//it is the last item in the list so add this node to the list of solution nodes if it's better than the current solution node
				if((solutionNode == null) || (currentNode.getValue() > solutionNode.getValue())){
					solutionNode = currentNode;
				}
				
			}
		
		}
		
	}



	private void createPositiveNode(Node currentNode, int nextItemIndex,
			Item nextItem) {
		//check whether taking the next item would exceed the capacity - if it would then don't create the node and process it
		if((currentNode.getRoom() - nextItem.getWeight()) >= 0)
		{
			//we have room for the next item so create a node to represent doing this
			//create the list of itemIDs that includes taking the next item
			List<Integer> newItemIDsList = new ArrayList<Integer>(currentNode.getItemIDs());
			newItemIDsList.add(new Integer(nextItem.getItemNumber()));
			
			//now create the node that represents if we take the next item
			Node positiveNode = new Node(currentNode.getValue() + nextItem.getValue(),
										 currentNode.getRoom() - nextItem.getWeight(),
										 currentNode.getEstimate(), 
										 nextItemIndex, 
										 newItemIDsList);
			//now process the node
			processNode(positiveNode);
		}		

	}
	
	private void createNegativeNode(Node currentNode, int nextItemIndex,
			Item nextItem) {
		//now create the node that represents if we don't take the next item
		Node negativeNode = new Node(currentNode.getValue(), 
									 currentNode.getRoom(), 
									 currentNode.getEstimate() - nextItem.getValue(), 
									 nextItemIndex, 
									 new ArrayList<Integer>(currentNode.getItemIDs()));
		processNode(negativeNode);
	}
	
	private Knapsack createKnapsackFromNode(Node solutionNode) throws Exception {
		Knapsack sack = new Knapsack(capacity);
		//sort the items back into descending order by ItemNumber
		
		Collections.sort(items,  Item.ascendingItemNumberItemComparator);
		//now loop through the list of items and if it's contained in the node's list of itemIDs then add it into the sack
		for(Item item: items){
			if(solutionNode.getItemIDs().contains(item.getItemNumber()))
			{
				sack.addItem(item);
			}
		}
		
		return sack;
	}

}
