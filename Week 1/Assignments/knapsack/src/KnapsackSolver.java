import java.util.List;

public interface KnapsackSolver {

	
	Knapsack solve(int numberOfItemsIn, int capacityIn, List<Item> itemsIn)
			throws Exception;

}