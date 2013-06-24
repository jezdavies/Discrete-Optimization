import java.util.List;

public abstract class KnapsackSolver {

	protected List<Item> items;

	protected abstract Knapsack solve(int numberOfItemsIn, int capacityIn, List<Item> itemsIn)
			throws Exception;

	protected int capacity;

	public KnapsackSolver() {
		super();
	}

}