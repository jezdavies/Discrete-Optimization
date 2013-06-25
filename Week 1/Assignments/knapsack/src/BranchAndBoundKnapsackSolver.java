import java.util.List;

/**
 * 
 */

/**
 * @author jez.davies
 *
 */
public class BranchAndBoundKnapsackSolver extends KnapsackSolver {

	/* (non-Javadoc)
	 * @see KnapsackSolver#solve(int, int, java.util.List)
	 */
	@Override
	protected Knapsack solve(int numberOfItemsIn, int capacityIn,
			List<Item> itemsIn) throws Exception {
		// TODO Create implementation of BranchAndBound algorithm
		
		//PseudoCode
		//order items by valueToWeightRatio
		//starting with highest ratio item
		//		calculate maximum possible value for branch
		//		move to next item
		
		
		return null;
	}

}
